package core;

import core.Generator;
import core.Grid;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratorTest {
    Generator generator = new Generator();

    @Test
    void aliveCellWithFewerThanTwoLiveNeighborsIsSetDead() {
        Grid grid = new Grid(5, 5);
        Cell cell = new Cell(3, 3);

        grid.setAliveCell(cell);

        Grid newGeneration = generator.generateNextGeneration(grid);

        assertThat(newGeneration.getGrid()[3][3]).isZero();
    }

    @Test
    void aliveCellWithMoreThanThreeLiveNeighborsIsSetDead() {
        Grid grid = new Grid(5, 5);
        Cell cell = new Cell(3, 3);

        grid.setAliveCell(cell);
        grid.setAliveCell(new Cell(3,2));
        grid.setAliveCell(new Cell(3,4));
        grid.setAliveCell(new Cell(2,3));
        grid.setAliveCell(new Cell(4,3));

        Grid newGeneration = generator.generateNextGeneration(grid);

        assertThat(newGeneration.getGrid()[3][3]).isZero();
    }

    @Test
    void aliveCellWithTwoLiveNeighborsIsAlive() {
        Grid grid = new Grid(1, 5);
        Cell cell = new Cell(0, 3);

        grid.setAliveCell(cell);
        grid.setAliveCell(new Cell(0,2));
        grid.setAliveCell(new Cell(0,4));

        Grid newGeneration = generator.generateNextGeneration(grid);


        assertThat(newGeneration.getGrid()[0][3]).isOne();
    }

    @Test
    void aliveCellWithThreeLiveNeighborsIsAlive() {
        Grid grid = new Grid(2, 5);
        Cell cell = new Cell(0, 3);

        grid.setAliveCell(cell);
        grid.setAliveCell(new Cell(0,2));
        grid.setAliveCell(new Cell(0,4));
        grid.setAliveCell(new Cell(1,4));

        Grid newGeneration = generator.generateNextGeneration(grid);

        assertThat(newGeneration.getGrid()[0][3]).isOne();
    }
    @Test
    void deadCellWithThreeLiveNeighborsIsAlive() {
        Grid grid = new Grid(2, 5);

        grid.setAliveCell(new Cell(0,2));
        grid.setAliveCell(new Cell(0,4));
        grid.setAliveCell(new Cell(1,4));

        Grid newGeneration = generator.generateNextGeneration(grid);

        assertThat(newGeneration.getGrid()[0][3]).isOne();
    }

    @Test
    void deadCellWithMoreThanThreeLiveNeighborsIsDead() {
        Grid grid = new Grid(2, 5);

        grid.setAliveCell(new Cell(0,2));
        grid.setAliveCell(new Cell(0,4));
        grid.setAliveCell(new Cell(1,4));
        grid.setAliveCell(new Cell(1,3));

        Grid newGeneration = generator.generateNextGeneration(grid);

        assertThat(newGeneration.getGrid()[0][3]).isZero();
    }

}