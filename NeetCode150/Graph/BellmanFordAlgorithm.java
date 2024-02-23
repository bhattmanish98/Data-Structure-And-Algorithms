package Graph;

import java.util.Arrays;

class BellmanFordAlgorithm {
    private int[] shortestPathFromSourceToCities(int n, int[][] flights, int src) {
        int[] prices = new int[n];
        for(int i=0;i<n;i++) prices[i] = Integer.MAX_VALUE;
        prices[src] = 0;
        for(int i =1 ;i<n;i++) {
            for(int[] flight: flights) {
                if (prices[flight[0]] == Integer.MAX_VALUE) continue;
                prices[flight[1]] = Math.min(prices[flight[1]], prices[flight[0]] + flight[2]);
            }
        }
        int[] temp = prices.clone();
        for(int[] flight: flights) {
            if (temp[flight[0]] == Integer.MAX_VALUE) continue;
            temp[flight[1]] = Math.min(temp[flight[1]], temp[flight[0]] + flight[2]);
        }

        if (!Arrays.equals(prices, temp)) for(int i=0;i<n;i++) prices[i] = -1; // Negative Cycle
        return prices;
    }

    public static void main(String[] args) {
        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
        int[] result = bellmanFordAlgorithm.shortestPathFromSourceToCities(6, new int[][]{{0,1,5},{1,2,1},{1,3,2},{2,4,1},{4,3,-1},{3,5,2},{5,4,-3}}, 0);
        for(int i : result){ 
            if (i == Integer.MAX_VALUE) i = -1; 
            System.out.println(i);
        }
    }
}