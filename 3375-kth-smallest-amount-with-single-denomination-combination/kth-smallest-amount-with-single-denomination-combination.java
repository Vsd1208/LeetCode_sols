// class Solution {
//     public long findKthSmallest(int[] coins,int k){
//         HashSet<Long> set=new HashSet<>();
//         for(int num=1;num<=k;num++){
//             for(int coin:coins){
//                 set.add((long)coin*num);
//             }
//         }
//         List<Long> list=new ArrayList<>(set);
//         Collections.sort(list);
//         return list.get(k-1);
//     }
// }
// class Solution {
//     public long findKthSmallest(int[] coins,int k){
//         int min=coins[0];
//         for(int coin:coins){
//             min=Math.min(min,coin);
//         }
//         long count=0;
//         for(long i=1;i<=(long)min*k;i++){
//             for(int coin:coins){
//                 if(i%coin==0){
//                     count++;
//                     break;
//                 }
//             }
//             if(count==k) return i;
//         }
//         return -1;
//     }
// }
class Solution {
    private long gcd(long a,long b){
        while(b!=0){
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }

    private long lcm(long a,long b){
        return a/gcd(a,b)*b;
    }

    private long countValid(long num,int[] coins){
        int n=coins.length;
        long count=0;

        for(int mask=1;mask<(1<<n);mask++){
            long multiple=1;
            int bits=0;
            boolean valid=true;

            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    bits++;
                    multiple=lcm(multiple,coins[i]);

                    if(multiple>num){
                        valid=false;
                        break;
                    }
                }
            }

            if(!valid) continue;

            if(bits%2==1)
                count+=num/multiple;
            else
                count-=num/multiple;
        }

        return count;
    }

    public long findKthSmallest(int[] coins,int k){
        int min=coins[0];

        for(int coin:coins){
            min=Math.min(min,coin);
        }

        long low=1;
        long high=(long)min*k;

        while(low<high){
            long mid=low+(high-low)/2;

            long count=countValid(mid,coins);

            if(count<k){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }

        return low;
    }
}