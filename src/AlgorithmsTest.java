import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import static org.junit.Assert.*;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class AlgorithmsTest {

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    private static final int N = 10000;
    private final int[] data = generateArray(N);

    @Test
    public void testDuplicatesLogic() {
        int[] withDuplicates = {1, 5, 2, 8, 5};
        int[] noDuplicates = {1, 2, 3, 4, 5};

        assertTrue(Algorithms.hasDuplicateNaive(withDuplicates));
        assertFalse(Algorithms.hasDuplicateNaive(noDuplicates));

        assertTrue(Algorithms.hasDuplicateFast(withDuplicates, 10));
        assertFalse(Algorithms.hasDuplicateFast(noDuplicates, 10));

        assertTrue(Algorithms.hasDuplicateBalanced(withDuplicates));
        assertFalse(Algorithms.hasDuplicateBalanced(noDuplicates));
    }

    @Test
    public void testHashingLogic() {
        int M = 997;
        int hash1 = Algorithms.calculateHash("кіт", M);
        int hash2 = Algorithms.calculateHash("тік", M);
        assertNotEquals(hash1, hash2);
    }


    @Test
    @BenchmarkOptions(benchmarkRounds = 5, warmupRounds = 2)
    public void benchmarkNaive() {
        Algorithms.hasDuplicateNaive(data);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 5, warmupRounds = 2)
    public void benchmarkFast() {
        Algorithms.hasDuplicateFast(data, N);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 5, warmupRounds = 2)
    public void benchmarkBalanced() {
        Algorithms.hasDuplicateBalanced(data);
    }

    private int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        return arr;
    }
}