package dev.cedo.tuples.mutable;

import dev.cedo.tuples.Pair;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

/**
 * @author cedo
 * @since 05/24/2022
 */
public class MutablePair<A, B> extends Pair<A, B> {
    private A a;
    private B b;

    MutablePair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public static <L, R> MutablePair<L, R> of(final L left, final R right) {
        return new MutablePair<>(left, right);
    }

    @Override
    public A getFirst() { return a; }

    @Override
    public B getSecond() { return b; }

    public void setFirst(A a) { this.a = a; }

    public void setSecond(B b) { this.b = b; }

    @Override
    public <R> R use(BiFunction<? super A, ? super B, ? extends R> func) { return func.apply(a, b); }

    @Override
    public void use(BiConsumer<? super A, ? super B> func) {
        func.accept(a, b);
    }

    public void computeFirst(UnaryOperator<A> operator) {
        this.a = operator.apply(a);
    }

    public void computeSecond(UnaryOperator<B> operator) {
        this.b = operator.apply(b);
    }
}
