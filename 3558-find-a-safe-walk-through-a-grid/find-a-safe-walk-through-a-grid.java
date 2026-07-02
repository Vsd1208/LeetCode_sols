// class Solution {
//     private void bfs(List<List<Integer>> grid,int m,int n,int r,int c,int health,boolean check){
//         if(r>m-1|| c>n-1 || r<0 || c<0 || health<1) return;
//         if(grid.get(r).get(c)==1) health--;
//         if((r==m-1 && c==n-1) && health>0) check=true;
//         bfs(grid,m,n,r-1,c,health,check);
//         bfs(grid,m,n,r+1,c,health,check);
//         bfs(grid,m,n,r,c-1,health,check);
//         bfs(grid,m,n,r,c+1,health,check);
//     }
//     public boolean findSafeWalk(List<List<Integer>> grid, int health) {
//         boolean check=false;
//         int m=grid.size(),n=grid.get(0).size();
//         bfs(grid,m,n,0,0,health,check);
//         return check;
//     }
// }
import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = grid.get(0).get(0);
        dq.offerFirst(new int[]{0, 0});
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0];
            int c = cur[1];
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;
                int cost = grid.get(nr).get(nc);
                if (dist[r][c] + cost < dist[nr][nc]) {
                    dist[nr][nc] = dist[r][c] + cost;
                    if (cost == 0)
                        dq.offerFirst(new int[]{nr, nc});
                    else
                        dq.offerLast(new int[]{nr, nc});
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}