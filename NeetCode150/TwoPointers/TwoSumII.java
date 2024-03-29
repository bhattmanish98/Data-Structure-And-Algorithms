class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        while(i<j) {
            int sum = numbers[i] + numbers[j];
            if(sum==target) return new int[]{i+1, j+1};
            if(sum>target) j--;
            else i++;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] result = twoSumII.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(result[0]+" "+result[1]);
    }
}