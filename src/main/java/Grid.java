public class Grid {

    private final int[][] grid;

    public Grid(int rows, int columns) {
        grid = new int[rows][columns];
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
                + checkUpperNeighbor(cell)
                + checkLowerNeighbor(cell)
                + checkUpperLeftNeighbor(cell)
                + checkUpperRightNeighbor(cell)
                + checkLowerLeftNeighbor(cell)
                + checkLowerRightNeighbor(cell);
    }

    private int checkRightNeighbor(Cell cell) {
        if (isNotRightEdgeCell(cell)) {
            if (rightNeighborIsAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkLeftNeighbor(Cell cell) {
        if (isNotLeftEdgeCell(cell)) {
            if (leftNeighborIsAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkLowerNeighbor(Cell cell) {
        if (isNotBottomRow(cell)) {
            if (lowerNeighborIsAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkUpperNeighbor(Cell cell) {
        if (isNotTopRow(cell)) {
            if (upperNeighborIsAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkUpperLeftNeighbor(Cell cell) {
        if(isNotLeftEdgeCell(cell) && isNotTopRow(cell)) {
            if(upperLeftNeighborIsAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkUpperRightNeighbor(Cell cell) {
        if(isNotRightEdgeCell(cell) && isNotTopRow(cell)) {
            if(upperRightNeighborIsAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }
    private int checkLowerLeftNeighbor(Cell cell) {
        if(isNotLeftEdgeCell(cell) && isNotBottomRow(cell)) {
            if(lowerLeftNeighborIsAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkLowerRightNeighbor(Cell cell) {
        if(isNotRightEdgeCell(cell) && isNotBottomRow(cell)) {
            if(lowerRightNeighborIsAlive(cell)) {
                return 1;
            }
        }
        return 0;
    }

    private boolean rightNeighborIsAlive(Cell cell) {
        return grid[cell.row()][cell.column() + 1] == 1;
    }

    private boolean leftNeighborIsAlive(Cell cell) {
        return grid[cell.row()][cell.column() - 1] == 1;
    }

    private boolean lowerNeighborIsAlive(Cell cell) {
        return grid[cell.row() + 1][cell.column()] == 1;
    }

    private boolean upperNeighborIsAlive(Cell cell) {
        return grid[cell.row() - 1][cell.column()] == 1;
    }

    private boolean upperLeftNeighborIsAlive(Cell cell) {
        return grid[cell.row() - 1][cell.column() - 1] == 1;
    }

    private boolean upperRightNeighborIsAlive(Cell cell) {
        return grid[cell.row() - 1][cell.column() + 1] == 1;
    }

    private boolean lowerLeftNeighborIsAlive(Cell cell) {
        return grid[cell.row() + 1][cell.column() - 1] == 1;
    }

    private boolean lowerRightNeighborIsAlive(Cell cell) {
        return grid[cell.row() + 1][cell.column() + 1] == 1;
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


    public void generateNextGeneration() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (countAliveNeighbors(new Cell(i, j)) < 2) {
                    grid[i][j] = 0;
                }
            }
        }
    }
}
