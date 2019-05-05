package Medium;

import java.util.Collection;
import java.util.Collections;

public class M322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int [] result = new int [amount + 10];

        for (int i = 1 ; i < result.length; i++) {
            result[i] = -1;
        }

        for (int i = 0; i< coins.length; i++) {
            if (coins[i] <= amount) result[coins[i]] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            int min = 1000000;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i - coin >= 0 && result[i - coin] != -1 && result[i - coin] + 1 < min) {
                    min = result[i - coin] + 1;
                }
            }

            if (min != 1000000) result[i] = min;
        }

        return result[amount];
    }


    // TODO write a quick sort again
}
