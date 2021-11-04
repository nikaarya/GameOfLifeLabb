

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameOfLifeTest {
    public enum CellState {
        isAlive,
        isDead,
    }
    public class GameRules {
        public static CellState NewCellState(CellState currentState, int aliveNeighbors) {

            if (currentState == CellState.isAlive && aliveNeighbors < 2) {
                return CellState.isDead;
            }
            if (currentState == CellState.isAlive && aliveNeighbors > 3) {
                return CellState.isDead;
            }
            if (currentState == CellState.isDead && aliveNeighbors == 3) {
                return CellState.isAlive;
            }
            return currentState;
        }
    }
   @Test
    public void LiveCellLessThanTwoLiveNeighborsDies() {
        CellState currentState = CellState.isAlive;
        int aliveNeighbors = 1;

        CellState result = GameRules.NewCellState(currentState, aliveNeighbors);
        assertEquals(CellState.isDead, result);
    }
    @Test
    public void LiveCellTwoOrThreeLiveNeighborsLives() {
        CellState currentState = CellState.isAlive;
        int aliveNeighbors = 3;

        CellState result = GameRules.NewCellState(currentState, aliveNeighbors);
        assertEquals(CellState.isAlive, result);
    }
    @Test
    public void LiveCellMoreThanThreeNeighborsDies() {
        CellState currentState = CellState.isAlive;
        int aliveNeighbors = 4;

        CellState result = GameRules.NewCellState(currentState, aliveNeighbors);
        assertEquals(CellState.isDead, result);
    }
    @Test
    public void DeadCellWithExactlyThreeLiveNeighborsLives() {
        CellState currentState = CellState.isDead;
        int aliveNeighbors = 3;

        CellState result = GameRules.NewCellState(currentState, aliveNeighbors);
        assertEquals(CellState.isAlive, result);
    }
}
