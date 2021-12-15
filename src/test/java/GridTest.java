import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GridTest {

    @Test
    void gridIsCreated() {
        Grid grid = new Grid(4, 8);
        int[][] expected = new int[4][8];
        int[][] actual = grid.getCompleteGrid();

        assertThat(actual).isEqualTo(expected);
    }

}
