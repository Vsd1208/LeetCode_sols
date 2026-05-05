class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char ch = secret.charAt(i);
            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }
        boolean[] used = new boolean[guess.length()];
        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (map.containsKey(ch)) {
                List<Integer> l = map.get(ch);
                if (l.remove(Integer.valueOf(i))) {
                    bulls++;
                    used[i] = true; 
                }
                if (l.isEmpty()) map.remove(ch);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (used[i]) continue;
            char ch = guess.charAt(i);
            if (map.containsKey(ch)) {
                List<Integer> l = map.get(ch);
                if (!l.isEmpty()) {
                    l.remove(0);
                    cows++;
                }
                if (l.isEmpty()) map.remove(ch);
            }
        }
        return bulls + "A" + cows + "B";
    }
}