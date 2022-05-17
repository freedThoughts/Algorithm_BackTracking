package problemSet_1;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/submissions/
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentList = new ArrayList<Integer>();
        backTrack(ans, 0, nums, currentList);

        return ans;
    }

    void backTrack(List<List<Integer>> ans, int i, int[] nums, List<Integer> currentList) {
        if (i == nums.length) {
            ans.add(new ArrayList(currentList));
            return;
        }
        currentList.add(nums[i]);
        backTrack(ans, i+1, nums, currentList);
        currentList.remove(currentList.size()-1);
        backTrack(ans, i+1, nums, currentList);
    }
}
