package week1;

import java.util.HashMap;
import java.util.Map;

public class HomeWork {

    /**
     * 第一题
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * **** 出错误的地方，返回结果一开始返回了length；
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null  || nums.length == 0) {
            return 0;
        }
        int length = 1;
        int i = 0;
        while (length < nums.length) {
            if (nums[i] != nums[length]) {
                nums[++i] = nums[length];
            }
            length ++;
        }
        return i + 1;
    }

    /**
     * 第二题
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * 示例 2:
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 最开始是很笨的方法，耗时230ms，现在默写题解的最优方法  循环替换和反转
     */
    /**
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // 只循环nums.length次
        int count = 0;
        // 长度为偶数时，是两两互换，所以需要遍历下标
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int pre = nums[current];
            do {
                // current + k 有可能会超过数组长度，所以取模
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                // 准备在do while里进行下一步的循环
                pre = temp;
                // current 为当前被替代的索引，即下一步要进行替换的索引
                current = next;
                count++;
            } while (current != start);
        }
    }
     */

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }
    public void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[end];
            nums[end] = nums[begin];
            nums[begin] = temp;
            begin++;
            end--;
        }
    }

    /**
     * 第三题 平时练习时已经做过，这里就当复习了
     *
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 第四题
     *
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *  
     * 示例:
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     int i = m - 1, j = n - 1, index = m + n - 1;
    //     while (i >= 0 || j >= 0) {
    //         if (i < 0) {
    //             nums1[index] = nums2[j];
    //             j--;
    //         } else if (j < 0) {
    //             nums1[index] = nums1[i];
    //             i--;
    //         } else if (nums1[i] <= nums2[j]) {
    //             nums1[index] = nums2[j];
    //             j--;
    //         } else {
    //             nums1[index] = nums1[i];
    //             i--;
    //         }
    //         index--;
    //     }
    // }
    // 根据官方题解，代码优化一下
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] <= nums2[j] ? nums2[j--]:nums1[i--];
        }
        /**
         第三个参数为固定为0
         若nums1先处理完，把nums2剩余的数组移动到nums1的0位置
         若nums2先处理完，nums2其实也不需要复制到nums1了
         */
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

    /**
     * 第五题
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 第六题
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void moveZeroes(int[] nums) {
        int start = 0, length = 0, index = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                start = length == 0 ? i:start;
                length++;
                continue;
            }
            int temp = nums[i];
            System.arraycopy(nums, start, nums, length + start, length);
            nums[index ++] = temp;
        }
        for (int i = index; i < nums.length; i ++) {
            nums[i] = 0;
        }
    }

    /**
     * 第七题
     *
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     *
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int add = digits[i] + carry;
            digits[i] = add % 10;
            carry = add / 10;
        }
        if (carry > 0) {
            digits = new int[digits.length + 1];
            digits[0] = carry;
        }
        return digits;
    }

}
