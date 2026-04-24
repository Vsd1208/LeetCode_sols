class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l_count=0;
        int r_count=0,_count=0;
        for(char ch:moves.toCharArray()){
            if(ch=='L') l_count++;
            else if(ch=='R') r_count++;
            else _count++;
        }
        return (Math.max(l_count,r_count) + _count) - Math.min(l_count,r_count);
    }
}