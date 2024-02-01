class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length-1;
        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left));
            if (height[left] >= height[right]) right--;
            else left++;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}