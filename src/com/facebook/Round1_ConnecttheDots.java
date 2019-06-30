package com.facebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Round1_ConnecttheDots {



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("/Users/xiaoyuan/Downloads/facebook/in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/xiaoyuan/Downloads/facebook/out.txt"));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            work(br, bw, i);
        }

        bw.flush();
        bw.close();
    }

    private static void work(BufferedReader br, BufferedWriter bw, int caseNo) throws Exception {
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int H = Integer.parseInt(s.split(" ")[1]);
        int V = Integer.parseInt(s.split(" ")[2]);

        List<long[]> pointList = new ArrayList<>();

        String t = br.readLine();
        String[] ta = t.split(" ");

        t = br.readLine();
        String[] tb = t.split(" ");

        pointList.add(new long[]{Long.parseLong(ta[0]), Long.parseLong(tb[0])});
        pointList.add(new long[]{Long.parseLong(ta[1]), Long.parseLong(tb[1])});

        long ax = Long.parseLong(ta[2]);
        long ay = Long.parseLong(tb[2]);

        long bx = Long.parseLong(ta[3]);
        long by = Long.parseLong(tb[3]);

        long cx = Long.parseLong(ta[4]);
        long cy = Long.parseLong(tb[4]);

        long dx = Long.parseLong(ta[5]);
        long dy = Long.parseLong(tb[5]);

        for (int i = 2; i < N; i++) {
            long[] p2 = pointList.get(i - 2);
            long[] p1 = pointList.get(i - 1);

            long xx = (ax * p2[0] + bx * p1[0] + cx) % dx + 1;
            long yy = (ay * p2[1] + by * p1[1] + cy) % dy + 1;

            pointList.add(new long[]{xx, yy});
        }

        for (int i = 0; i < pointList.size(); i++) {
            System.out.println(pointList.get(i)[0] + " : " + pointList.get(i)[1]);
        }


        pointList.sort((a, b) -> (int) (a[0] - b[0]));


        int ans = -1;
        String line = "Case #" + caseNo + ": " + ans;
        System.out.println(line);
        bw.write(line + "\n");
    }


}
