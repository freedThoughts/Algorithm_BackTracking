package problemSet_1;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        return generate(nums, new ArrayList<>());
    }

    List<List<Integer>> generate(int[] nums, List<Integer> currentList) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) return results;


        if (nums.length == 1) {
            List<Integer> newCurrentList = new ArrayList<Integer>(currentList);
            newCurrentList.add(nums[0]);
            results.add(newCurrentList);
            return results;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] subNums = new int[nums.length-1];

            for(int m = 0, n = 0; m < nums.length; m++)
                if (m != i) subNums[n++] = nums[m];

            List<Integer> newCurrentList = new ArrayList<Integer>(currentList);
            newCurrentList.add(nums[i]);

            List<List<Integer>> subResults = generate(subNums, newCurrentList);
            results.addAll(subResults);
        }

        return results;
    }
}
