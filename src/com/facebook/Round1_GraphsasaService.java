package com.facebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Round1_GraphsasaService {



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
        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);

        int[][] old = new int[n][n];
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            Arrays.fill(old[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dis[i][i] = 0;
            old[i][i] = 0;
        }

        List<String> ansList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String t = br.readLine();
            ansList.add(t);

            int x = Integer.parseInt(t.split(" ")[0]);
            int y = Integer.parseInt(t.split(" ")[1]);

            x --;
            y --;
            int v = Integer.parseInt(t.split(" ")[2]);

            dis[x][y] = dis[y][x] = v;
            old[x][y] = old[y][x] = v;
        }


        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dis[k][j] == Integer.MAX_VALUE || dis[i][k] == Integer.MAX_VALUE) continue;
                    dis[i][j] = dis[j][i] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        boolean okay = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (old[i][j] != Integer.MAX_VALUE && dis[i][j] < old[i][j]) {
                    okay = false;
                    break;
                }
            }
        }

        if (!okay) {
            String line = "Case #" + caseNo + ": Impossible";
            System.out.println(line);
            bw.write(line + "\n");
            return;
        }


        String line = "Case #" + caseNo + ": " + ansList.size();
        System.out.println(line);
        bw.write(line + "\n");

        for (int i = 0; i < ansList.size(); i++) {
            line = ansList.get(i);
            System.out.println(line);
            bw.write(line + "\n");
        }
    }


}
