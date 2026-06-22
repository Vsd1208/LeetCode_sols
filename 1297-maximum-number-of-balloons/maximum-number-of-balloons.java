class Solution {
    public int maxNumberOfBalloons(String text) {
        // HashMap<Character,Integer> map = new HashMap<>();
        // String str = "balloon";
        // for(int i=0;i<str.length();i++){
        //     char ch = str.charAt(i);
        //     if(map.containsKey(ch)){
        //         map.put(ch,map.get(ch)+1);
        //     }
        //     else{
        //         map.put(ch,1);
        //     }
        // }
        // for(int i=0;i<text.length();i++){
        //     char ch = text.charAt(i);
            
        // }
        int[][] freq = new int[26][2];
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            freq[ch-'a'][1]+=1;
        }
        String str = "balloon";
        int min = Integer.MAX_VALUE;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='l'||ch=='o'){
                min=Math.min(min,freq[ch-'a'][1]/2);
            }
            else
                min=Math.min(min,freq[ch-'a'][1]);
        }
        return min;
    }
}