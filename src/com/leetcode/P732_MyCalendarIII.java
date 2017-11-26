package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P732_MyCalendarIII {

    private class EndPoint implements Comparable<EndPoint>{
        int x;
        int type; // 0 begin  1 end

        public EndPoint(int x, int type) {
            this.x = x;
            this.type = type;
        }

        @Override
        public int compareTo(EndPoint o) {
            if (this.x == o.x) return o.type - this.type;
            return this.x - o.x;
        }
    }
    List<EndPoint> ps;

    public P732_MyCalendarIII() {
        ps = new ArrayList<>();
    }

    public int book(int start, int end) {

        ps.add(new EndPoint(start, 0));
        ps.add(new EndPoint(end, 1));
        Collections.sort(ps);

        int ans = 0;
        int cnt = 0;

        for (int i = 0; i < ps.size(); i++) {
            EndPoint ep = ps.get(i);

            if (ep.type == 0) cnt++;
            else cnt--;

            ans = Math.max(ans, cnt);
        }

        return ans;
    }


}
