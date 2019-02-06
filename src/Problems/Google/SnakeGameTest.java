package Problems.Google;

import java.util.*;

/**
 * Created by shuhanliu on 2/4/19.
 *
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class SnakeGameTest {

    static class SnakeGame {

        /**
         * Initialize your data structure here.
         *
         * @param width - screen width
         * @param height - screen height
         * @param food - A list of food positions
         * E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
         */
        char[][] grid;
        Queue<String> snake;
        int curX;
        int curY;
        int f;
        int[][] food;

        public SnakeGame(int width, int height, int[][] food) {
            grid = new char[height][width];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = ' ';
                }
            }
            this.food = food;
            snake = new LinkedList<>();
            curX = 0;
            curY = 0;
            f = 0;
            grid[curX][curY] = 'S';
            snake.offer(curX + "-" + curY);
            grid[food[f][0]][food[f][1]] = 'F';

            printGrid();
            System.out.println("--------");
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            int nextX = curX;
            int nextY = curY;
            if (direction.equals("U")) {
                nextX -= 1;
            } else if (direction.equals("L")) {
                nextY -= 1;
            } else if (direction.equals("R")) {
                nextY += 1;
            } else {
                nextX += 1;
            }

//            System.out.println(nextX + " : " + nextY);
//
//            System.out.println(grid[nextX]);
//            System.out.println(grid[nextX][nextY]);
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] == 'S') {
                printGrid();
                return -1;
            }
            if (grid[nextX][nextY] == 'F') {
                f += 1;
                if (f < food.length && food[f][0] < grid.length && food[f][1] < grid[0].length) {
                    grid[food[f][0]][food[f][1]] = 'F';
                }
            } else {
                String tail[] = snake.poll().split("-");
                int tailX = Integer.parseInt(tail[0]);
                int tailY = Integer.parseInt(tail[1]);
                grid[tailX][tailY] = ' ';
            }
            grid[nextX][nextY] = 'S';
            curX = nextX;
            curY = nextY;
            snake.offer(curX + "-" + curY);
            printGrid();
            return snake.size() - 1;
        }

        private void printGrid() {
            for (char[] row : grid) {
                for (char c : row) {
                    System.out.print(c + "|");
                }
                System.out.println();
            }
        }
    }
/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

    public static void main(String[] args) {

//        int width = 3;
//        int height = 2;
//        int[][] food = {{1,1}, {1,0}};
//
//        SnakeGame snake = new SnakeGame(width, height, food);
//        System.out.println(snake.move("R"));
//        System.out.println(snake.move("D"));
//        System.out.println(snake.move("R"));
//        System.out.println(snake.move("U"));
//        System.out.println(snake.move("L"));
//        System.out.println(snake.move("U"));

        int width = 3;
        int height = 3;
        int[][] food = {{2,0}, {0,0}, {0,2}, {2,2}};
        SnakeGame snake = new SnakeGame(width, height, food);

        String[][] directions = {{"D"},{"D"},{"R"},{"U"},{"U"},{"L"},{"D"},{"R"},{"R"},{"U"},{"L"},{"D"}};

        for (int i = 0; i < directions.length; i++) {
            String[] direct = directions[i];
            System.out.println("Step " + i + ": " + direct[0]);
            int ret = snake.move(direct[0]);
            System.out.println("Result: " + ret);
            System.out.println("--------");
        }
    }
}
