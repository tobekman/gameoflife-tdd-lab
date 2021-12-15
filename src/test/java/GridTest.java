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

}
