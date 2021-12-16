public class Grid {

    private final int[][] grid;

    public Grid(int height, int width) {
        this.grid = new int[height][width];
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setAliveCell(int y, int x) {
        grid[y][x] = 1;
    }

    public int countAliveNeighbors(int y, int x) {
        int count = 0;

        if(grid[y][x - 1] == 1) {
            count++;
        }
        if(grid[y][x + 1] == 1) {
            count++;
        }

        return count;
    }
}
