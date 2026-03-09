import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<nums.length-3;i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
                continue;

            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;

                int left=j+1;
                int right=nums.length-1;

                long t = (long)nums[i] + nums[j];

                while(left<right)
                {
                    long sum = t + nums[left] + nums[right];

                    if(sum == target)
                    {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        ans.add(l);

                        left++;
                        right--;

                        while(left<right && nums[left]==nums[left-1]) left++;
                        while(left<right && nums[right]==nums[right+1]) right--;
                    }
                    else if(sum < target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}