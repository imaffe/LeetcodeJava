package Medium;

public class M309BuyStocks {
    public int maxProfit(int[] prices) {
        int len = prices.length;

        int s1, s2, s3;

        s1 = 0;
        s2 = -prices[0];
        s3 = 0;
        for (int i = 1 ; i < len; i++) {

            s2 = Math.max(s2, s1 - prices[i]);
            s1 = Math.max(s1, s3);
            s3 = s2 +prices[i];
        }

        return Math.max(s3, s1);
    }
}
