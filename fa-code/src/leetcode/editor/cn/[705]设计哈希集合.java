package cn;
// 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
//
// 实现 MyHashSet 类： 
//
// 
// void add(key) 向哈希集合中插入值 key 。 
// bool contains(key) 返回哈希集合中是否存在这个值 key 。 
// void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
// 
//
// 示例： 
//
// 
// 输入：
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", 
//"remove", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
// 输出：
//[null, null, null, true, false, null, true, null, false]
//
// 解释：
// MyHashSet myHashSet = new MyHashSet();
// myHashSet.add(1);      // set = [1]
// myHashSet.add(2);      // set = [1, 2]
// myHashSet.contains(1); // 返回 True
// myHashSet.contains(3); // 返回 False ，（未找到）
// myHashSet.add(2);      // set = [1, 2]
// myHashSet.contains(2); // 返回 True
// myHashSet.remove(2);   // set = [1]
// myHashSet.contains(2); // 返回 False ，（已移除）
//
// 
//
// 提示： 
//
// 
// 0 <= key <= 10⁶ 
// 最多调用 10⁴ 次 add、remove 和 contains 
// 
//
// Related Topics 设计 数组 哈希表 链表 哈希函数 👍 373 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet705 {
    private final int MAX_LEN = 100000;

    // set表示数组里面套list， 只要hash冲突的都会放到一个list里面。
    private List<Integer>[] set;

    int getIndex(int key) {
        // 类似与hash函数
        return key % MAX_LEN;
    }

    int getPosition(int key, int index) {
        // 如果hash冲突，获取到元素在list中的下标
        List<Integer> temp = set[index];
        if (temp == null) {
            return -1;
        }

        for (int i = 0; i < temp.size(); ++i) {
            if (key == temp.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public MyHashSet705() {
        set = (List<Integer>[]) new ArrayList[MAX_LEN];
    }

    public void add(int key) {
        // 添加元素，因为是set，相同的元素只会存一份
        int index = getIndex(key);
        int position = getPosition(key, index);
        if (position < 0) {
            // 不存在，则添加
            if (set[index] == null) {
                set[index] = new ArrayList<>();
            }
            set[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        int position = getPosition(key, index);

        // list的下标从0开始的，只要position大于等于0，就表示存在这个元素，就需要删除
        if (position >= 0) {
            set[index].remove(position);
        }
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        int position = getPosition(key, index);
        return position >= 0;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] nums = {1, 2, 3};
        for (int x : nums) {
            set.add(x);
        }

    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// leetcode submit region end(Prohibit modification and deletion)
