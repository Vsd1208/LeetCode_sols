// class Solution {
//     int ones=0;
//     private void count(int index,int n){
//         if(index>n) return;
//         String str = Integer.toString(index);
//         for(int i=0;i<str.length();i++){
//             if(str.charAt(i)=='1') ones++;
//         }
//         count(index+1,n);
//     }
//     public int countDigitOne(int n) {
//         count(0,n);
//         return ones;
//     }
// }
class Solution {
    public int countDigitOne(int n) {
        long factor = 1;
        int count = 0;

        while (factor <= n) {
            long higher = n / (factor * 10);
            long current = (n / factor) % 10;
            long lower = n % factor;

            if (current == 0) {
                count += higher * factor;
            } 
            else if (current == 1) {
                count += higher * factor + lower + 1;
            } 
            else {
                count += (higher + 1) * factor;
            }

            factor *= 10;
        }

        return count;
    }
}