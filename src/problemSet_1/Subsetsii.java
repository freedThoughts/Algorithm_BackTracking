package problemSet_1;

import java.util.ArrayList;
import java.util.List;

public class Subsetsii {

    public static void main(String[] arg) {
        List<List<Integer>> ans = subsetsWithDup(new int[] {1, 2, 2});
        ans.stream().forEachOrdered(System.out::print);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, new ArrayList<Integer>(), 0, nums);
        return ans;
    }

    static void backTrack(List<List<Integer>> ans, List<Integer> currentList, int startIndex, int[] nums) {
        System.out.println("CurrentList = " + currentList);
        ans.add(new ArrayList<>(currentList));

        for (int i = startIndex; i < nums.length; i++) {
            System.out.println("StartIndex = " + startIndex + " i = " + i);
            if (i != startIndex && nums[i] == nums[i-1]) continue;

            currentList.add(nums[i]);
            backTrack(ans, currentList, i+1, nums);
            currentList.remove(currentList.size()-1);
        }

        String s = new String();
        s.toLowerCase();

    }







    static void backTrack2(List<List<Integer>> ans, List<Integer> currentList, int index, int[] nums) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(currentList));
            return;
        }

        backTrack(ans, currentList, index+1, nums);

        if(index != 0 && nums[index] == nums[index-1] && (currentList.size() == 0 || nums[index] != currentList.get(currentList.size()-1))) return;

        currentList.add(nums[index]);
        backTrack(ans, currentList, index+1, nums);
        currentList.remove(currentList.size()-1);
    }
}
