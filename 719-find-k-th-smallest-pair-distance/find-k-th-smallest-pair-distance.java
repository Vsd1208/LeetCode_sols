// class Solution {
//     public int smallestDistancePair(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int i=0;i<nums.length-1;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 pq.add(Math.abs(nums[i]-nums[j]));
//             }
//         }
//         for(int i=0;i<k-1;i++){
//             int q = pq.poll();
//         }
//         return pq.peek();
//     }
// }
import java.util.*;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;

            if (countPairs(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int countPairs(int[] nums, int maxDist) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDist) {
                left++;
            }
            count += right - left;
        }

        return count;
    }
}