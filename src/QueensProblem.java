import java.util.ArrayList;
import java.util.List;

public class QueensProblem {
    public static boolean isSafeRook(List<Position> positions, Position rook) {
        for (Position pos : positions) {
            if (pos.rowIndex() == rook.rowIndex() || pos.columnIndex() == rook.columnIndex()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSafeQueen(List<Position> positions, Position queen) {
        for (Position pos : positions) {
            if (pos.rowIndex() == queen.rowIndex() || pos.columnIndex() == queen.columnIndex() ||
                    pos.leftDiagonal() == queen.leftDiagonal() || pos.rightDiagonal() == queen.rightDiagonal()) {
                return false;
            }
        }
        return true;
    }

    public static List<Position> getQueensProblemSolution(int boardSize) {
        if (boardSize < 4) return new ArrayList<>();

        List<Position> solution = new ArrayList<>();
        solveNQueens(solution, boardSize, 0);
        return solution;
    }

    private static boolean solveNQueens(List<Position> solution, int boardSize, int row) {
        if (row == boardSize) {
            return true;
        }

        for (int col = 0; col < boardSize; col++) {
            Position newPos = new Position(row, col);
            if (isSafeQueen(solution, newPos)) {
                solution.add(newPos);
                if (solveNQueens(solution, boardSize, row + 1)) {
                    return true;
                }
                solution.remove(solution.size() - 1);
            }
        }

        return false;
    }
}
