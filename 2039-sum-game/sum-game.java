class Solution {
    public boolean sumGame(String num) {
        int firsthalf=0,secondhalf=0;
        int q1=0,q2=0;
        for(int i=0;i<num.length()/2;i++){
            if(num.charAt(i)=='?')
                q1++;
            else
                firsthalf+=num.charAt(i)-'0';
        }
        for(int i=num.length()/2;i<num.length();i++){
            if(num.charAt(i)=='?')
                q2++;
            else
                secondhalf+=num.charAt(i)-'0';
        }
        if((q1+q2)%2==1) return true;
        return firsthalf-secondhalf!=(q2-q1)*9/2;
    }
}