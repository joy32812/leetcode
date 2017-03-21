package com.leetcode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 21/03/2017.
 */

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class P149_MaxPointsonaLine {


    private Map<String, Set<Point>> pointMap;

    public int maxPoints(Point[] points) {
        if (points.length <= 2) {return points.length;}

        pointMap = new HashMap<String, Set<Point>>();

        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Point s = points[i];
                Point t = points[j];

                String signature = getMark(s, t);

                Set<Point> set = pointMap.get(signature);
                if (set == null) {
                    set = new HashSet<Point>();
                }
                set.add(s);
                set.add(t);

                pointMap.put(signature, set);
            }
        }

        int ans = 0;
        for (String key : pointMap.keySet()) {
            ans = Math.max(ans, pointMap.get(key).size());
        }

        return ans;
    }

    private String getMark(Point s, Point t) {
        if (s.x == t.x && s.y == t.y) {
            return s.x + "_" + s.y;
        }

        int x1 = s.x, y1 = s.y;
        int x2 = t.x, y2 = t.y;

        int a = y1 - y2;
        int b = x2 - x1;
        int c = x1 * y2 - x2 * y1;

        int gcd = gcd(a, gcd(b, c));
        return (a / gcd) + "_ " + (b / gcd) + "_" + (c / gcd);
    }

    private int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        return b1.gcd(b2).intValue();
    }

}
