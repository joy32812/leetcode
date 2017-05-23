package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 23/05/2017.
 */
public class P386_LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {return ans;}

        ans.add(1);

        for (int i = 2; i <= n; i++) {
            int last = ans.get(ans.size() - 1);

            if (last * 10 <= n) {
                ans.add(last * 10);
                continue;
            }

            last++;
            if (last > n) {
                last--;
                last /= 10;
                last++;

                while (last % 10 == 0) {
                    last /= 10;
                }

                ans.add(last);
                continue;
            }
            while (last % 10 == 0) {
                last /= 10;
            }

            ans.add(last);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {1, 10, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 11, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 12, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 13, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 14, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 15, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 16, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 17, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 18, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 19, 190, 191, 192, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 3, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 4, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 5, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 6, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 7, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 8, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 9, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 10};
        Set<Integer> set = new HashSet<>();
        for (int d : arr) {
            set.add(d);
        }
        for (int i = 1; i <= 192; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
            }
        }


        System.out.println(new P386_LexicographicalNumbers().lexicalOrder(192));
    }

}
