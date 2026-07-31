class Solution {
    class Node{
        char ch;
        int freq;
        Node(char ch){
            this.ch=ch;
            freq=0;
        }
    }
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++)
            freq[word.charAt(i)-'a']++;
        Node[] f = new Node[26];
        int i=0;
        for(i=0;i<26;i++){
            f[i]=new Node((char)('a'+i));
            f[i].freq=freq[i];
        }
        Arrays.sort(f,(a,b)->b.freq-a.freq);
        int index=0;
        int click=1;
        HashMap<Integer,HashSet<Character>> map = new HashMap<>();
        for(i=1;i<=4;i++) map.put(i,new HashSet<>());
        for(i=0;i<26;i++){
            if(f[i].freq==0) continue;
            map.get(click).add(f[i].ch);
            index++;
            if(index==8){
                index=0;
                click++;
            }
        }
        int count=0;
        for(i=1;i<=4;i++){
            for(char ch:map.get(i)){
                count+=(i * freq[ch-'a']);
            }
        }
        return count;
    }
}