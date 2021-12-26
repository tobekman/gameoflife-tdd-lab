public class Generator {

    public Grid generateNextGeneration(Grid grid) {
        int gridRows = grid.getGrid().length;
        int gridColumns = grid.getGrid()[0].length;
        Grid newGeneration = new Grid(gridRows, gridColumns);

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridColumns; j++) {
                if (isAlive(grid, i, j)) {
                    if (hasTwoLiveNeighbors(grid, i, j) || hasThreeLiveNeighbors(grid, i, j)) {
                        newGeneration.getGrid()[i][j] = 1;
                    }
                }
                if (hasThreeLiveNeighbors(grid, i, j)) {
                    newGeneration.getGrid()[i][j] = 1;
                }
            }
        }
        return newGeneration;
    }

    private boolean isAlive(Grid grid, int i, int j) {
        return grid.getGrid()[i][j] == 1;
    }

    private boolean hasThreeLiveNeighbors(Grid grid, int i, int j) {
        return grid.countAliveNeighbors(new Cell(i, j)) == 3;
    }

    private boolean hasTwoLiveNeighbors(Grid grid, int i, int j) {
        return grid.countAliveNeighbors(new Cell(i, j)) == 2;
    }

}
