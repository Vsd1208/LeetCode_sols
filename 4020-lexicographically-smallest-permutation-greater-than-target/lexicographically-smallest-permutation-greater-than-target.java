// class Solution {
//     private String lex="";
//     private void backTrack(String s,StringBuilder sb,boolean[] used,String target){
//         if(sb.length()==target.length()){
//             String curr=sb.toString();
//             if(curr.compareTo(target)>0){
//                 if(lex.equals("")||curr.compareTo(lex)<0){
//                     lex=curr;
//                 }
//             }
//             return;
//         }
//         for(int i=0;i<s.length();i++){
//             if(used[i]) continue;
//             used[i]=true;
//             sb.append(s.charAt(i));
//             backTrack(s,sb,used,target);
//             sb.deleteCharAt(sb.length()-1);
//             used[i]=false;
//         }
//     }
//     public String lexGreaterPermutation(String s,String target) {
//         boolean[] used=new boolean[s.length()];
//         backTrack(s,new StringBuilder(),used,target);
//         return lex;
//     }
// }
class Solution {
    public String lexGreaterPermutation(String s,String target) {
        char[] chr=s.toCharArray();
        Arrays.sort(chr);

        int n=target.length();

        // Try each position from right to left
        for(int pos=n-1;pos>=0;pos--){
            boolean[] tf=new boolean[n];
            StringBuilder lex=new StringBuilder();

            // Match target[0...pos-1] exactly
            boolean possible=true;

            for(int i=0;i<pos;i++){
                boolean found=false;

                for(int j=0;j<n;j++){
                    if(!tf[j]&&chr[j]==target.charAt(i)){
                        lex.append(chr[j]);
                        tf[j]=true;
                        found=true;
                        break;
                    }
                }

                if(!found){
                    possible=false;
                    break;
                }
            }

            if(!possible) continue;

            // At pos, find the smallest unused character > target[pos]
            boolean greaterFound=false;

            for(int j=0;j<n;j++){
                if(!tf[j]&&chr[j]>target.charAt(pos)){
                    lex.append(chr[j]);
                    tf[j]=true;
                    greaterFound=true;
                    break;
                }
            }

            if(!greaterFound) continue;

            // Fill remaining positions with smallest unused characters
            for(int j=0;j<n;j++){
                if(!tf[j]){
                    lex.append(chr[j]);
                    tf[j]=true;
                }
            }

            return lex.toString();
        }

        return "";
    }
}