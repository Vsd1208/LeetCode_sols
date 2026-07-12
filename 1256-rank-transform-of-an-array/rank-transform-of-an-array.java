class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int[] copy = arr.clone();
        int[] ans = new int[arr.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(copy);

        int rank = 1;

        for (int i = 0; i < copy.length; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}