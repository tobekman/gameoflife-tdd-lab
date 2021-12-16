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

        if(x > 0){
            if(isLeftNeighborAlive(y, x)) {
                count++;
            }
        }
        if(x < grid[0].length - 1){
            if(isRightNeighborAlive(y, x)) {
                count++;
            }
        }

        return count;
    }

    private boolean isRightNeighborAlive(int y, int x) {
        return grid[y][x + 1] == 1;
    }

    private boolean isLeftNeighborAlive(int y, int x) {
        return grid[y][x - 1] == 1;
    }
}
