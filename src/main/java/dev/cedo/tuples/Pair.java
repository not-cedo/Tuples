package dev.cedo.tuples;

import dev.cedo.tuples.immutable.ImmutablePair;
import dev.cedo.tuples.mutable.MutablePair;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author cedo
 * @since 05/24/2022
 */
public abstract class Pair<A, B> implements Serializable {

    public static <A, B> Pair<A, B> of(A a, B b) { return ImmutablePair.of(a, b); }

    public abstract A getFirst();

    public abstract B getSecond();

    public abstract <R> R use(BiFunction<? super A, ? super B, ? extends R> func);

    public abstract void use(BiConsumer<? super A, ? super B> func);

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }

    @Override
    public boolean equals(Object that) {
        if(this == that) return true;
        if (that instanceof Pair<?, ?>) {
            final Pair<?, ?> other = (Pair<?, ?>) that;
            return Objects.equals(getFirst(), other.getFirst()) && Objects.equals(getSecond(), other.getSecond());
        }
        return false;
    }
}
