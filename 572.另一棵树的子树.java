import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> mainString = new ArrayList<Integer>();
    List<Integer> pattern = new ArrayList<Integer>();

    public boolean isSubtree(TreeNode root, TreeNode subTree) {
        getDfsOrder(root, mainString);
        getDfsOrder(subTree, pattern);
        return kmp();
    }

    public void getDfsOrder(TreeNode node, List<Integer> dfsorder) {
        if (node == null) return;
        dfsorder.add(node.val);
        
        if (node.left == null) {
            dfsorder.add(null);
        } else {
            getDfsOrder(node.left, dfsorder);
        }

        if (node.right == null) {
            dfsorder.add(null);
        } else {
            getDfsOrder(node.right, dfsorder);
        }
    }

    public boolean kmp() {
        int mLen = mainString.size();
        int pLen = pattern.size();

        int[] fail = new int[pLen - 1];
        Arrays.fill(fail, -1);

        for (int j = -1, i = 1; i < pLen - 1; i++) {
            while (j != -1 && !(Objects.equals(pattern.get(i), pattern.get(j+1)))) {
                j = fail[j];
            }
            if (Objects.equals(pattern.get(i), pattern.get(j+1))) {
                j++;
            }
            fail[i] = j;
        }

        for (int j = -1, i = 0; i < mLen; i++) {
            while (j != -1 && !(Objects.equals(mainString.get(i), pattern.get(j+1)))) {
                j = fail[j];
            }
            if (Objects.equals(mainString.get(i), pattern.get(j+1))) {
                j++;
            }
            if (j == pLen - 1) {
                return true;
                // now, (i-j) is start index of target in mainString 
                // if need to get all substrings (instead of just returning exsits or not), 
                // (i-j) should be recorded, j should be reset to -1 and for loop should go on.
            }
        }
        return false;
    }
}

// @lc code=end

