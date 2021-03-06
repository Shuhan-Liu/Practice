package Problems.DP;

import Tool.Printer;

/**
 * Created by shuhanliu on 10/7/18.
 */
public class CoinChange {

    public static int min = Integer.MAX_VALUE;

    public static int coinChangeRecursive(int[] coins, int amount) {
        helper(coins, 0, amount, 0);
        return min < Integer.MAX_VALUE ? min : -1;

    }

    public static void helper(int[] coins, int index, int amount, int count) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            if (count < min) {
                min = count;
            }
            return;
        } else {
            if (count > min)
                return;
            for (int i = index; i < coins.length; i++) {
                helper(coins, i, amount - coins[i], count + 1);
            }
        }
    }

    public static int coinChangeIterative(int[] coins, int amount) {
        if (amount <= 0)
            return 0;
        if (coins.length == 0)
            return -1;

        int[] min = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            min[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && min[i - coins[j]] < Integer.MAX_VALUE) {
                    min[i] = Math.min(min[i], 1 + min[i - coins[j]]);
                    System.out.println(i + " : " + min[i] + " : " + coins[j]);
                }
            }
//            System.out.println(i + " : " + min[i]);
        }
        return min[amount] < Integer.MAX_VALUE ? min[amount] : -1;
    }
    
    // find the number of ways to get the change with coins
    public static int coinChangeDP(int[] coins, int amount) {
        
        if (amount <= 0)
            return 0;
        if (coins.length == 0)
            return -1;
        
        int[] ways = new int[amount + 1];
        ways[0] = 1;

//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (i - coins[j] >= 0)
//                    ways[i] += ways[i-coins[j]];
//            }
//        }

        for (int j = 0; j < coins.length; j++) {
            for (int i = coins[j]; i <= amount; i++) {
                ways[i] += ways[i - coins[j]];
            }
        }

        Printer.printArr(ways);
        return ways[amount];
    }

    public static void main (String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(coinChangeIterative(coins, amount));
        Printer.printResult(coinChangeDP(coins, amount));
    }
}
