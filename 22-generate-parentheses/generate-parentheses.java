class Solution {
    private void backtrack(List<String> par,String curr,int open,int close,int n){
        if(curr.length()==2*n){
            par.add(curr);
            return;
        }
        if(open<n){
            backtrack(par,curr+"(",open+1,close,n);
        }
        if(close<open){
            backtrack(par,curr+")",open,close+1,n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> par = new ArrayList<>();
        backtrack(par,"",0,0,n);
        return par;
    }
}