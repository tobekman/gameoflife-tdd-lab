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

}
