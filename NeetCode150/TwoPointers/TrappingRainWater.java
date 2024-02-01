class TrappingRainWater {
    public int trap(int[] height) {
        int top = -1;
        int[] left = new int[height.length];
        left[0] = top;
        for(int i=1;i<height.length;i++) {
            top = Math.max(top, height[i-1]);
            left[i] = top;
        }
        top = height[height.length-1];
        int result = 0;
        for(int i=height.length-2;i>0;i--) {
            if (Math.min(top, left[i]) > height[i]) {
                result = result + Math.min(top, left[i]) - height[i];
            }
            top = Math.max(top, height[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}