import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class QueensProblemTest {

    @Test
    public void testIsSafeRook() {
        List<Position> positions = Arrays.asList(new Position(0,0), new Position(2,1), new Position(3,2));
        assertFalse(QueensProblem.isSafeRook(positions, new Position(0,0))); // Position already occupied
        assertFalse(QueensProblem.isSafeRook(positions, new Position(0,3))); // Threatened on row
        assertFalse(QueensProblem.isSafeRook(positions, new Position(1,0))); // Threatened on column
        assertFalse(QueensProblem.isSafeRook(positions, new Position(0,1))); // Threatened on row and column
        assertTrue(QueensProblem.isSafeRook(positions, new Position(1,3)));  // Safe position
    }

    @Test
    public void testIsSafeQueen() {
        List<Position> positions = Arrays.asList(new Position(0,1), new Position(3,2));
        assertFalse(QueensProblem.isSafeQueen(positions, new Position(0,1))); // Position already occupied
        assertFalse(QueensProblem.isSafeQueen(positions, new Position(0,3))); // Threatened on row
        assertFalse(QueensProblem.isSafeQueen(positions, new Position(2,2))); // Threatened on column
        assertFalse(QueensProblem.isSafeQueen(positions, new Position(1,0))); // Threatened on diagonal
        assertTrue(QueensProblem.isSafeQueen(positions, new Position(2,0)));  // Safe position
    }

    @Test
    public void testGetQueensProblemSolution() {
        assertTrue(QueensProblem.getQueensProblemSolution(3).isEmpty()); // Board size less than 4, should return empty list

        List<Position> solution = QueensProblem.getQueensProblemSolution(4);
        assertNotNull(solution);
        assertEquals(4, solution.size()); // Should place 4 queens
        // Check if all queens are placed safely, not part of this example but should involve iterating through the solution list and verifying no two queens threaten each other
    }
}
