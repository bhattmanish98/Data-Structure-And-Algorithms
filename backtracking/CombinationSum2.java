package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
        List<List<Integer>> result = new ArrayList<>();
        private void findCombination(int start, int target, int[] candidates, List<Integer> combination) {
            if (target == 0) {
                if (!result.contains(combination)) result.add (new ArrayList<>(combination));
                return;
            }
            if (target < 0) return;
            int prev = -1;
            for (int i=start;i<candidates.length;i++) {
                if (candidates[i] == prev) continue;
                combination.add(candidates[i]);
                findCombination(i + 1, target - candidates[i], candidates, combination);
                combination.remove(combination.size() - 1);
                prev = candidates[i];
            }

        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<Integer> combination = new ArrayList<>();
            Arrays.sort(candidates);
            findCombination(0, target, candidates, combination);
            return result;
        }

        public static void main(String[] args) {
            int[] candidates = {10,1,2,7,6,1,5};
            int target = 8;
            CombinationSum2 combinationSum2 = new CombinationSum2();
            System.out.print(combinationSum2.combinationSum2(candidates, target));
        }

}
