import java.util.Stack;

/**
 * Created by xiaoyuan on 05/08/2017.
 */
public class P503_NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {

        if (nums == null || nums.length == 0) {return new int[]{};}

        int n = nums.length;
        int[] A = new int[2 * n];
        for (int i = 0; i < n; i++) {
            A[i] = A[i + n] = nums[i];
        }

        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }

            int t = -1;
            if (!stack.isEmpty()) {
                t = stack.peek();
            }
            if (i < n) {ans[i] = t;}

            stack.add(A[i]);
        }

        return ans;
    }

}
