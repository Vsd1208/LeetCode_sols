import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> reversedIndices = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currentVal = nums[i];
            if (reversedIndices.containsKey(currentVal)) {
                int prevIndex = reversedIndices.get(currentVal);
                minDistance = Math.min(minDistance, i - prevIndex);
            }
            int revVal = reverse(currentVal);
            reversedIndices.put(revVal, i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}