import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by clemenspfister on 12/05/2017.
 */
public class FibonacciTest {

    @Test
    public void testFibonacci0() throws Exception {
        int want = 0;
        int have = Fibonacci.fibonacci(0);
        assertEquals(have, want);
    }

    @Test
    public void testFibonacci1() throws Exception {
        int want = 1;
        int have = Fibonacci.fibonacci(1);
        assertEquals(have, want);
    }

    @Test
    public void testFibonacciN() throws Exception {
        int n = ThreadLocalRandom.current().nextInt(2, 10 + 1);
        int want = Fibonacci.fibonacci(n - 1) + Fibonacci.fibonacci(n - 2);
        int have = Fibonacci.fibonacci(n);
        assertEquals(have, want);
    }

    @Test(expectedExceptions = Exception.class)
    public void testFibonacciNegative() {
        Fibonacci.fibonacci(-1);
    }
}