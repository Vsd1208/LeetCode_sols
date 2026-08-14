class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        int len = s.length();
        int start=0;
        int ans =0 ;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            while(freq.get(ch)>2){
                freq.put(s.charAt(start),freq.get(s.charAt(start))-1);
                start++;
            }
            ans = Math.max(ans,i-start+1);
        }
        return ans;
    }
}