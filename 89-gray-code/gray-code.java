class Solution {

    private boolean backtrack(List<Integer> gray, Set<Integer> used, int n) {
        if (gray.size() == (1 << n)) {
            return true;
        }

        int last = gray.get(gray.size() - 1);

        for (int i = 0; i < n; i++) {
            int next = last ^ (1 << i); 

            if (!used.contains(next)) {
                used.add(next);
                gray.add(next);

                if (backtrack(gray, used, n)) return true;
                gray.remove(gray.size() - 1);
                used.remove(next);
            }
        }
        return false;
    }

    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<>();
        Set<Integer> used = new HashSet<>();

        gray.add(0);
        used.add(0);

        backtrack(gray, used, n);
        return gray;
    }
}