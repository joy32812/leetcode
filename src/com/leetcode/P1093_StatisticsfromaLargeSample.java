package com.leetcode;

import java.util.LinkedList;

public class P1093_StatisticsfromaLargeSample {

    /**
     * medium
     * median is a little hard to get
     * maybe using Long is simpler
     * @param count
     * @return
     */
    public double[] sampleStats(int[] count) {

        int len = 256;

        double min = 500;
        double max = 0;
        double mode = -1;
        int maxCnt = 0;

        double sum = 0;
        int num = 0;

        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (count[i] == 0) continue;

            min = Math.min(min, i);
            max = Math.max(max, i);

            if (count[i] > maxCnt) {
                maxCnt = count[i];
                mode = i;
            }

            sum += 1.0 * count[i] * i;
            num += count[i];


            list.add(new int[]{i, count[i]});
        }

        double mean = sum / num;
        double median = 0;

        while (true) {

            if (list.size() == 1) {
                median = list.getFirst()[0];
                break;
            }

            if (list.size() == 2 && list.getFirst()[1] == list.getLast()[1]) {
                median = (0.0 + list.getFirst()[0] + list.getLast()[0]) / 2.0;
                break;
            }


            int[] first = list.removeFirst();
            int[] last = list.removeLast();


            if (first[1] == last[1]) continue;
            if (first[1] > last[1]) {
                list.addFirst(new int[]{first[0], first[1] - last[1]});
            } else {
                list.addLast(new int[]{last[0], last[1] - first[1]});
            }
        }





        return new double[]{min, max, mean, median, mode};


    }

}
