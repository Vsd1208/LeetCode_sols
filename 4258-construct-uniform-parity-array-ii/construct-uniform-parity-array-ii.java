class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 == 0) {
                minEven = Math.min(minEven, num);
            } else {
                minOdd = Math.min(minOdd, num);
            }
        }

        // No odd numbers -> all numbers are already even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // No even numbers -> all numbers are already odd
        if (minEven == Integer.MAX_VALUE) {
            return true;
        }

        // Convert every even number to odd using the smallest odd
        return minOdd < minEven;
    }
}