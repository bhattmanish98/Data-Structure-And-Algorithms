class PerfectSquare {
    // Time Complexity - O(nlog(n))
    public int numSquares(int n) {  
        int[] memory = new int[n+1];
        if(n==0||n==1) return n;
        memory[0] = 0;
        memory[1] = 1;
        for(int i=2;i<=n;i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++) min = Math.min(min, 1 + memory[i-j*j]);
            memory[i] = min;
        }
        return memory[n];
    }

    public static void main(String[] args) {
        PerfectSquare perfectSquare = new PerfectSquare();
        System.out.println(perfectSquare.numSquares(13));
    }
    
}