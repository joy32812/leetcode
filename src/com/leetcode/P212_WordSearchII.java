package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 01/04/2017.
 */
public class P212_WordSearchII {

    private class TrieNode {
        String word;
        TrieNode[] nextNodes = new TrieNode[26];
    }
    private TrieNode root;
    private List<String> ans;

    private char[][] grid;

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) {return new ArrayList<String>();}
        grid = board;

        root = new TrieNode();
        createTrieTree(words);

        ans = new ArrayList<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, root);
            }
        }

        return ans;
    }

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private void dfs(int x, int y, TrieNode root) {
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
            return;
        }

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {return;}

        char c = grid[x][y];
        if (c == '#' || root.nextNodes[c - 'a'] == null) {return;}

        grid[x][y] = '#';
        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            dfs(tx, ty, root.nextNodes[c - 'a']);
        }
        grid[x][y] = c;

    }


    private void createTrieTree(String[] words) {
        for (String word : words) {
            TrieNode now = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (now.nextNodes[ch - 'a'] == null) {now.nextNodes[ch - 'a'] = new TrieNode();}
                now = now.nextNodes[ch - 'a'];
            }
            now.word = word;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P212_WordSearchII().findWords(new char[][]{
                {'a'}
        }, new String[]{"a"}));
//        System.out.println(new P212_WordSearchII().findWords(new char[][]{
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        }, new String[]{"oath", "pea", "eat", "rain"}));
    }

}
