package com.leetcode;

public class P427_ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    public Node construct(int[][] grid) {
        int n = grid.length;

        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = getSum(sum, i, j - 1) + getSum(sum, i - 1, j) - getSum(sum, i - 1, j - 1) + grid[i][j];
            }
        }

        return buildTree(grid, sum, 0, 0, n - 1, n - 1);
    }

    private Node buildTree(int[][] grid, int[][] sum, int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return null;

        int gridNum = (tx - sx + 1) * (ty - sy + 1);
        int gridSum = getSum(sum, tx, ty) - getSum(sum, sx - 1, ty) - getSum(sum, tx, sy - 1) + getSum(sum, sx - 1, sy - 1);

        if (gridSum == gridNum) {
            return new Node(true, true, null, null, null, null);
        }

        if (gridSum == 0) {
            return new Node(false, true, null, null, null, null);
        }

        Node root = new Node(false, false, null, null, null, null);

        root.topLeft = buildTree(grid, sum, sx, sy, (sx + tx) / 2, (sy + ty) / 2);
        root.topRight = buildTree(grid, sum, sx, (sy + ty) / 2 + 1, (sx + tx) / 2, ty);
        root.bottomLeft = buildTree(grid, sum, (sx + tx) / 2 + 1, sy, tx, (sy + ty) / 2);
        root.bottomRight = buildTree(grid, sum, (sx + tx) / 2 + 1, (sy + ty) / 2 + 1, tx, ty);

        return root;
    }


    private int getSum(int[][] sum, int x, int y) {
        if (x < 0 || y < 0) return 0;
        return sum[x][y];
    }

    public static void main(String[] args) {
        System.out.println(new P427_ConstructQuadTree().construct(new int[][]{
                {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}
        }));
    }

}
