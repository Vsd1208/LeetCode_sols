class Solution {
    class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Node)) return false;
            Node n = (Node) o;
            return x == n.x && y == n.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int dir = 0; // 0=N, 1=E, 2=S, 3=W
        HashSet<Node> set = new HashSet<>();
        for(int i = 0; i < obstacles.length; i++){
            set.add(new Node(obstacles[i][0], obstacles[i][1]));
        }
        int maxDist = 0;
        for(int i = 0; i < commands.length; i++){
            if(commands[i] == -1){
                dir = (dir + 1) % 4; // turn right
            }
            else if(commands[i] == -2){
                dir = (dir + 3) % 4; // turn left
            }
            else {
                for(int step = 0; step < commands[i]; step++){
                    int nx = x, ny = y;

                    if(dir == 0) ny++;
                    else if(dir == 1) nx++;
                    else if(dir == 2) ny--;
                    else nx--;
                    if(set.contains(new Node(nx, ny))) break;
                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }
        return maxDist;
    }
}