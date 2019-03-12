package Problems.Onsite;

import java.util.*;

/**
 * Created by shuhanliu on 3/11/19.
 * LC489 位置地形扫地机器人 高频 7次
 */
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
public class RoomCleanRobot {

    interface Robot{
        void clean();
        void turnLeft();
        void turnRight();
        boolean move();
    }

    public static void main(String[] args) {
        // This problem involves predefined interface, goto leetcode to run it.
        Robot robot = new Robot() {
            @Override
            public void clean() {

            }

            @Override
            public void turnLeft() {

            }

            @Override
            public void turnRight() {

            }

            @Override
            public boolean move() {
                return false;
            }
        };

        cleanRoom(robot);
    }

    public static void cleanRoom(Robot robot) {
        dfs(new HashSet<String>(), 0, 0, 0, robot);
    }

    public static void dfs(Set<String> visited, int x, int y, int direction, Robot robot) {
        String pos = x+"-"+y;
        if (visited.contains(pos))
            return;
        robot.clean();
        visited.add(pos);
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int xn = x;
                int yn = y;
                switch(direction) {
                    case 0:
                        xn -= 1;
                        break;
                    case 90:
                        yn += 1;
                        break;
                    case 180:
                        xn += 1;
                        break;
                    case 270:
                        yn -= 1;
                        break;
                    default:
                        break;
                }
                dfs(visited, xn, yn, direction, robot);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            direction += 90;
            direction %= 360;
            robot.turnRight();
        }
    }
}
