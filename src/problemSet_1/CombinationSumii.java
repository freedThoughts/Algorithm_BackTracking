package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumii {
    public static void main(String[] str) {
        int[] candidates= {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates, 8));

    }
/*
    public static List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        Arrays.sort(candidates);

        backtrack2(candidates, comb, target, 0, results);
        return results;
    }

    private static void backtrack2(int[] candidates, LinkedList<Integer> comb,
                           Integer remain, Integer curr,
                           List<List<Integer>> results) {
        if (remain == 0) {
            // copy the current combination to the final list.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int nextCurr = curr; nextCurr < candidates.length; ++nextCurr) {
            if (nextCurr > curr && candidates[nextCurr] == candidates[nextCurr - 1])
                continue;

            Integer pick = candidates[nextCurr];
            // optimization: early stopping
            if (remain - pick < 0)
                break;

            comb.addLast(pick);
            backtrack2(candidates, comb, remain - pick, nextCurr + 1, results);
            comb.removeLast();
        }
    }*/

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        backTrack(candidates, results, currentList, target, 0);
        return results;
    }

    // Every index is new stack.
    static void backTrack(int[] candidates, List<List<Integer>> results, List<Integer> currentList, int target, int index) {
        if (target == 0) {
            results.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0 || index == candidates.length) return;

        // Every index is new Stack
        // i is loop within a stack
        for (int i = index; i < candidates.length; i++) {
            // Avoid any candidate whose previous candidate share same value *************
            if (index != i && candidates[i] == candidates[i-1]) continue;
            currentList.add(candidates[i]);
            backTrack(candidates, results, currentList, target - candidates[i], i+1);
            currentList.remove(currentList.size()-1);
        }
    }
}





