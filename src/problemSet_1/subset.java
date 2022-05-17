package problemSet_1;

import java.util.ArrayList;
import java.util.Collections;

public class subset {

    static int count = 0;
    static int countStack = 0;

    public static void main(String[] arg) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);
        input.add(8);
        input.add(9);
        input.add(0);

        System.out.println(subsets(input));
        System.out.println("Count : " + count);
        System.out.println("stackCount : " + countStack);


    }


    // O(2^n) .... TODO : explaination
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A){
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Collections.sort(A);
        generate(results, new ArrayList<Integer>(), 0, A);
        return results;
    }

    static void generate(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> currentList,  int index, ArrayList<Integer> inputList) {
        countStack++;
        results.add(new ArrayList<>(currentList));
        if (index == inputList.size())
            return;

        for (int i = index; i < inputList.size(); i++) {
            count++;
            currentList.add(inputList.get(i));
            generate(results, currentList, i+1, inputList);
            currentList.remove(currentList.size()-1);
        }
    }
}
