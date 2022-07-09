package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    private void getSolution(int start, int k, int n, List<Integer> temp) {
        if (temp.size() == k) {
            if (n==0) result.add(new ArrayList<>(temp));
            return;
        }
        for (int i=start;i<=9;i++) {
            temp.add(i);
            getSolution(i+1,k,n-i,temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new ArrayList<>();
        getSolution(1,k,n,temp);
        return result;
    }

    public static void main(String[] args) {
        int k = 3, n = 7;
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.print(combinationSum3.combinationSum3(k,n));
    }
}
