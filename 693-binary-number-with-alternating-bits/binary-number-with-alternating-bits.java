class Solution {
    public boolean hasAlternatingBits(int n) {
        StringBuilder binary=new StringBuilder();
        while(n>0){
            binary.append(n%2);
            n/=2;
        }   
        String str = binary.reverse().toString();
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1))
                return false;
        }
        return true;
    }
}