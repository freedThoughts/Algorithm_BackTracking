package problemSet_1;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList();
        generate(results, n, new ArrayList(), 0);
        return results;
    }

    void generate(List<List<String>> results, int maxSize, List<String> currentList,
                  int currentRow) {

        if (currentList.size() == maxSize) {
            results.add(new ArrayList(currentList));
            return;
        }

        for (int j = 0; j < maxSize; j++) {
            if (isQCanBeAttacked(currentList, j))
                continue;

            String str = getStringHavingQAtgivenJ(j, maxSize);
            currentList.add(str);
            generate(results, maxSize, currentList, currentRow+1);
            currentList.remove(currentList.size() -1);
        }
    }

    String getStringHavingQAtgivenJ(int j, int maxSize) {
        char[] chars = new char[maxSize];
        for(int i = 0; i < maxSize; i++) {
            if (i == j)
                chars[i] = 'Q';
            else chars[i] = '.';
        }
        return new String(chars);
    }

    boolean isQCanBeAttacked(List<String> currentList, int col) {
        for (int i = 1; currentList.size()-i >= 0; i++) {
            String lastStr = currentList.get(currentList.size()-i);
            if (lastStr.charAt(col) != '.')
                return true;
            if (col-i >= 0 && lastStr.charAt(col-i) != '.')
                return true;
            if (col+i < lastStr.length() && lastStr.charAt(col+i) != '.')
                return true;
        }
        return false;
    }
}
