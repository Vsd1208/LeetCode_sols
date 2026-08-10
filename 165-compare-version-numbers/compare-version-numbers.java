class Solution {
    public int compareVersion(String version1, String version2) {
        String[] sv1 = version1.split("\\.");
        String[] sv2 = version2.split("\\.");
        int l = Math.max(sv1.length,sv2.length);
        for(int i=0;i<l;i++){
            int num1 = i<sv1.length?Integer.valueOf(sv1[i]):0;
            int num2 = i<sv2.length?Integer.valueOf(sv2[i]):0;
            if(num1<num2) return -1;
            else if(num1>num2) return 1;
            else if(num1==num2 && i<l-1) continue;
        }
        return 0;
    }
}