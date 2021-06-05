package Medium;

public class M309BuyStocks {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;

        int s1, s2, s3;
        s1 = 0;
        s2 = -prices[0];
        s3 = 0;
        for (int i = 1 ; i < len; i ++) {
            int news1 = Math.max(s3, s1);
            int news2 = Math.max(s1 - prices[i], s2);
            int news3 = s2 + prices[i];
            s1 = news1;
            s2 = news2;
            s3 = news3;
        }

        return Math.max(s3,s1);
    }
}
