class Solution {
    class Node{
        int scores;
        int index;
    }
    public String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];
        Node[] in_score = new Node[score.length];
        PriorityQueue<Node> ranking = new PriorityQueue<>((a,b) -> b.scores - a.scores);
        for(int i=0;i<score.length;i++){
            in_score[i] = new Node();
            in_score[i].scores = score[i];
            in_score[i].index = i;
            ranking.add(in_score[i]);
        }
        for(int i=1;i<=score.length;i++){
            int q = ranking.poll().index;
            if(i<4){
                if(i==1){
                    ranks[q]="Gold Medal";
                }
                else if(i==2) ranks[q]="Silver Medal";
                else ranks[q]="Bronze Medal";
            }
            else{
                ranks[q]=""+i;
            }
        }
        return ranks;
    }
}