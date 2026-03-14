class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char ch:s.toCharArray()){
            if(freq.containsKey(ch))
                freq.put(ch,freq.get(ch)+1);
            else
                freq.put(ch,1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq =
        new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(freq.entrySet());
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> e = pq.poll();
            for(int i=0;i<e.getValue();i++)
                str.append(e.getKey());
        }
        return str.toString();
    }
}