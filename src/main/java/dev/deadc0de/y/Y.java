package dev.deadc0de.y;

import java.util.function.Function;

public class Y {

    public static <T, R> Function<T, R> combinator(Function<Function<T, R>, Function<T, R>> f) {
        final Function<Function<Function, Function<T, R>>, Function<T, R>> c = x -> f.apply(y -> x.apply(x).apply(y));
        return c.apply(c::apply);
    }
}
