class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        HashSet<Character> set = new HashSet<>();
        for(char ch:word.toCharArray())
            set.add(ch);
        for(char ch:set){
            if((ch>='a' && ch<='z') && set.contains(Character.toUpperCase(ch))) count++; 
        }
        return count;
    }
}