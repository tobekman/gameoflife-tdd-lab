package core;

public class Grid {

    private final int[][] grid;
    private final int rows;
    private final int columns;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new int[rows][columns];
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setAliveCell(Cell cell) {
        grid[cell.row()][cell.column()] = 1;
    }

    public int countAliveNeighbors(Cell cell) {
        int row = cell.row();
        int column = cell.column();

        return checkAliveCell(row - 1, column - 1)
                + checkAliveCell(row - 1, column)
                + checkAliveCell(row - 1, column + 1)
                + checkAliveCell(row, column - 1)
                + checkAliveCell(row, column + 1)
                + checkAliveCell(row + 1, column - 1)
                + checkAliveCell(row + 1, column)
                + checkAliveCell(row + 1, column + 1);
    }

    private int checkAliveCell(int row, int column) {
        if (row < 0 || row >= rows) {
            return 0;
        }
        if (column < 0 || column >= columns) {
            return 0;
        }
        return grid[row][column];
    }

}
