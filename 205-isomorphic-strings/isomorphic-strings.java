class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            int last1 = map1.getOrDefault(ch1, -1);
            int last2 = map2.getOrDefault(ch2, -1);
            if(last1 != last2)
                return false;
            map1.put(ch1, i);
            map2.put(ch2, i);
        }
        return true;
    }
}