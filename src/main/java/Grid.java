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
}
