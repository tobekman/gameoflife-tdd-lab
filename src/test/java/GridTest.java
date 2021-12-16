import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GridTest {

    @Test
    void givenHeightAndWidthParametersCorrectGridIsCreated() {
        Grid grid = new Grid(4, 8);
        int[][] expected = new int[4][8];
        int[][] actual = grid.getGrid();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenPositionSetCellValueTo1() {
        Grid grid = new Grid(4, 8);

        grid.setAliveCell(1, 5);

        assertThat(grid.getGrid()[1][5]).isEqualTo(1);
    }

    @Test
    void checkForAliveNeighborsInRowReturnsCorrectNeighborCount() {
        Grid grid = new Grid(1, 10);

        grid.setAliveCell(0, 3);
        grid.setAliveCell(0, 5);
        int count = grid.countAliveNeighbors(0, 4);

        assertThat(count).isEqualTo(2);
    }

    @Test
    void checkEdgeOnRowCellNoErrorAndReturnCorrectCount() {
        Grid grid = new Grid(1, 3);

        grid.setAliveCell(0, 0);
        grid.setAliveCell(0, 1);
        grid.setAliveCell(0, 2);

        int leftEdge = grid.countAliveNeighbors(0, 0);
        int middle = grid.countAliveNeighbors(0, 1);
        int rightEdge = grid.countAliveNeighbors(0, 2);

        assertThat(leftEdge).isEqualTo(1);
        assertThat(middle).isEqualTo(2);
        assertThat(rightEdge).isEqualTo(1);
    }

    @Test
    void checkForAliveNeighborsInColumnReturnsCorrectNeighborCount() {
        Grid grid = new Grid(8, 5);

        grid.setAliveCell(4, 3);
        grid.setAliveCell(6, 3);
        int count = grid.countAliveNeighbors(5, 3);

        assertThat(count).isEqualTo(2);
    }

}
