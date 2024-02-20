package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() { return this.x; }
        int getY() { return this.y; }
    }

    public int numIslands(char[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int result = 0;
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        boolean[][] visited = new boolean[rowCount][columnCount];
        int[][] possibles = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < columnCount; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                    result++;
                }
                while(!queue.isEmpty()) {
                    Pair pair = queue.remove();
                    for(int[] possible: possibles) {
                        if(pair.x+possible[0] >=0 
                            && pair.x+possible[0] < rowCount 
                            && pair.y+possible[1] >= 0 
                            && pair.y+possible[1]< columnCount 
                            && !visited[pair.x+possible[0]][pair.y+possible[1]] 
                            && grid[pair.x+possible[0]][pair.y+possible[1]] == '1'
                        ) {
                            queue.add(new Pair(pair.x+possible[0], pair.y+possible[1]));
                            visited[pair.x+possible[0]][pair.y+possible[1]] = true;
                        }
                    }
                }
            }
        }
        return result;
    }

    public int numIslandsWithRecurssion(char[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length;i++) {
            for(int j = 0; j < grid[0].length;j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, char[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }

    public static void main(String... args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslandsWithRecurssion(new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
