class Solution {
    class Node{
        char ch;
        int f;
        Node(char ch){
            this.ch = ch;
            f=0;
        }
    }
    public int minimumPushes(String word) {
        Node[] freq = new Node[26];
        for(int i=0;i<26;i++) freq[i] = new Node((char)('a' + i));
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            freq[ch-'a'].f++;
        }
        Arrays.sort(freq,(a,b)->a.f - b.f);
        int count=1,used=0;
        HashMap<Integer,HashSet<Character>> clicks = new HashMap<>();
        for (int i = 1; i <= 4; i++)
            clicks.put(i, new HashSet<>());
        for (int i = 25; i >= 0; i--) {
            if (freq[i].f == 0)
                continue;
            clicks.get(count).add(freq[i].ch);
            used++;
            if (used == 8) {
                used = 0;
                count++;
            }
        }
        count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            for (int j = 1; j <= 4; j++) {
                if (clicks.get(j).contains(ch)) {
                    count += j;
                    break;
                }
            }
        }
        return count;
    }
}