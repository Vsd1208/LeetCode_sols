class Solution {
    public boolean judgeCircle(String moves) {
        int state=0;
        for(int i=0;i<moves.length();i++){
            char ch=moves.charAt(i);
            if(ch=='R') state+=1;
            else if(ch=='L') state-=1;
            else if(ch=='U') state+=10;
            else state-=10;
        }
        return state==0;
    }
}