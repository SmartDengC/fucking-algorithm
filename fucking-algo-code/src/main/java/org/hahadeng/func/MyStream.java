package org.hahadeng.func;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 邓聪
 */
public class MyStream {

    @Test
    public void test() {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ints.forEach(System.out::println);
        ints.forEach(x -> System.out.println(x + 1));

        List<String> names = Arrays.asList("张三", "李四", "王五", "放牛娃小邓", "养鸡娃小姚");
        // 顺序流
        names.stream().filter(name -> name.length() == 2).forEach(System.out::println);

        // 并行流
        names.parallelStream().filter(name -> name.length() == 2 ).forEach(System.out::println);

        int[] a = {1,2,3};
        int[] b = new int[]{1,2,3};

        Optional<Integer> first = ints.stream().filter(x -> x > 2).findFirst();
        first.ifPresent(System.out::println);
        Optional<Integer> first1 = ints.stream().parallel().filter(x -> x > 2).findFirst();
        first.ifPresent(System.out::println);

        List<Integer> collect = ints.stream().filter(x -> x > 2).collect(Collectors.toList());

        names.stream().max(Comparator.comparing(String::length)).ifPresent(System.out::println);
        ints.stream().max(Comparator.comparing(Integer::valueOf)).ifPresent(System.out::println);
    }

    @Test
    public void test2() {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<String> names = Arrays.asList("张三", "李四", "王五", "放牛娃小姚", "养鸡娃小邓");

        ints.stream().max(Comparator.comparing(Integer::intValue)).ifPresent(System.out::println);
        ints.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).ifPresent(System.out::println);
        names.stream().max(Comparator.comparing(String::length)).ifPresent(System.out::println);

        System.out.println(ints.stream().filter(x -> x > 2).count());
    }

    @Test
    public void test3() {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<String> words = Arrays.asList("In", "the", "Day", "I", "am", "very", "happy");
        words.stream().map(String::toUpperCase).forEach(System.out::println);
        ints.stream().map(x -> x + 2).forEach(System.out::println);
    }
    @Test
    public void test4() {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        // 求和
        Optional<Integer> reduce = ints.stream().reduce(Integer::sum);
        Integer reduce1 = ints.stream().reduce(0, Integer::sum);
        Integer reduce2 = ints.stream().reduce(0, (x, y) -> x + y);
        // 求乘积
        Optional<Integer> reduce4 = ints.stream().reduce((x, y) -> x * y);
        // 求最大值
        ints.stream().max(Integer::compareTo).ifPresent(System.out::println);
        Optional<Integer> reduce3 = ints.stream().reduce((x, y) -> x > y ? x : y);
        Integer reduce5 = ints.stream().reduce(1, Integer::max);
    }

    @Test
    public void test5() {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> newInts = ints.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
        Set<Integer> newInts2 = ints.stream().filter(x -> x % 2 == 1).collect(Collectors.toSet());
    }
    @Test
    public void test6() {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 9, 8));
        // 正序输出
        ints.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
        // 逆序输出
        ints.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).map(String::valueOf).collect(Collectors.joining(","));
        // 逆序输出
        ints.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining(","));

        System.out.println(ints.stream().distinct().map(String::valueOf).collect(Collectors.joining(",")));
        System.out.println(ints.stream().limit(4).map(String::valueOf).collect(Collectors.joining(",")));

    }
}
