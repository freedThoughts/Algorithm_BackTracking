package problemSet_1;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> results = new ArrayList<>();
        backTrack(results, s, new String(), 0);
        return results;
    }

    void backTrack(List<String> results, String input, String currentString, int i) {
        if (i == input.length()) {
            results.add(currentString);
            return;
        }

        char ch = input.charAt(i);
        String charString = new String(new char[] {ch});
        if (ch >= 48 && ch <= 57) {
            backTrack(results, input, currentString + charString, i+1);
            return;
        }

        backTrack(results, input, currentString + charString.toLowerCase(), i+1);
        backTrack(results, input, currentString + charString.toUpperCase(), i+1);
    }
}
