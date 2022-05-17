package problemSet_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterPhone {

    Map<Character, List<String>> map = new HashMap();
    public ArrayList<String> letterCombinations(String A) {
        List<String> ls = new ArrayList();
        ls.add("a");
        ls.add("b");
        ls.add("c");
        map.put('2', ls);

        ls = new ArrayList();
        ls.add("d");
        ls.add("e");
        ls.add("f");
        map.put('3', ls);

        ls = new ArrayList();
        ls.add("g");
        ls.add("h");
        ls.add("i");
        map.put('4', ls);

        ls = new ArrayList();
        ls.add("j");
        ls.add("k");
        ls.add("l");
        map.put('5', ls);

        ls = new ArrayList();
        ls.add("m");
        ls.add("n");
        ls.add("o");
        map.put('6', ls);

        ls = new ArrayList();
        ls.add("p");
        ls.add("q");
        ls.add("r");
        ls.add("s");
        map.put('7', ls);

        ls = new ArrayList();
        ls.add("t");
        ls.add("u");
        ls.add("v");
        map.put('8', ls);

        ls = new ArrayList();
        ls.add("w");
        ls.add("x");
        ls.add("y");
        ls.add("z");
        map.put('9', ls);

        ls = new ArrayList();
        ls.add("0");
        map.put('0', ls);

        ls = new ArrayList();
        ls.add("1");
        map.put('1', ls);

        ArrayList<String> results = new ArrayList();
        if (A.length() != 0)
            generate(results, A, 0, "");
        return results;
    }

    private void generate(List<String> results, String A, int index, String currentString) {
        if (index == A.length()) {
            results.add(currentString);
            return;
        }

        List<String> letters = map.get(A.charAt(index));
        for(String a : letters)
            generate(results, A, index+1, currentString + a);

    }
}
