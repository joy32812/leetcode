package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 15/03/2017.
 */
public class P127_WordLadder {

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

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {return 0;}

        int ans = Integer.MAX_VALUE;

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

                    if (nextWW.current.equals(endWord)) {
                        ans = Math.min(ans, nextWW.dis);
                    }

                    if (!nextWW.current.equals(endWord) && !wordsInQ.contains(nextWW.current)) {
                        wordsInQ.add(nextWW.current);
                        Q.add(nextWW);
                    }
                } else if (nextWW.dis == ww.dis + 1 && !nextWW.fromList.contains(ww.current)) {
                    nextWW.fromList.add(ww.current);
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {ans = -1;}
        return ans + 1;
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

}
