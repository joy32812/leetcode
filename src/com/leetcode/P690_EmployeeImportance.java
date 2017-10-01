package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 01/10/2017.
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
public class P690_EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {

        Map<Integer,Employee> eMap = new HashMap<>();
        for (Employee e : employees) {
            eMap.put(e.id, e);
        }

        int ans = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(id);

        while (!Q.isEmpty()) {
            int tp = Q.poll();
            Employee now = eMap.get(tp);

            ans += now.importance;

            for (int sid : now.subordinates) {
                Q.add(sid);
            }
        }

        return ans;
    }

}
