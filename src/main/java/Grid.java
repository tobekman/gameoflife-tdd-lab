public class Grid {

    private final int[][] grid;

    public Grid(int rows, int columns) {
        this.grid = new int[rows][columns];
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setAliveCell(int row, int column) {
        grid[row][column] = 1;
    }

    public int countAliveNeighbors(int row, int column) {
        int count = 0;

        if(isNotLeftEdgeCell(column)){
            if(isLeftNeighborAlive(row, column)) {
                count++;
            }
        }
        if(isNotRightEdgeCell(column)){
            if(isRightNeighborAlive(row, column)) {
                count++;
            }
        }
        if(row > 0) {
            if(grid[row - 1][column] == 1) {
                count++;
            }
        }
        if(row < grid.length - 1) {
            if(grid[row + 1][column] == 1) {
                count++;
            }
        }

        return count;
    }

    private boolean isNotRightEdgeCell(int column) {
        return column < grid[0].length - 1;
    }

    private boolean isNotLeftEdgeCell(int column) {
        return column > 0;
    }

    private boolean isRightNeighborAlive(int row, int column) {
        return grid[row][column + 1] == 1;
    }

    private boolean isLeftNeighborAlive(int row, int column) {
        return grid[row][column - 1] == 1;
    }
}
