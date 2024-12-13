package org.hahadeng;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: HaHaDeng
 */

public class List0 {

    public static void listCreate(){
        // 为什么会存在new ArrayList来创建？
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Integer> integers1 = new ArrayList<>(Arrays.asList(1, 2, 3));

        // 匿名函数创建。
        ArrayList<Integer> integers2 = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};
        // throw UnSupportOperationException
        integers.add(4);
        for(Integer x: integers){
            System.out.println(x);
        }
    }

    public static void collection(){
        List<Integer> integers = Collections.nCopies(16, 0);
        ArrayList<Integer> integers1 = new ArrayList<>(integers);

        int size = integers1.size();
        boolean empty = integers1.isEmpty();
        boolean add = integers1.add(1);
        Integer remove = integers1.remove(1);
        int i = integers1.indexOf(1);
        int i1 = integers1.lastIndexOf(1);

        LinkedList<Integer> integers2 = new LinkedList<>(integers);
        integers2.addFirst(1);
        integers2.addLast(1);
        Integer integer = integers2.removeFirst();
        Integer integer1 = integers2.removeLast();
        Integer first = integers2.getFirst();
        Integer last = integers2.getLast();
        integers2.add(2);
        integers2.add(2, 2);
    }

    public static void queue(){
        // Queue是java标准库中的队列接口，常用的实现类有LinkedList和PriorityQueue。
        // 队列先进先出
        Queue<Integer> q = new LinkedList<>();
        // 在队尾添加
        q.offer(1);
        q.offer(2);
        boolean empty = q.isEmpty();
        // peek 获取不删除
        Integer peek = q.peek();
        // poll 获取并且删除
        Integer poll = q.poll();

        Queue<Integer> integers = new PriorityQueue<>();
        Queue<Integer> integers1 = new ConcurrentLinkedQueue<>();
        List<Integer> l1 = new ArrayList<>();
        Set<Integer> s1 = new HashSet<>();
        Map<Integer, Integer> m1 = new HashMap<>();
        for(Map.Entry<Integer, Integer> x: m1.entrySet()){
            x.getKey();
            x.getValue()
        }

        // 为什么是一个实现类?
        Stack<Integer> stack = new Stack<>();
        stack.isEmpty();
        stack.size();
        stack.push(1);
        stack.pop();
        stack.peek();
    }
}
