package com.leetcode;

/**
 * Created by xiaoyuan on 13/11/2017.
 */
public class P725_SplitLinkedListinParts {

    public ListNode[] splitListToParts(ListNode root, int k) {

        int n = 0;
        ListNode now = root;
        while (now != null) {
            n++;
            now = now.next;
        }

        int a = n / k;
        int b = n % k;



        ListNode[] ans = new ListNode[k];
        int id = 0;

        ListNode lastHead = root;
        now = root;
        int cnt = 0;
        while (now != null) {
            cnt++;

            int need = a + (id < b ? 1 : 0);
            if (cnt == need) {
                ans[id] = lastHead;
                id ++;
                cnt = 0;

                lastHead = now.next;
                now.next = null;
                now = lastHead;
            } else {
                now = now.next;
            }

        }

        return ans;
    }

}
