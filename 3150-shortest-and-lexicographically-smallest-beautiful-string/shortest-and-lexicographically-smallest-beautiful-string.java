class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int count=0,len=s.length(),bl=0;
        String beau="";
        for(int i=0;i<len;i++){
            count=0;
            for(int j=i;j<len;j++){
                if(s.charAt(j)=='1') count++;
                if(count==k){
                    int l = j-i+1;
                    if(bl==l){
                        String sub = s.substring(i,j+1);
                        if(beau.compareTo(sub)>0) beau=sub;
                    }
                    else if(bl>l){
                        beau = s.substring(i,j+1);
                        bl=l;
                    }
                    else if(beau.isEmpty()){
                        beau = s.substring(i,j+1);
                        bl = j-i+1;
                    }
                    break;
                }
            }
        }
        return beau;
    }
}