package com.facebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Round1_ClassTreasurer {



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
        long mod = 1000000000 + 7;

        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int k = Integer.parseInt(s.split(" ")[1]);

        s = br.readLine();


        long[] sq = new long[n + 1];
        sq[0] = 1;
        for (int i = 1; i < n + 1; i ++) {
            sq[i] = (sq[i - 1] * 2) % mod;
        }

        long ans = 0;
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == 'B') cnt ++;
            else cnt --;
            if (cnt < 0) cnt = 0;


            if (cnt > k) {
                ans = (ans + sq[i + 1]) % mod;
                cnt -= 2;
            }
        }



        String line = "Case #" + caseNo + ": " + ans;
        System.out.println(line);
        bw.write(line + "\n");
    }


}
