package Problems.DP;

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

    public static void main (String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChangeIterative(coins, amount));
    }
}
