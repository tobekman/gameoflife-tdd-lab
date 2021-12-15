public class Grid {

    private int height;
    private int width;
    private int completeGrid[][];

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        this.completeGrid = new int[height][width];
    }

    public int[][] getCompleteGrid() {
        return completeGrid;
    }
}
