class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            set.add(ch);
            if(!map.containsKey(ch))
                map.put(ch,i);
            else{
                if(Character.isLowerCase(ch))
                    map.put(ch,i);
            }
        }
        for(char ch:set){
            if(map.containsKey(Character.toUpperCase(ch))){
                if(map.get(ch)<map.get(Character.toUpperCase(ch)))
                    count++;
            }
        }
        return count;
    }
}