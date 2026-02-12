package cn;
// 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
//
// 实现 MyHashMap 类： 
//
// 
// MyHashMap() 用空映射初始化对象 
// void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
// 则更新其对应的值 value 。
// int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。 
// void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。 
// 
//
// 
//
// 示例： 
//
// 
// 输入：
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
// 输出：
//[null, null, null, 1, -1, null, 1, null, -1]
//
// 解释：
// MyHashMap myHashMap = new MyHashMap();
// myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
// myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
// myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
// myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
// myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
// myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
// myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
// myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= key, value <= 10⁶ 
// 最多调用 10⁴ 次 put、get 和 remove 方法 
// 
//
// Related Topics 设计 数组 哈希表 链表 哈希函数 👍 463 👎 0


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap706 {
    private final int MAX_LEN = 100000;
    private List<Pair<Integer, Integer>>[] map;

    public int getIndex(int key) {
        return key % MAX_LEN;
    }

    public int getPosition(int key, int index) {
        List<Pair<Integer, Integer>> temp = map[index];
        if (temp == null) {
            return -1;
        }

        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    public MyHashMap706() {
        map = (List<Pair<Integer, Integer>>[]) new ArrayList[MAX_LEN];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        int position = getPosition(key, index);

        if (position < 0) {
            // 添加元素
            if (map[index] == null) {
                map[index] = new ArrayList<>();
            }
            map[index].add(new Pair<>(key, value));
        } else {
            // 更新元素
            map[index].set(position, new Pair<>(key, value));
        }
    }

    public int get(int key) {
        int index = getIndex(key);
        int position = getPosition(key, index);

        if (position >= 0) {
            return map[index].get(position).getValue();
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        int position = getPosition(key, index);

        if (position >= 0) {
            // 存在
            map[index].remove(position);
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// leetcode submit region end(Prohibit modification and deletion)
