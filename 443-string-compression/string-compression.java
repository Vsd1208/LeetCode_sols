class Solution {
    public int compress(char[] chars) {
        String str = "";
        int start=0;
        while(start<chars.length){
            int count=1;
            while(start + 1 < chars.length && chars[start]==chars[start+1]){
                count++;
                start++;
            }
            if(count>1) str+=""+chars[start]+count;
            else str+=chars[start];
            start++;
        }
        char[] temp = str.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            chars[i] = temp[i];
        }
        return str.length();
    }
}