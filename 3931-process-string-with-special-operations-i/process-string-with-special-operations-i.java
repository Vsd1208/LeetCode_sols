class Solution {
    private void duplicate(StringBuilder sb,String str){
        sb.append(str);
    }
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='#'){
                String str = sb.toString();
                duplicate(sb,str);
            }
            else if(ch=='*'){
                if(sb.length() > 0)
                    sb.deleteCharAt(sb.length()-1);
            }
            else if(ch=='%') sb.reverse();
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}