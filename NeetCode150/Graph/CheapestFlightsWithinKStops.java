package Graph;

class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        for(int i=0;i<n;i++) prices[i] = Integer.MAX_VALUE;
        prices[src] = 0;
        for(int i=0;i<=k;i++) {
            int[] temp = prices.clone();
            for(int[] flight: flights) {
                if (prices[flight[0]] == Integer.MAX_VALUE) continue;
                temp[flight[1]] = Math.min(temp[flight[1]], prices[flight[0]] + flight[2]);
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];

    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        System.out.println(cheapestFlightsWithinKStops.findCheapestPrice(5, new int[][]{{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}}, 2, 1, 1));
    }
}