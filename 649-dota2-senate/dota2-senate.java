class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        // Queue for Radiant senators (store their positions)
        Queue<Integer> rQueue = new LinkedList<>();

        // Queue for Dire senators (store their positions)
        Queue<Integer> dQueue = new LinkedList<>();


        // Step 1: Put indices of senators into respective queues
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R')
                rQueue.offer(i);
            else
                dQueue.offer(i);
        }


        // Step 2: Simulate the banning process
        while(!rQueue.isEmpty() && !dQueue.isEmpty()){

            // Get the next acting senators
            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();

            // The senator with smaller index acts first
            if(rIndex < dIndex){

                // Radiant bans Dire
                // Radiant survives and returns in next round
                rQueue.offer(rIndex + n);

            } else {

                // Dire bans Radiant
                // Dire survives and returns in next round
                dQueue.offer(dIndex + n);
            }
        }


        // Step 3: If Radiant queue still has members → Radiant wins
        if(!rQueue.isEmpty())
            return "Radiant";
        else
            return "Dire";
    }
}