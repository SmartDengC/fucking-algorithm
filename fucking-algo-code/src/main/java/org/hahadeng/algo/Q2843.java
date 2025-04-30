package org.hahadeng.algo;

/**
 * @author 邓聪
 * @since 2025/4/11 17:10
 */
public class Q2843 {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        for (int i = low; i <= high; i++) {
            char[] s = Integer.toString(i).toCharArray();
            int n = s.length;
            if (n % 2 > 0) {
                continue;
            }
            int diff = 0;
            for (int j = 0; j < n / 2; j++) {
                diff += s[j];
            }

            for (int j = n / 2; j < n; j++) {
                diff -= s[j];
            }
            if (diff == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q2843 q2843 = new Q2843();
//        System.out.println(q2843.countSymmetricIntegers(1200, 1230));

        String string = Integer.toString(10, 2);
        String binaryString = Integer.toBinaryString(10);
        System.out.println(binaryString);

    }
}
