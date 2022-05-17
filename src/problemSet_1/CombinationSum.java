package problemSet_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    public static void main(String[] arg) {
        ArrayList<Integer> input = new ArrayList<>();
/*        input.add(2);
        input.add(3);
        input.add(6);
        input.add(7);*/

        input.add(8);
        input.add(10);
        input.add(6);
        input.add(11);
        input.add(1);
        input.add(16);
        input.add(8);


        System.out.println(combinationSum(input, 28));
    }

    // O(n ^ target)
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        Set<ArrayList<Integer>> results = new LinkedHashSet<>();
        A.sort(Comparator.naturalOrder());
        generate(A, results, new ArrayList(), B, 0);
        return new ArrayList<>(results);
    }

    private static void generate(ArrayList<Integer> inputList, Set<ArrayList<Integer>> results,
                          ArrayList<Integer> currentList, int requiredSum, int index) {

        if (requiredSum == 0)
            results.add(new ArrayList(currentList));
        if (requiredSum <= 0)
            return;

        for (int i = index; i < inputList.size(); i++) {
            currentList.add(inputList.get(i));
            generate(inputList, results, currentList, requiredSum - inputList.get(i), i);
            currentList.remove(currentList.size() -1);
        }
    }
}
