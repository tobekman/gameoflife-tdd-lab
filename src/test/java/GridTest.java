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

}
