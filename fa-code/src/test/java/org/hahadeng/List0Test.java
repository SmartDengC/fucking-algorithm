package org.hahadeng;

import org.hahadeng.structe.List0;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
        // 1101
        Set<Integer> set = new HashSet<Integer>() {{
            add(3);
            add(0);
            add(2);
            add(1024);  // int要溢出

        }};
        int bn = 0;
        for (int num : set) {
            bn |= (1 << num);
        }
        System.out.println(Integer.toBinaryString(bn));
        System.out.println("---");


        int i0 = 1 << 2; // 左移 变大

        String s1 = "101100";  // 44
        // System.out.println(Integer.bitCount(14));  // 3 二进制 1110 有三个1

        // s 表示集合转化成二进制的十进制值
        // set {0, 2, 3}
        int s = 13;
        for (int i = 0; i < 10; i++) {
            if (((s >> i) & 1) == 1) {
                // System.out.println(i);
            }
        }

        // 判断最低是1的位置, 1101 -> 0, 1100 -> 2
        System.out.println(Integer.numberOfTrailingZeros(12));  // 2
        // 判断二进制前面有多少个0， 1101 -> 28, 1100 -> 28
        System.out.println(Integer.numberOfLeadingZeros(12));

        for (int t = 0; t < (1 << 4); t++) {
            // 1101
            // System.out.println(t);
        }
        System.out.println("----");
        s = 13;  // 1101
        for (int sub = s; sub > 0; sub = (sub - 1) & s) {
            // 1101
            // 13, 12, 9, 8, 5, 4, 1
            // 1101, 1100, 1001, 1000, 0101, 0100, 0001
            // System.out.println(sub);
        }
        s = 13; // 1101
        int sub = s;
        do {
            // 处理sub的逻辑
            // 13, 12, 9, 8, 5, 4, 1, 0
            // System.out.println(sub);
            sub = (sub - 1) & s;  // (0-1) & 13,
        } while (sub != s);

        // System.out.println(-1 & 13);  // 11..1
        int t = 13;
        // 13 1101, 12 1100
        // System.out.println(13 & (13 - 1));
        // 12 1100, 11 1011
        // System.out.println(12 & (12 - 1));
        // System.out.println(13 | 14);  // 1101 -> 1111
//        System.out.println();
        System.out.println(~13 & (14));   // 1100
        System.out.println("---");
        System.out.println(Integer.bitCount(13));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 5) {
                    break;
                }
            }
            System.out.println(i);
        }


    }

    @Test
    void vowelStrings2() {
        int i;
        String s = "1101";
        System.out.println(s.hashCode());
        char[] charArray = s.toCharArray();
        s = s.substring(1);
        System.out.println(s.hashCode());
        System.out.println(s);
        System.out.println(Integer.bitCount(0));

    }
}
