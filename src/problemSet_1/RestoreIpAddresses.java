package problemSet_1;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/restore-ip-addresses/submissions/
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        backTrack(results, s, 0, 0, new String());
        return results;
    }

    void backTrack(List<String> results, String s, int i, int subset, String currentString) {
        if (subset == 4) {
            if (i != s.length()) return;
            results.add(currentString);
            return;
        }

        if (i >= s.length()) return;
        String dot = currentString.length() == 0 ? "" : new String(".");
        backTrack(results, s, i+1, subset+1, currentString + dot + new String(new char[] { s.charAt(i)}));

        if (i+1 >= s.length() || s.charAt(i) == '0') return;
        backTrack(results, s, i+2, subset+1, currentString + dot + new String(new char[] { s.charAt(i), s.charAt(i+1)}));

        if(i+2 >= s.length()) return;
        String str = new String(new char[] {s.charAt(i), s.charAt(i+1), s.charAt(i+2)});

        if (Integer.valueOf(str) < 256)
            backTrack(results, s, i+3, subset+1, currentString + dot + str);
    }
}
