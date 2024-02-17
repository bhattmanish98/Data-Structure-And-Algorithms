package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        check(new ArrayList<>(),Arrays.stream(nums).boxed().toList(), result);
        return result;
    }

    private void check(List<Integer> included, List<Integer> toBeInclude, List<List<Integer>> result) {
        if (toBeInclude.size() == 0) {
            result.add(new ArrayList<>(included));
            return;
        }

        for (int i=0;i<toBeInclude.size();i++) {
            List<Integer> a = new ArrayList<>(included);
            List<Integer> b = new ArrayList<>(toBeInclude);
            a.add(toBeInclude.get(i));
            b.remove(i);
            check(a, b, result);
        }
        

    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1,2,3}));
    }
}