package org.hahadeng.structe;


import java.util.NoSuchElementException;

/**
 * 链表
 *
 * @author 邓聪
 */
public class MyLinkedList<E> {
    private static class Node<E> {
        E val;
        Node<E> prev;
        Node<E> next;

        Node(E e){
            this.val = e;
        }
    }

    // 私有的final属性？
    // head 和 tail是虚拟的节点 没有存值
    final private Node<E> head, tail;
    private int size;

    // 构造函数虚拟节点
    MyLinkedList(){
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    private Node<E> getNode(int index){
        checkElementIndex(index);
        Node<E> p = head.next;
        // 可以优化，看是从head出发还是tail出发
        for(int i = 0; i < index; i++){
            p = p.next;
        }
        return p;
    }
    public void addFirst(E e){
        Node<E> x = new Node<>(e);
        Node<E> tmp = head.next;
        // x <-> tmp
        x.next = tmp;
        tmp.prev = x;

        // head <-> x
        head.next = x;
        x.prev = head;
        size++;
    }
    public void addLast(E e){
        // 在最后添加
        Node<E> x = new Node<>(e);
        Node<E> tmp = tail.prev;
        // tmp <-> x
        tmp.next = x;
        x.prev = tmp;
        //  x <-> tail
        x.next = tail;
        tail.prev = x;
        size++;
    }

    public void add(int index, E e){
        checkPositionIndex(index);

        if(index == size){
            addLast(e);
            return;
        }
        Node<E> next = getNode(index);
        Node<E> prev = next.prev;
        Node<E> x = new Node<>(e);

        // x <-> next
        x.next = next;
        next.prev = x;

        // prev <-> x
        prev.next = x;
        x.prev = prev;
        size++;
    }
    public E removeFirst(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        Node<E> x = head.next;
        head.next = head.next.next;
        head.next.prev = head;

        x.next = null;
        x.prev = null;

        size--;
        return x.val;
    }
    public E removeLast(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        // 就是最后一个节点，就是我们要返回的值
        Node<E> x = tail.prev;
        Node<E> t = tail.prev.prev;
        t.next = tail;
        tail.prev = t;

        x.prev = null;
        x.next = null;

        size--;
        return x.val;
    }
    public E remove(int index){
        checkElementIndex(index);
        Node<E> x = getNode(index);
        Node<E> prev = x.prev;
        Node<E> next = x.next;

        prev.next = next;
        next.prev = prev;
        x.next = x.prev = null;
        size--;
        return x.val;
    }
    public E get(int index){
        checkElementIndex(index);
        Node<E> p = getNode(index);
        return p.val;
    }

    public E getFirst(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }
    public E set(int index, E e){
        checkElementIndex(index);
        Node<E> p = getNode(index);

        E oldVal = p.val;
        p.val = e;
        return oldVal;
    }

    public boolean checkPositionIndex(int index){
        boolean isPositionIndex = index >= 0 && index <= size;
        if(!isPositionIndex){
            throw new IndexOutOfBoundsException();
        }
        return true;
    }
    public boolean checkElementIndex(int index){
        boolean isElementIndex = index >= 0 && index < size;
        if(!isElementIndex){
            throw new IndexOutOfBoundsException();
        }
        return true;
    }
    public void display(){
        System.out.println(size);
        for(Node<E> p = head.next; p != tail; p = p.next){
            System.out.print(p.val + " <-> ");
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.add(2, 100);
        list.display();

    }

}
