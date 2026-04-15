class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(words[i].equals(target)){
                int diff = Math.abs(i - startIndex);
                int dist = Math.min(diff, n - diff);
                min = Math.min(min, dist);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}