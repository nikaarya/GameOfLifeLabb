

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameOfLifeTest {

   @Test
    public void LiveCellLessThanTwoLiveNeighborsDies() {
        GameOfLife.CellState currentState = GameOfLife.CellState.isAlive;
        int aliveNeighbors = 1;

        GameOfLife.CellState result = GameOfLife.GameRules.NewCellState(currentState, aliveNeighbors);
        assertEquals(GameOfLife.CellState.isDead, result);
    }
    @Test
    public void LiveCellTwoOrThreeLiveNeighborsLives() {
        GameOfLife.CellState currentState = GameOfLife.CellState.isAlive;
        int aliveNeighbors = 3;

        GameOfLife.CellState result = GameOfLife.GameRules.NewCellState(currentState, aliveNeighbors);
        assertEquals(GameOfLife.CellState.isAlive, result);
    }
    @Test
    public void LiveCellMoreThanThreeNeighborsDies() {
        GameOfLife.CellState currentState = GameOfLife.CellState.isAlive;
        int aliveNeighbors = 4;

        GameOfLife.CellState result = GameOfLife.GameRules.NewCellState(currentState, aliveNeighbors);
        assertEquals(GameOfLife.CellState.isDead, result);
    }
    @Test
    public void DeadCellWithExactlyThreeLiveNeighborsLives() {
        GameOfLife.CellState currentState = GameOfLife.CellState.isDead;
        int aliveNeighbors = 3;

        GameOfLife.CellState result = GameOfLife.GameRules.NewCellState(currentState, aliveNeighbors);
        assertEquals(GameOfLife.CellState.isAlive, result);
    }
}
