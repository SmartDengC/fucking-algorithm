package org.hahadeng.util;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.Predicate;

/**
 * API调用重试
 *
 * @author 邓聪
 * @since 2026/3/17 21:08
 */
public class RetryUtils {

    private static final Random RANDOM = new Random();

    /**
     * 带有指数退避和 Full Jitter 的重试执行器
     *
     * @param action             需要执行的具体业务逻辑
     * @param maxRetries         最大重试次数
     * @param baseDelayMs        基础等待时间（毫秒）
     * @param maxDelayMs         最大等待时间上限（毫秒）
     * @param retryablePredicate 判断异常是否需要重试的条件
     * @param <T>                返回值类型
     * @return 业务执行结果
     * @throws Exception 如果达到最大重试次数或遇到不可重试的异常，则抛出
     */
    public static <T> T executeWithRetry(
            Callable<T> action,
            int maxRetries,
            long baseDelayMs,
            long maxDelayMs,
            Predicate<Exception> retryablePredicate) throws Exception {

        int attempt = 0;

        while (true) {
            try {
                // 1. 尝试执行业务逻辑
                return action.call();
            } catch (Exception e) {
                // 2. 判断是否超过最大重试次数，或者该异常是否属于不该重试的类型（如 401 权限错误）
                if (attempt >= maxRetries || !retryablePredicate.test(e)) {
                    // 直接向上抛出，不再重试
                    throw e;
                }

                // 3. 计算指数退避时间：base * 2^n，并用 maxDelayMs 兜底
                // 注意：这里使用位运算 1L << attempt 来高效计算 2 的 attempt 次方
                long exponentialBackoff = Math.min(maxDelayMs, baseDelayMs * (1L << attempt));

                // 4. 引入 Full Jitter (完全抖动)：在 0 到指数退避时间之间取随机数
                long jitterDelay = (long) (RANDOM.nextDouble() * exponentialBackoff);

                // 打印日志（生产环境中请替换为 log.warn）
                System.out.printf("[Retry] 接口调用失败，第 %d 次重试将在 %d ms 后进行。异常信息: %s%n",
                        attempt + 1, jitterDelay, e.getMessage());

                // 5. 线程休眠等待
                try {
                    Thread.sleep(jitterDelay);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // 恢复中断状态
                    throw new RuntimeException("重试等待被中断", ie);
                }

                attempt++;
            }
        }
    }

    // --- 使用示例 ---
    public static void main(String[] args) {
        try {
            String result = executeWithRetry(
                    () -> {
                        // 这里模拟调用第三方获取实时数据的 API（例如：拉取现货黄金价格）
                        System.out.println("尝试调用第三方 API...");
                        double random = Math.random();
                        if (random < 0.8) { // 模拟 80% 的概率会发生网络超时
                            throw new RuntimeException("API Connection Timeout");
                        }
                        return "{\"price\": 2050.50, \"status\": \"success\"}";
                    },
                    // 最大重试 5 次
                    5,
                    // 基础延迟 100ms
                    100,
                    // 最大延迟 2000ms (2秒)
                    2000,
                    // 只针对特定异常重试（这里简单模拟：只要消息里包含 Timeout 就重试）
                    e -> e.getMessage().contains("Timeout")
            );

            System.out.println("调用成功，结果: " + result);

        } catch (Exception e) {
            System.err.println("最终调用失败: " + e.getMessage());
        }
    }
}