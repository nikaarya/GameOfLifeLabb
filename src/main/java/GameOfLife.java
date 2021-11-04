public class GameOfLife {
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
}
