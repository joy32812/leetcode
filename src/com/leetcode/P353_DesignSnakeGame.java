package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by xiaoyuan on 11/05/2017.
 */
public class P353_DesignSnakeGame {


    public static void main(String[] args) {

        int[][] food = new int[][]{
                {2, 0},
                {0, 0},
                {0, 2},
                {2, 2}
        };
        SnakeGame obj = new SnakeGame(3, 3, food);


        String[] moves = {"D", "D", "R", "U", "U", "L", "D", "R", "R", "U", "L", "D"};
        for (String move : moves) {
            System.out.println(obj.move(move));
        }

    }

}

class SnakeGame {

    int m;
    int n;
    int[][] foods;
    int fid;

    LinkedList<Integer> snake;
    Set<Integer> sSet;


    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public SnakeGame(int width, int height, int[][] food) {
        m = height;
        n = width;
        foods = food;
        fid = 0;

        snake = new LinkedList<>();
        snake.add(0);

        sSet = new HashSet<>();
        sSet.add(0);
    }

    public int move(String direction) {
        int p = 0;
        if (direction.equals("U")) {
            p = 3;
        } else if (direction.equals("L")) {
            p = 1;
        } else if (direction.equals("R")) {
            p = 0;
        } else {
            p = 2;
        }


        int head = snake.getFirst();
        int nx = head / n;
        int ny = head % n;

        int tx = nx + dx[p];
        int ty = ny + dy[p];

        // border
        if (tx < 0 || tx >= m || ty < 0 || ty >= n) {return -1;}

        // self
        if (sSet.contains(tx * n + ty) && !(tx == snake.getLast() / n && ty == snake.getLast() % n)) {return -1;}

        // food
        if (fid < foods.length && tx == foods[fid][0] && ty == foods[fid][1]) {
            fid++;

            snake.addFirst(tx * n + ty);
            sSet.add(tx * n + ty);

            return snake.size() - 1;
        }

        // just move

        int end = snake.getLast();
        snake.removeLast();
        sSet.remove(end);

        snake.addFirst(tx * n + ty);
        sSet.add(tx * n + ty);


        return snake.size() - 1;

    }
}