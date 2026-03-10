class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> eat = new HashSet<>();
        for(int candy:candyType)
            eat.add(candy);
        if(eat.size() >= candyType.length/2) return candyType.length/2;
        else return eat.size();
    }
}