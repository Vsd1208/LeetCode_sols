class AuthenticationManager {
    HashMap<String,Integer> auth;
    int time;
    public AuthenticationManager(int timeToLive) {
        auth = new HashMap<>();
        time=timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        auth.put(tokenId,currentTime+time);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(auth.containsKey(tokenId) && auth.get(tokenId) > currentTime)
            auth.put(tokenId,currentTime+time);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(Integer values : auth.values()){
            if(values>currentTime) count++;
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */