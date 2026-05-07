import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int begin = nums[i];
            
            // While the next number is consecutive, move the pointer forward
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            int end = nums[i];
            
            // If begin and end are the same, it's a single number range
            if (begin == end) {
                ans.add("" + begin);
            } else {
                // Otherwise, format as "begin->end"
                ans.add(begin + "->" + end);
            }
        }
        
        return ans;
    }
}
