package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 30/07/2017.
 */
public class P651_4KeysKeyboard {

    public int maxA(int N) {

        Map<Integer, Set<String>> map = new HashMap<>();
        Set<String> tmpSet = new HashSet<>();
        tmpSet.add("1_1_0");
        map.put(1, tmpSet);

        String oneCase = "1_1_0";


        Queue<String> Q = new LinkedList<>();
        Set<String> inQ = new HashSet<>();
        Q.add(oneCase);
        inQ.add(oneCase);

        while (!Q.isEmpty()) {
            String tp = Q.poll();
            String[] a = tp.split("_");
            int times = Integer.parseInt(a[0]);
            int length = Integer.parseInt(a[1]);
            int buffer = Integer.parseInt(a[2]);

            // add one
            int x = times + 1;
            int y = length + 1;
            int z = buffer;
            if (x <= N) {
                update(x, y , z, Q, inQ, map);
            }

            // select / copy / paste
            x = times + 3;
            y = length * 2;
            z = length;
            if (x <= N) {
                update(x, y , z, Q, inQ, map);
            }

            // paste
            x = times + 1;
            y = length + buffer;
            z = buffer;
            if (x <= N) {
                update(x, y , z, Q, inQ, map);
            }

        }

        int ans = 0;
        Set<String> ansSet = map.get(N);
        for (String now : ansSet) {
            String[] nowArr = now.split("_");
            int b = Integer.parseInt(nowArr[1]);
            ans = Math.max(ans, b);
        }

        return ans;
    }

    private void update(int x, int y, int z, Queue<String> Q, Set<String> inQ, Map<Integer, Set<String>> map) {

        Set<String> set = map.get(x);
        if (set == null) {set = new HashSet<>();}

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String now = iterator.next();
            String[] nowArr = now.split("_");
            int b = Integer.parseInt(nowArr[1]);
            int c = Integer.parseInt(nowArr[2]);

            if (y <= b && z <= c) {
                return;
            }

            if (x >= b && z >= c) {
                iterator.remove();
            }
        }

        String key = x + "_" + y + "_" + z;
        set.add(key);
        map.put(x, set);
        if (!inQ.contains(key)) {
            Q.add(key);
            inQ.add(key);
        }

    }

    public static void main(String[] args) {
        System.out.println(new P651_4KeysKeyboard().maxA(50));
    }

}
