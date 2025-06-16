import java.util.LinkedList;
import java.util.Queue;

public class StepsbyKnight {

    static boolean isInside(int x ,int y ,int n){
        return x>=1 && x<=n && y>=1 && y<=n;
    }

    static int minStepsToReach(int[] knightPos, int[] targetPos, int n){
        int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {  -1, -2, -2, -1, 1, 2, 2, 1 };

        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(knightPos[0],knightPos[1],0));

        boolean[][] visit = new boolean[n + 1][n + 1];
        visit[knightPos[0]][knightPos[1]] = true;
        Cell t;
        int x, y;
        while (!q.isEmpty()) {
            t = q.poll();
            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.dis;

            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];
                if (isInside(x, y, n) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new Cell(x, y, t.dis + 1));
                }
            }
        }
        return -1;
    } // Time Complexity: O(N²), Space Complexity: O(N²)
    public static void main(String[] args) {
        int n = 30;
        int[] knightPos = { 1, 1 };
        int[] targetPos = { 30, 30 };
        System.out.println(minStepsToReach(knightPos, targetPos, n));
    }
}

class Cell{
    int x,y,dis;

    public Cell(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
