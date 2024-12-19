package org.hahadeng;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class List0Test {

    @Test
    void listCreate() {
        List0.listCreate();
    }
    @Test
    void collection() {
        // List0.collection();

        // 字符相减的实质就是获取到两个字符的unicode值，并对这两个值进行数值运算，得到他们之间的差值
        // 是unicode码还是ascii码？
        char a = '0';
        char b = '1';
        // '0' - '0' -> 0
        // '1' - '0' -> 1
        System.out.println('2' - '0');
        System.out.println(b - '0');
        System.out.println('a' - 'b');
        // 97 - 65 = 32
        System.out.println('a' - 'A');
    }

    @Test
    void vowelStrings1() {
        double a = 2.75;
        int b = (int) a;
        System.out.println(b);

    }
}
