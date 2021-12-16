public class Grid {

    private final int[][] grid;

    public Grid(int rows, int columns) {
        this.grid = new int[rows][columns];
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setAliveCell(Cell cell) {
        grid[cell.row()][cell.column()] = 1;
    }

    public int countAliveNeighbors(Cell cell) {
        return checkLeftNeighbor(cell)
                + checkRightNeighbor(cell)
                + checkAboveNeighbor(cell)
                + checkBelowNeighbor(cell);
    }

    private int checkRightNeighbor(Cell cell) {
        if (isNotRightEdgeCell(cell)) {
            if (isRightNeighborAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkLeftNeighbor(Cell cell) {
        if (isNotLeftEdgeCell(cell)) {
            if (isLeftNeighborAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkBelowNeighbor(Cell cell) {
        if (isNotBottomRow(cell)) {
            if (isBelowNeighborAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkAboveNeighbor(Cell cell) {
        if (isNotTopRow(cell)) {
            if (isAboveNeighborAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private boolean isRightNeighborAlive(Cell cell) {
        return grid[cell.row()][cell.column() + 1] == 1;
    }

    private boolean isLeftNeighborAlive(Cell cell) {
        return grid[cell.row()][cell.column() - 1] == 1;
    }

    private boolean isBelowNeighborAlive(Cell cell) {
        return grid[cell.row() + 1][cell.column()] == 1;
    }

    private boolean isAboveNeighborAlive(Cell cell) {
        return grid[cell.row() - 1][cell.column()] == 1;
    }

    private boolean isNotRightEdgeCell(Cell cell) {
        return cell.column() < grid[0].length - 1;
    }

    private boolean isNotLeftEdgeCell(Cell cell) {
        return cell.column() > 0;
    }

    private boolean isNotBottomRow(Cell cell) {
        return cell.row() < grid.length - 1;
    }

    private boolean isNotTopRow(Cell cell) {
        return cell.row() > 0;
    }


}
