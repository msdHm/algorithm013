package week1;

import java.util.HashMap;
import java.util.Map;

public class HomeWork {

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        Map<String, List> result = new HashMap<String, List>();
        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String key = String.valueOf(strArray);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList());
            }
            result.get(key).add(str);
        }
        return new ArrayList(result.values());
    }


    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-anagram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     int[] nums = new int[26];
    //     for (int i = 0; i < s.length(); i++) {
    //         nums[s.charAt(i) - 'a']++;
    //         nums[t.charAt(i) - 'a']--;
    //     }
    //     for (int num : nums) {
    //         if (num != 0) return false;
    //     }
    //     return true;
    // }

    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     int[] counter = new int[26];
    //     for (int i = 0; i < s.length(); i++) {
    //         counter[s.charAt(i) - 'a']++;
    //     }
    //     for (int j = 0; j < t.length(); j++) {
    //         if (--counter[t.charAt(j) - 'a'] < 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     int[] counter = new int[26];
    //     for (int i = 0; i < s.length(); i++) {
    //         counter[s.charAt(i) - 'a']++;
    //     }
    //     for (int j = 0; j < t.length(); j++) {
    //         if (--counter[t.charAt(j) - 'a'] < 0) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     *
     * 例如，给定一个 3叉树 :
     *
     * 返回其前序遍历: [1,3,5,6,2,4]。
     * @param root
     * @return
     */
    // 递归
    // public List<Integer> preorder(Node root) {
    //     List<Integer> result = new ArrayList();
    //     addNext(root, result);
    //     return result;
    // }
    // public void addNext(Node root, List<Integer> result) {
    //     if (root == null) {
    //         return;
    //     }
    //     result.add(root.val);
    //     for (Node node : root.children) {
    //         addNext(node, result);
    //     }
    // }

    // 迭代
    public List<Integer> preorder(Node root) {
        Stack<Node> nodeStack = new Stack<Node>();
        List<Integer> result = new ArrayList<>();
        nodeStack.push(root);
        while (!nodeStack.empty()) {
            Node node = nodeStack.pop();
            if (node != null) {
                result.add(node.val);

                List<Node> children = node.children;
                if (children != null && children.size() > 0) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        nodeStack.push(children.get(i));
                    }
                }
            }
        }
        return result;
    }

}
