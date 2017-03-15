package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 15/03/2017.
 */
public class P126_WordLadderII {

    class WordWrapper {
        int dis;
        String current;
        Set<String> fromList;

        public WordWrapper(int dis, String current, Set<String> fromList) {
            this.dis = dis;
            this.current = current;
            this.fromList = fromList;
        }
    }

    private Map<String, WordWrapper> wordWrapperMap;

    private Map<String, List<String>> neigbours;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if (wordList.size() == 0) {return ans;}

        wordList.add(beginWord);
        neigbours = new HashMap<String, List<String>>();

        int size = wordList.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String s = wordList.get(i);
                String t = wordList.get(j);
                if (isNeigbour(s, t)) {
                    List sList = neigbours.get(s);
                    if (sList == null) {sList = new ArrayList();}
                    sList.add(t);

                    List tList = neigbours.get(t);
                    if (tList == null) {tList = new ArrayList();}
                    tList.add(s);

                    neigbours.put(s, sList);
                    neigbours.put(t, tList);
                }
            }
        }

        // bfs

        wordWrapperMap = new HashMap<String, WordWrapper>();
        Set<String> wordsInQ = new HashSet<String>();
        wordsInQ.add(beginWord);

        Queue<WordWrapper> Q = new LinkedList<WordWrapper>();
        wordWrapperMap.put(beginWord, new WordWrapper(0, beginWord, new HashSet<String>()));
        Q.add(wordWrapperMap.get(beginWord));

        while (!Q.isEmpty()) {
            WordWrapper ww = Q.poll();
            wordsInQ.remove(ww.current);

            List<String> nbList = neigbours.get(ww.current);
            if (nbList == null) {nbList = new ArrayList<String>();}
            for (int i = 0; i < nbList.size(); i++) {
                String next = nbList.get(i);
                WordWrapper nextWW = wordWrapperMap.get(next);

                if (nextWW == null) {
                    nextWW = new WordWrapper(Integer.MAX_VALUE, next, new HashSet<String>());
                    wordWrapperMap.put(next, nextWW);
                }

                if (nextWW.dis > ww.dis + 1) {
                    nextWW.dis = ww.dis + 1;
                    nextWW.fromList = new HashSet<String>();
                    nextWW.fromList.add(ww.current);

                    if (!nextWW.equals(endWord) && !wordsInQ.contains(nextWW.current)) {
                        wordsInQ.add(nextWW.current);
                        Q.add(nextWW);
                    }
                } else if (nextWW.dis == ww.dis + 1 && !nextWW.fromList.contains(ww.current)) {
                    nextWW.fromList.add(ww.current);
                }
            }
        }

        LinkedList<String> stack = new LinkedList<String>();
        dfs(endWord, stack, ans);
        return ans;
    }

    private void dfs(String word, LinkedList<String> stack, List<List<String>> ans) {
        WordWrapper ww = wordWrapperMap.get(word);
        if (ww == null) {return;}
        if (ww.fromList.size() == 0) {
            List<String> tmp = new ArrayList<String>();
            tmp.add(ww.current);
            for (int i = stack.size() - 1; i >= 0; i--) {
                tmp.add(stack.get(i));
            }
            ans.add(tmp);
            return;
        }

        for (String s : ww.fromList) {
            stack.addLast(ww.current);
            dfs(s, stack, ans);
            stack.removeLast();
        }
    }


    private boolean isNeigbour(String s, String t) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                num++;
            }
            if (num > 1) {return false;}
        }
        return num == 1;
    }

    public static void main(String[] args) {

    }

}
