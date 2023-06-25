package leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currentCombination.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, currentCombination, combinations);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
//https://leetcode.com/problems/combination-sum/