class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        for(List<String> val:knowledge){
            map.put(val.get(0),val.get(1));
        }
        List<Integer> sb = new ArrayList<>();
        List<Integer> cb = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') sb.add(i);
            if(s.charAt(i)==')') cb.add(i);
        }
        HashMap<Integer,Integer> match = new HashMap<>();
        for(int i=0;i<sb.size();i++){
            match.put(sb.get(i),cb.get(i));
        }
        String result="";
        char ch;
        int j=0;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            if(ch=='('){
                j=match.get(i);
                result+=map.getOrDefault(s.substring(i+1,j),"?");
                i=j;
            }
            else result+=ch;
        }
        return result;
    }
}