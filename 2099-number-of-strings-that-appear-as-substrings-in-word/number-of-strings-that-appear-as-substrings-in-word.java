class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        HashSet<String> sub = new HashSet<>();
        for(int i=0;i<word.length();i++){
            for(int j=i+1;j<=word.length();j++){
                sub.add(word.substring(i,j));
            }
        }
        for(String str:patterns){
            if(sub.contains(str)) count++;
        }
        return count;
    }
}