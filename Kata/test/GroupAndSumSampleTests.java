import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class GroupAndSumSampleTests {

    @Test
    void sampleTests() {

        final int[][] data1 = { {1, 2, 3}, {1, 5, 6}, {1, 8, 9} };
        final int[] indices1 = {0};
        final Map<List<Integer>, List<Integer>> expected1 = Map.of(List.of(1), List.of(15, 18));
        assertEquals(expected1, GroupAndSum.groupAndSum(data1, indices1));

        final int[][] data2 = { {1, 1, 1}, {1, 2, 1}, {1, 3, 1} };
        final int[] indices2 = {0, 2};
        final Map<List<Integer>, List<Integer>> expected2 = Map.of(List.of(1, 1), List.of(6));
        assertEquals(expected2, GroupAndSum.groupAndSum(data2, indices2));

        final int[][] data3 = { {1, 2, 3}, {4, 5, 6}, {6, 7, 8} };
        final int[] indices3 = {0, 1, 2};
        final Map<List<Integer>, List<Integer>> expected3 = Map.of(
                List.of(1, 2, 3), List.of(),
                List.of(4, 5, 6), List.of(),
                List.of(6, 7, 8), List.of()
        );
        assertEquals(expected3, GroupAndSum.groupAndSum(data3, indices3));
    }
}
