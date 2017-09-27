package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 27/09/2017.
 */
public class P587_ErecttheFence {

    private int cross(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
    }

    private int dist2(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public List<Point> outerTrees(Point[] points) {
        if (points.length <= 1) {return Arrays.asList(points);}

        Point bl = getBottomLeft(points);

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int diff = cross(bl, o1, o2);
                if (diff == 0) return dist2(bl, o1) - dist2(bl, o2);
                return diff > 0 ? -1 : 1;
            }
        });


        int i = points.length - 1;
        while (i >= 0 && cross(bl, points[points.length - 1], points[i]) == 0) i--;
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            Point tmp = points[l];
            points[l] = points[h];
            points[h] = tmp;
        }

        Stack<Point> stack = new Stack<>();
        stack.add(points[0]);
        stack.add(points[1]);
        for (int j = 2; j < points.length; j++) {
            Point top = stack.pop();

            while (cross(stack.peek(), top, points[j]) < 0) top = stack.pop();
            stack.push(top);
            stack.push(points[j]);
        }

        return new ArrayList<>(stack);
    }

    private Point getBottomLeft(Point[] points) {
        Point res = points[0];
        for (Point p : points) {
            if (p.x < res.x || (p.x == res.x && p.y < res.y)) res = p;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P587_ErecttheFence().outerTrees(new Point[]{
                new Point(1, 1),
                new Point(2, 2),
                new Point(4, 2)
        }));
    }

}
