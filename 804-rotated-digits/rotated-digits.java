class Solution {
    private boolean invalid(int k){
        return k==3 || k==4 || k==7;
    }
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++){
            String str = String.valueOf(i);
            boolean hasChange = false;
            boolean isValid = true;
            for(int j = 0; j < str.length(); j++){
                int d = str.charAt(j) - '0';
                if(invalid(d)){
                    isValid = false;
                    break;
                }
                if(d == 2 || d == 5 || d == 6 || d == 9){
                    hasChange = true;
                }
            }
            if(isValid && hasChange) count++;
        }
        return count;
    }
}