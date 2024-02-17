package Backtracking;

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findSubsets(0, nums, list, result);
        return result;
    }

    private void findSubsets(int index, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        findSubsets(index+1, nums, list, result);

        list.add(nums[index]);
        findSubsets(index+1, nums, list, result);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));
    }
}