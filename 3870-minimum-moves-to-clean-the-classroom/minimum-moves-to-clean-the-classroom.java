class Solution {

    private class State {
        int r,c,energy,mask,dist;

        State(int r,int c,int energy,int mask,int dist){
            this.r=r;
            this.c=c;
            this.energy=energy;
            this.mask=mask;
            this.dist=dist;
        }
    }

    public int minMoves(String[] classroom,int energy) {
        int m=classroom.length;
        int n=classroom[0].length();

        int sr=0,sc=0;
        int litterCount=0;

        int[][] litter=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char ch=classroom[i].charAt(j);

                if(ch=='S'){
                    sr=i;
                    sc=j;
                }

                if(ch=='L'){
                    litter[i][j]=litterCount++;
                }
            }
        }

        int totalMask=(1<<litterCount)-1;

        boolean[][][][] visited=
            new boolean[m][n][energy+1][1<<litterCount];

        Queue<State> q=new ArrayDeque<>();

        q.add(new State(sr,sc,energy,0,0));
        visited[sr][sc][energy][0]=true;

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        while(!q.isEmpty()){
            State curr=q.poll();

            if(curr.mask==totalMask){
                return curr.dist;
            }

            for(int d=0;d<4;d++){
                int nr=curr.r+dr[d];
                int nc=curr.c+dc[d];

                if(nr<0||nr>=m||nc<0||nc>=n) continue;
                if(classroom[nr].charAt(nc)=='X') continue;

                if(curr.energy==0) continue;

                int newEnergy=curr.energy-1;
                int newMask=curr.mask;

                char ch=classroom[nr].charAt(nc);

                if(ch=='L'){
                    newMask|=(1<<litter[nr][nc]);
                }

                if(ch=='R'){
                    newEnergy=energy;
                }

                if(!visited[nr][nc][newEnergy][newMask]){
                    visited[nr][nc][newEnergy][newMask]=true;

                    q.add(new State(
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        curr.dist+1
                    ));
                }
            }
        }

        return -1;
    }
}