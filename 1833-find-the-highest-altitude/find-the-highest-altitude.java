class Solution {
    public int largestAltitude(int[] gain) {
        int diff=0,max=0;
        for(int i=0;i<gain.length;i++){
            diff+=gain[i];
            max=Math.max(max,diff);
        }
        return max;
    }
}