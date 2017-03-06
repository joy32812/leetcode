package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 06/03/2017.
 *
 * use mask to indicate numbers we can use
 */
public class P95_UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return dfs((1 << n) - 1);
    }

    private List<TreeNode> dfs(long mask) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (mask == 0) {
            return result;
        }

        long left = 0;
        long right = 0;
        for (int i = 1; i <= 63; i++) {
            if ((1 << (i - 1)) > mask) {
                break;
            }

            if (((1 << (i - 1)) & mask) > 0 ) {
                right = 0;
                for (int j = i + 1; j <= 63; j++) {
                    if ((1 << (j - 1)) > mask) {break;}
                    if (((1 << (j - 1)) & mask) > 0 ) {
                        right += (1 << (j - 1));
                    }
                }

                List<TreeNode> leftAns = dfs(left);
                List<TreeNode> rightAns = dfs(right);
                if (leftAns.size() == 0) {leftAns.add(null);}
                if (rightAns.size() == 0) {rightAns.add(null);}
                for (int x = 0; x < leftAns.size(); x++) {
                    for (int y = 0; y < rightAns.size(); y++) {
                        TreeNode now = new TreeNode(i);
                        now.left = leftAns.get(x);
                        now.right = rightAns.get(y);
                        result.add(now);
                    }
                }


                left += (1 << (i - 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> ans = new P95_UniqueBinarySearchTreesII().generateTrees(3);
        System.out.println(ans.size());
    }

}
