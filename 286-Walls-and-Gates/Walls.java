public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) {
                    // visit four neighbours
                    dfs(rooms, i - 1, j, 1);
                    dfs(rooms, i, j - 1, 1);
                    dfs(rooms, i + 1, j, 1);
                    dfs(rooms, i, j + 1, 1);
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int i, int j, int dis) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) {
            return;
        }
        if (rooms[i][j] == -1 || rooms[i][j] == 0) {
            return;
        }
        
        if (rooms[i][j] <= dis) {
            return;
        }
        else {
            rooms[i][j] = dis;
        }
        // visit four neighbours
        dfs(rooms, i - 1, j, dis + 1);
        dfs(rooms, i, j - 1, dis + 1);
        dfs(rooms, i + 1, j, dis + 1);
        dfs(rooms, i, j + 1, dis + 1);
    }
}