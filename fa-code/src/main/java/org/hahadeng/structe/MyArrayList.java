package org.hahadeng.structe;

import java.util.NoSuchElementException;

/**
 * @author: HaHaDeng
 * 手写动态列表
 * 主要设计到的知识点
 * 扩容 缩容
 *
 */

public class MyArrayList<E> {

    private E[] data;
    private int size;
    private int DEFAULT_INIT_CAPACITY = 1;

    public MyArrayList() {
        data = (E[]) new Object[DEFAULT_INIT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int size){
        data = (E[]) new Object[size];
        size = 0;
    }


    public void add(int index, E e){
        checkPositionIndex(index);
        int cap = data.length;
        if(cap == size){
            resize(2 * size);
        }

        for(int i = size-1; i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
    public void addLast(E e){
        int cap = data.length;
        if(cap == size){
            resize(2 * size);
        }
        data[size] = e;
        size++;
    }
    public void addFirst(E e){
        add(0, e);
    }

    public E remove(int index){
        checkElementIndex(index);
        E e = data[index];
        //移动
        for(int i = index; i<size-1;i++){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return e;
    }
    public E removeLast(){
        if(size == 0){
            throw  new NoSuchElementException();
        }
        E e = data[size-1];
        data[size-1] = null;
        size--;
        return e;
    }
    public E removeFirst(){
        return remove(0);
    }

    public E get(int index){
        checkElementIndex(index);
        return data[index];
    }
    public E set(int index, E e){
        checkElementIndex(index);
        E oldEle = data[index];
        data[index] = e;
        return oldEle;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(int newSize){
        E[] tmp = (E[]) new Object[newSize];
        for(int i =0;i<size;i++){
            tmp[i] = data[i];
        }
        data = tmp;
    }

    private boolean checkElementIndex(int index){
        // 检查元素是否合法
        boolean isElementIndex = index >= 0 && index < size;
        if(!isElementIndex){
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
        return true;
    }
    private boolean checkPositionIndex(int index){
        boolean isPositionIndex = index >= 0 && index <= size;
        if(!isPositionIndex){
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
        return true;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList(3);
        for(int i=1;i<=5;i++){
            myArrayList.addLast(i);
        }

        myArrayList.remove(3);
        myArrayList.add(1, 9);
        myArrayList.addFirst(100);
        int val = myArrayList.removeLast();

        for(int i=0;i<myArrayList.size;i++){
            System.out.println(myArrayList.get(i));
        }

    }


}
