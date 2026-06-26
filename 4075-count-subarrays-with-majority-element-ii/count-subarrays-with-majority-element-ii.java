// class Solution {
//     private int[] array_builder(int[] nums,int target){
//         int[] arr = new int[nums.length];
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==target) arr[i]=1;
//             else arr[i]=-1;
//         }
//         arr = prefix_sum(arr);
//         return arr;
//     }
//     private int[] prefix_sum(int[] nums){
//         int[] pref = new int[nums.length+1];
//         pref[0]=0;
//         for(int i=1;i<nums.length;i++)
//             pref[i]=pref[i-1]+nums[i-1];
//         return pref;
//     }
//     private long mergesort(int[] arr,int low,int high){
//         if(high<=low) return 0;
//         int mid = (high+low)/2;
//         long count=0;
//         count+=mergesort(arr,low,mid);
//         count+=mergesort(arr,mid+1,high);
//         count+=countPairs(arr, low, mid, high);
//         merge(arr,low,mid,high);
//         return count;
//     }
//     private long countPairs(int[] arr, int low, int mid, int high) {

//         long count = 0;

//         int j = mid + 1;

//         for (int i = low; i <= mid; i++) {

//             while (j <= high && arr[j] <= arr[i]) {
//                 j++;
//             }

//             count += (high - j + 1);
//         }
//         return count;
//     }
//     private void merge(int[] arr,int low,int mid,int high){

//         int[] l = new int[mid-low+1];
//         int[] r = new int[high-mid];

//         for(int i=0;i<l.length;i++)
//             l[i]=arr[low+i];

//         for(int j=0;j<r.length;j++)
//             r[j]=arr[mid+1+j];

//         int i=0,j=0,k=low;

//         while(i<l.length && j<r.length){

//             if(l[i]<=r[j])
//                 arr[k++]=l[i++];
//             else
//                 arr[k++]=r[j++];
//         }

//         while(i<l.length)
//             arr[k++]=l[i++];

//         while(j<r.length)
//             arr[k++]=r[j++];
//     }
//     public long countMajoritySubarrays(int[] nums, int target) {
//         int[] arr = array_builder(nums,target);
//         return mergesort(arr,0,arr.length-1);
//     }
// }
import java.util.*;

class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        // Step 1: Build prefix sums
        int[] pref = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        // Step 2: Coordinate Compression
        int[] sorted = pref.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }

        // Step 3: Fenwick Tree
        Fenwick bit = new Fenwick(rank);

        long ans = 0;

        for (int x : pref) {

            int idx = map.get(x);

            // Count previous prefix sums < current prefix sum
            ans += bit.query(idx - 1);

            // Insert current prefix sum
            bit.update(idx, 1);
        }

        return ans;
    }
}