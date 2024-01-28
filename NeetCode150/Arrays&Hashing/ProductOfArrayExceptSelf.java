class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int forwardMult = 1;
        for (int i = 0; i < len; i++) {
            result[i] = forwardMult;
            forwardMult *= nums[i];
        }
        int reverseMult = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= reverseMult;
            reverseMult *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] result = productOfArrayExceptSelf.productExceptSelf(new int[]{1,2,3,4});
        for(int value: result) System.out.println(value);
    }
}