class Solution {
    private boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            map.put(words[i], i);
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(int j = 0; j <= word.length(); j++){
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);
                if(isPalindrome(prefix)){
                    String rev = new StringBuilder(suffix).reverse().toString();
                    if(map.containsKey(rev) && map.get(rev) != i){
                        res.add(Arrays.asList(map.get(rev), i));
                    }
                }
                if(suffix.length() != 0 && isPalindrome(suffix)){
                    String rev = new StringBuilder(prefix).reverse().toString();
                    if(map.containsKey(rev) && map.get(rev) != i){
                        res.add(Arrays.asList(i, map.get(rev)));
                    }
                }
            }
        }
        return res;
    }
}