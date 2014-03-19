package dev.deadc0de.y;

import java.util.function.Function;
import org.junit.Assert;
import org.junit.Test;

public class YTest {

    @Test
    public void applyYCombinatorToFactorial() {
        final Function<Function<Integer, Integer>, Function<Integer, Integer>> factorialGenerator = f -> n -> n == 0 ? 1 : n * f.apply(n - 1);
        final Function<Integer, Integer> factorial = Y.combinator(factorialGenerator);
        Assert.assertEquals(24, factorial.apply(4).intValue());
    }

    @Test
    public void applyYCombinatorToFibonacci() {
        final Function<Function<Integer, Integer>, Function<Integer, Integer>> fibonacciGenerator = f -> n -> n <= 1 ? n : f.apply(n - 1) + f.apply(n - 2);
        final Function<Integer, Integer> fibonacci = Y.combinator(fibonacciGenerator);
        Assert.assertEquals(21, fibonacci.apply(8).intValue());
    }
}
