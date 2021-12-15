public class Grid {

    private final int[][] completeGrid;

    public Grid(int height, int width) {
        this.completeGrid = new int[height][width];
    }

    public int[][] getCompleteGrid() {
        return completeGrid;
    }
}
