package Backtracking;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        calculate(0, 0, candidates, target, list, result);
        return result;
    }

    private void calculate(int index, int totalSum, int[] candidates, int target, List<Integer> list, List<List<Integer>> result) {
        if (index >= candidates.length || totalSum > target) return;
        if(totalSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        calculate(index+1, totalSum, candidates, target, list, result);

        list.add(candidates[index]);
        calculate(index, totalSum+candidates[index], candidates, target, list, result);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7}, 7));
    }
}