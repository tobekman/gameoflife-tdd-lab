public class Grid {

    private final int[][] grid;

    public Grid(int height, int width) {
        this.grid = new int[height][width];
    }

    public int[][] getGrid() {
        return grid;
    }
}
