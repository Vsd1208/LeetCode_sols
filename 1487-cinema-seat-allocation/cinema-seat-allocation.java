// class Solution {
//     int count=0;
//     private boolean check(boolean[][] hall,int row,int start){
//         for(int j=start;j<start+4;j++){
//             if(hall[row][j]) return false;
//         }
//         return true;
//     }
//     public int maxNumberOfFamilies(int n,int[][] reservedSeats){
//         boolean[][] hall=new boolean[n][10];
//         for(int[] seat:reservedSeats){
//             hall[seat[0]-1][seat[1]-1]=true;
//         }
//         count=0;
//         for(int i=0;i<n;i++){
//             boolean left=check(hall,i,1);   // seats 2-5
//             boolean middle=check(hall,i,3); // seats 4-7
//             boolean right=check(hall,i,5);  // seats 6-9
//             if(left && right)
//                 count+=2;
//             else if(left || middle || right)
//                 count+=1;
//         }
//         return count;
//     }
// }
class Solution {
    public int maxNumberOfFamilies(int n,int[][] reservedSeats) {
        HashMap<Integer,boolean[]> map=new HashMap<>();

        for(int[] seat:reservedSeats){
            int row=seat[0];
            int col=seat[1];

            if(!map.containsKey(row))
                map.put(row,new boolean[10]);

            map.get(row)[col-1]=true;
        }

        int count=(n-map.size())*2;

        for(boolean[] hall:map.values()){
            boolean left=true;
            boolean middle=true;
            boolean right=true;

            for(int j=1;j<=4;j++){
                if(hall[j]) left=false;
            }

            for(int j=3;j<=6;j++){
                if(hall[j]) middle=false;
            }

            for(int j=5;j<=8;j++){
                if(hall[j]) right=false;
            }

            if(left && right)
                count+=2;
            else if(left || middle || right)
                count+=1;
        }

        return count;
    }
}