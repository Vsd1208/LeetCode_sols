//My first Wrong attempt 
// class Solution {
//     private void bfs(int[][] board,int curr,boolean reached,int count){
//         if(reached) return;
//         int n=board.length;
//         for(int k=curr+1;k<Math.min(curr+6,n*n-1);k++){
//             if(k>=n*n) return;
//             if(k==n*n-1) reached=true;
//             int row = k/n;
//             int col = k%n;
//             if(col>3) col-=3;
//             else col+=3;
//             k=board[row][col];
//             count+=1;
//             bfs(board,k,reached,count);
//         }
//     }
//     public int snakesAndLadders(int[][] board) {
//         int count=0;
//         boolean reached=false;
//         bfs(board,1,reached,count);
//         return count;
//     }
// }
import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        int moves = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int curr = q.poll();

                if(curr == n * n) return moves;

                for(int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if(next > n * n) continue;

                    int[] pos = getPosition(next, n);
                    int r = pos[0], c = pos[1];

                    if(board[r][c] != -1) {
                        next = board[r][c];
                    }

                    if(!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private int[] getPosition(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;

        if(r % 2 == 1) {
            c = n - 1 - c;
        }

        return new int[]{n - 1 - r, c};
    }
}