package com.leetcode;

import java.util.HashSet;
import java.util.Set;

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}
public class P489_RobotRoomCleaner {

    Set<String> visit;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public void cleanRoom(Robot robot) {

        visit = new HashSet<>();
        dfs_clean(robot, 0, 0, 0);

    }

    private void dfs_clean(Robot robot, int x, int y, int direction) {
        if (visit.contains(x + "_" + y)) return;

        visit.add(x + "_" + y);
        robot.clean();

        for(int i = 0; i < dx.length; i++) {
            moveAndClean(robot, x, y, (direction + i) % 4);
            robot.turnRight();
        }
    }

    private void moveAndClean(Robot robot, int x, int y, int direction) {
        if (robot.move()) {
            dfs_clean(robot, x + dx[direction], y + dy[direction], direction);
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnLeft();
            robot.turnLeft();
        }
    }

}
