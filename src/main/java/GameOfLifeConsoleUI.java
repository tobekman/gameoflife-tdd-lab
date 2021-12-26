public class GameOfLifeConsoleUI {

    Grid grid;
    Generator generator = new Generator();

    public void displayGrid(Grid grid) {
        StringBuilder gridLines = new StringBuilder();
        for (int i = 0; i < grid.getRows(); i++) {
            gridLines.append("\n");
            for (int j = 0; j < grid.getColumns(); j++) {
                if (grid.getGrid()[i][j] == 0) {
                    gridLines.append(".");
                } else {
                    gridLines.append("*");
                }
            }
        }
        gridLines.append("\n");
        System.out.println(gridLines);
    }

    public void manageStartMenu() {
        displayStartMenu();
        startMenuChoice();
        while (true) {
            manageGridMenu();
        }
    }

    private void displayStartMenu() {
        System.out.println("-- Game of Life --");
        System.out.println("[1] Create new grid");
        System.out.println("[0] Exit");
    }

    private void startMenuChoice() {
        if (MyScanner.intScanner() == 1) {
            System.out.println("-- Create new grid --");
            System.out.println("Provide size");
            createNewGrid();
        } else {
            System.exit(0);
        }
    }

    private void createNewGrid() {
        System.out.print("Rows: ");
        int rows = MyScanner.intScanner();
        System.out.print("Columns: ");
        int columns = MyScanner.intScanner();
        grid = new Grid(rows, columns);
    }

    private void manageGridMenu() {
        displayGridMenu();
        gridMenuChoice();
    }

    private void gridMenuChoice() {
        switch (MyScanner.intScanner()) {
            case 1 -> setAliveCellMenu();
            case 2 -> displayGrid(grid);
            case 3 -> nextGeneration();
            default -> manageStartMenu();
        }
    }

    private void displayGridMenu() {
        System.out.println("\n--- Manage grid ---");
        System.out.println("[1] Set alive cell");
        System.out.println("[2] Display grid");
        System.out.println("[3] Generate next generation");
        System.out.println("[0] Back to start menu");
    }

    private void setAliveCellMenu() {
        Cell cell = createCell();
        if (rowIsOutOfBounds(cell) || columnIsOutOfBounds(cell)) {
            System.out.println("Position is out of bounds of current grid");
            manageGridMenu();
        } else {
            grid.setAliveCell(cell);
        }
    }

    private boolean columnIsOutOfBounds(Cell cell) {
        return cell.column() >= grid.getColumns();
    }

    private boolean rowIsOutOfBounds(Cell cell) {
        return cell.row() >= grid.getRows();
    }

    private Cell createCell() {
        System.out.println("Position");
        System.out.print("Row: ");
        int row = MyScanner.intScanner() - 1;
        System.out.print("Column: ");
        int column = MyScanner.intScanner() - 1;
        return new Cell(row, column);
    }

    private void nextGeneration() {
        System.out.println("--- Current generation ---");
        displayGrid(grid);
        grid = generator.generateNextGeneration(grid);
        System.out.println("--- Next generation ---");
        displayGrid(grid);
    }

}
