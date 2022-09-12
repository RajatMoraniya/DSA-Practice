package Alpha.Arrays;

public class BuyAndSellStockd {
    public static int buySellstocks(int[] prices , int n){
        int buyPrice = Integer.MAX_VALUE; //track_lowest_stock_price(min.price[i])
        int maxProfit = 0; // initialize;

        for (int i = 0; i < n; i++) {
            if(buyPrice < prices[i]){ //profit
                int profit = prices[i]-buyPrice; //prices[i] = sellingPrice;
                maxProfit = Math.max(profit , maxProfit);
            }
            else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int n = prices.length;
        int maxprofit = buySellstocks(prices , n);
        System.out.println(maxprofit);

    }
}
