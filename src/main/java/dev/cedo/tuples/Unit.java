package dev.cedo.tuples;

import dev.cedo.tuples.immutable.ImmutablePair;
import dev.cedo.tuples.immutable.ImmutableUnit;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author cedo
 * @since 05/24/2022
 */
public abstract class Unit<A> {

    public static <A> Unit<A> of(A a) { return ImmutableUnit.of(a); }

    public abstract A get();

    public abstract <R> R use(Function<? super A, ? extends R> func);
    public abstract void use(Consumer<? super A> func);

    @Override
    public int hashCode() {
        return Objects.hash(get());
    }

    @Override
    public boolean equals(Object that) {
        if(this == that) return true;
        if (that instanceof Unit<?>) {
            final Unit<?> other = (Unit<?>) that;
            return Objects.equals(get(), other.get());
        }
        return false;
    }

}
