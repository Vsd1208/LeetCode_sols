class Solution {
    private boolean isanagram(String s,String p){
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            freq[p.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        int l = p.length();
        for(int i=0;i<=s.length()-l;i++){
            String sub = s.substring(i,i+l);
            if(isanagram(p,sub)) indices.add(i);
        }
        return indices;
    }
}