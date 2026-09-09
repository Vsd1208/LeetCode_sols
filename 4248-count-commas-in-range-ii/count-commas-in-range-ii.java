class Solution {
    public long countCommas(long n) {
        long max_coms=0,p10=1,tot_coms=0;
        while(p10<=n){
            max_coms++;
            p10*=1000;
        }
        for(int i=1;i<=max_coms;i++){
            long start=1;
            for(int j=0;j<i;j++){
                start*=1000;
            }
            long end = start*1000-1;
            if(start<=n){
                long count = Math.min(n,end) - start + 1;
                count*=i;
                tot_coms+=count;
            }
        }
        return tot_coms;
    }
}