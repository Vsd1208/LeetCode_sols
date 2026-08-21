class Solution {
    private boolean ispermutation(String s1,String s2){
        int[] freq=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            freq[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1,String s2){
        int l1=s1.length(),l2=s2.length();
        if(l1>l2) return false;
        for(int i=0;i<=l2-l1;i++){
            if(ispermutation(s1,s2.substring(i,i+l1))){
                return true;
            }
        }
        return false;
    }
}