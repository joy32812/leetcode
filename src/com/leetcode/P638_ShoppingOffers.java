package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaoyuan on 10/08/2017.
 */
public class P638_ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs);
    }

    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        int j = 0;
        int res = dot(needs, price);

        for (List<Integer> s : special) {
            List<Integer> clone = new ArrayList<>(needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);

                if (diff < 0) {break;}
                clone.set(j, diff);
            }
            if (j == needs.size()) {
                res = Math.min(res, s.get(j) + shopping(price, special, clone));
            }
        }


        return res;
    }

    private int dot(List<Integer> needs, List<Integer> price) {
        int ans = 0;
        for (int i = 0; i < needs.size(); i++) {
            ans += needs.get(i) * price.get(i);
        }
        return ans;
    }


}
