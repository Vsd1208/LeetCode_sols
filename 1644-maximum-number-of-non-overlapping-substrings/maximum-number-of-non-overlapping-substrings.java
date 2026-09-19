// class Solution {
//     public List<String> maxNumOfSubstrings(String s) {
        
//     }
// }
import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, n);
        
        // Step 1: Record leftmost and rightmost indices for each character
        for (int i = 0; i < n; ++i) {
            int idx = s.charAt(i) - 'a';
            left[idx] = Math.min(left[idx], i);
            right[idx] = i;
        }
        
        List<String> res = new ArrayList<>();
        int lastRight = -1;
        
        // Step 2: Iterate and find valid non-overlapping substrings
        for (int i = 0; i < n; ++i) {
            if (i != left[s.charAt(i) - 'a']) continue;
            
            int newRight = right[s.charAt(i) - 'a'];
            boolean valid = true;
            
            for (int j = i + 1; j <= newRight; ++j) {
                // If any character inside has an earlier start point, expand or invalidate
                if (left[s.charAt(j) - 'a'] < i) {
                    valid = false;
                    break;
                }
                newRight = Math.max(newRight, right[s.charAt(j) - 'a']);
            }
            
            if (valid) {
                if (i <= lastRight && !res.isEmpty()) {
                    res.set(res.size() - 1, s.substring(i, newRight + 1));
                } else {
                    res.add(s.substring(i, newRight + 1));
                }
                lastRight = newRight;
            }
        }
        
        return res;
    }
}