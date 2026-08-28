class Solution {

    private String buildPalindrome(String half,char mid){
        StringBuilder sb=new StringBuilder(half);
        
        if(mid!='#'){
            sb.append(mid);
        }

        sb.append(new StringBuilder(half).reverse());

        return sb.toString();
    }

    public String lexPalindromicPermutation(String s,String target){
        int n=s.length();

        int[] freq=new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        int odd=0;
        char mid='#';

        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                odd++;
                mid=(char)('a'+i);
            }
        }

        // Palindrome is impossible
        if(odd>1) return "";

        StringBuilder halfBuilder=new StringBuilder();

        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i]/2;j++){
                halfBuilder.append((char)('a'+i));
            }
        }

        String half=halfBuilder.toString();
        int m=half.length();

        String prefix=target.substring(0,m);

        int[] count=new int[26];

        for(char ch:half.toCharArray()){
            count[ch-'a']++;
        }

        /*
         * Try to match target's first half.
         * If impossible, increase at the rightmost possible position.
         */
        boolean exact=true;

        for(int i=0;i<m;i++){
            char ch=prefix.charAt(i);

            if(count[ch-'a']>0){
                count[ch-'a']--;
            }
            else{
                exact=false;
                break;
            }
        }

        // Exact first half is possible
        if(exact){
            String candidate=buildPalindrome(prefix,mid);

            if(candidate.compareTo(target)>0){
                return candidate;
            }

            // Need next permutation of the half
            char[] arr=prefix.toCharArray();

            int i=m-2;

            while(i>=0&&arr[i]>=arr[i+1]){
                i--;
            }

            if(i<0) return "";

            int j=m-1;

            while(arr[j]<=arr[i]){
                j--;
            }

            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

            int left=i+1,right=m-1;

            while(left<right){
                temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;

                left++;
                right--;
            }

            return buildPalindrome(new String(arr),mid);
        }

        /*
         * Prefix cannot be formed exactly.
         * Find the smallest permutation greater than prefix.
         */
        for(int pos=m-1;pos>=0;pos--){

            int[] remaining=new int[26];

            for(char ch:half.toCharArray()){
                remaining[ch-'a']++;
            }

            boolean possible=true;

            // Match positions before pos
            for(int i=0;i<pos;i++){
                char ch=prefix.charAt(i);

                if(remaining[ch-'a']==0){
                    possible=false;
                    break;
                }

                remaining[ch-'a']--;
            }

            if(!possible) continue;

            // Find smallest character greater than prefix[pos]
            for(int c=prefix.charAt(pos)-'a'+1;c<26;c++){
                if(remaining[c]>0){

                    StringBuilder result=new StringBuilder();

                    result.append(prefix.substring(0,pos));
                    result.append((char)('a'+c));

                    remaining[c]--;

                    // Fill the rest with smallest characters
                    for(int x=0;x<26;x++){
                        while(remaining[x]>0){
                            result.append((char)('a'+x));
                            remaining[x]--;
                        }
                    }

                    return buildPalindrome(result.toString(),mid);
                }
            }
        }

        return "";
    }
}