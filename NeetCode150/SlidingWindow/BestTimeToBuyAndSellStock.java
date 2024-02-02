package NeetCode150.SlidingWindow;

public class BestTimeToBuyAndSellStock {
    // Time Complexity - O(n)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] leftMax = new int[len];
        leftMax[len-1] = -1;
        for(int i=len-2;i>=0;i--) leftMax[i] = Math.max(leftMax[i+1], prices[i+1]);
        int maxPrice = 0;
        for(int i=0;i<len-1;i++) {
            if(prices[i] < leftMax[i]) maxPrice = Math.max(maxPrice, leftMax[i]-prices[i]);
        }
        return maxPrice;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
