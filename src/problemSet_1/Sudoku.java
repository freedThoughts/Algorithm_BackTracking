package problemSet_1;

import java.util.ArrayList;

public class Sudoku {

    public static void main(String[] arg) {
        ArrayList<String> strArray = new ArrayList<>();
        strArray.add("53..7....");
        strArray.add("6..195...");
        strArray.add(".98....6.");
        strArray.add("8...6...3");
        strArray.add("4..8.3..1");
        strArray.add("7...2...6");
        strArray.add(".6....28.");
        strArray.add("...419..5");
        strArray.add("....8..79");

        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        for (int i = 0; i < strArray.size(); i++) {
            ArrayList<Character> b = new ArrayList<>();
            for (int j = 0; j < strArray.size(); j++) {
                b.add(strArray.get(i).charAt(j));
            }
            a.add(b);
        }

        solveSudoku(a);
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                System.out.print(a.get(i).get(j));
            }
            System.out.println();
        }
    }


    public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
        generate1(a, 0);
    }

    private static boolean generate1(ArrayList<ArrayList<Character>> results, int row) {
        if (row == 10)
            return true;

        ArrayList<Character> originalArray = new ArrayList<>();
        //for (int i = 0; i < results.get(row).size(); i++)
        //    originalArray.add(results.get(row).get(i));

        originalArray.addAll(results.get(row));

        //System.arraycopy(results.get(row), 0, originalArray, 0, results.get(row).size());

        int i = 0;
        for (int trialStartingVal = 1; trialStartingVal <= results.size(); trialStartingVal++) {

            i = trialStartingVal;
            int col = 0;
            for (; col < results.size(); col++) {
                if (results.get(row).get(col) != '.') continue;

                while (i <= results.size() && !isValid(results, row, col, i)) {
                    i++;
                }

                if (i > results.size())
                    break;

                results.get(row).set(col, (char) i);
                i++;
            }

            if (i > results.size() && col < results.size()) {
                results.set(row, originalArray);
                continue;
            }

            boolean isForwardStackSuccess = generate1(results, row+1);
            if (isForwardStackSuccess)
                return true;
            results.set(row, originalArray);
        }
        return false;
    }

    private static boolean isValid(ArrayList<ArrayList<Character>> results, int row, int col, int val) {
        for (int j = 0; j < results.size(); j++) {
            ArrayList<Character> rowArray = results.get(row);
            if (rowArray.get(j).equals((char) val))
                return false;
        }

        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).get(col).equals((char) val))
                return false;

        }

        for (int i = (row/3) * 3; i < (row/3) * 3+3; i++) {
            for (int j = (col/3) * 3; j < (col/3) * 3+3; j++) {
                if (results.get(i).get(j).equals((char) val))
                    return false;
            }
        }

        return true;
    }

/*
    private void generate(ArrayList<ArrayList<Character>> results, int row) {
*//*        if (row != 0) {
            results.set(row-1, currentArray);
            currentArray = new ArrayList<Character>();
        }*//*

        if (row == results.size()) {
            return;
        }

        ArrayList<Character> originalList = new ArrayList<Character>();
        System.arraycopy(results.get(row), 0, originalList, 0, results.size());

        for (int val = 1; val <= results.size(); val++) {
            
            //generateWithInRow(originalList, val);
            int i = val;
            for (int col = 0; col < results.size(); col++) {
                if (originalList.get(col) != '.') continue;

                while (i <= results.size() && !isValid(results, originalList, row, i)) {
                    i++;
                }

                if (i > results.size()) {
                    return;
                }
                originalList.set(col, new Character((char)i));
                i++;
            }
        }

        
        generate(results, originalList, row);
        
        




    }

    private void generateWithInRow(ArrayList<Character> currentList, int val) {
    }*/
}
