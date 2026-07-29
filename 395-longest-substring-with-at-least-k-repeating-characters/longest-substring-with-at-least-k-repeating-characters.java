class Solution {
    // private boolean check(String str,int k){
    //     HashMap<Character,Integer> map = new HashMap<>();
    //     for(int i=0;i<str.length();i++){
    //         char ch = str.charAt(i);
    //         map.put(ch,map.getOrDefault(ch,0)+1);
    //     }
    //     for(int val : map.values()){
    //         if(val<k) return false;
    //     }
    //     return true;
    // }
    // public int longestSubstring(String s, int k) {
    //     int max = 0;
    //     for(int i=0;i<s.length();i++){
    //         String str;
    //         for(int j=i+k-1;j<s.length();j++){
    //             str=s.substring(i,j+1);
    //             if(check(str,k)) max=Math.max(max,str.length());
    //         }
    //     }
    //     return max;
    // }
    private int solve(String s, int k) {

        if (s.length() < k)
            return 0;

        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {

            if (freq[s.charAt(i) - 'a'] < k) {

                int left = solve(s.substring(0, i), k);

                int right = solve(s.substring(i + 1), k);

                return Math.max(left, right);
            }
        }

        return s.length();
    }
    public int longestSubstring(String s, int k) {
        return solve(s, k);
    }
}