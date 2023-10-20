class Solution {
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0 && isValidIsland(grid, i, j, r, c)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private boolean isValidIsland(int[][] grid, int i, int j, int r, int c) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        boolean valid = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (node[0] == 0 || node[0] == r - 1 || node[1] == 0 || node[1] == c - 1) {
                valid = false;
            }
            grid[node[0]][node[1]] = -1;
            for (int k = 0; k < 4; k++) {
                int x = node[0] + dx[k];
                int y = node[1] + dy[k];
                if (x >= 0 && x < r && y >= 0 && y < c && grid[x][y] == 0) {
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return valid;
    }
}