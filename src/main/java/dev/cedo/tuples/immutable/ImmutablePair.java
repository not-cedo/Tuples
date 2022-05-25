package dev.cedo.tuples;

import dev.cedo.Pair;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * @author cedo
 * @since 05/24/2022
 */
final class ImmutablePair<A, B> implements Pair<A, B> {
    private final A a;
    private final B b;

    ImmutablePair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public A getFirst() {
        return a;
    }

    @Override
    public B getSecond() {
        return b;
    }


    @Override
    public <R> R use(BiFunction<? super A, ? super B, ? extends R> func) {
        return func.apply(a, b);
    }

    @Override
    public void use(BiConsumer<? super A, ? super B> func) {
        func.accept(a, b);
    }
}
