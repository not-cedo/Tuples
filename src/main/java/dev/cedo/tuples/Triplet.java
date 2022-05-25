package dev.cedo.tuples;

import dev.cedo.tuples.immutable.ImmutablePair;
import dev.cedo.tuples.immutable.ImmutableTriplet;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * @author cedo
 * @since 05/24/2022
 */
public abstract class Triplet<A, B, C> implements Serializable {

    public static <A, B, C> Triplet<A, B, C> of(A a, B b, C c) { return ImmutableTriplet.of(a, b, c); }

    public abstract A getFirst();
    public abstract B getSecond();
    public abstract C getThird();

    public abstract <R> R use(TriFunction<? super A, ? super B, ? super C, ? extends R> func);
    public abstract void use(TriConsumer<? super A, ? super B, ? super C> func);


    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    public interface TriConsumer<T, U, V> {
        void accept(T t, U u, V v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond(), getThird());
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that instanceof Triplet<?, ?, ?>) {
            final Triplet<?, ?, ?> other = (Triplet<?, ?, ?>) that;
            return Objects.equals(getFirst(), other.getFirst()) && Objects.equals(getSecond(), other.getSecond()) && Objects.equals(getThird(), other.getThird());
        }
        return false;
    }

}
