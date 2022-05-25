package dev.cedo;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * @author cedo
 * @since 05/24/2022
 */
public interface Triplet<A,B,C> {
    A getFirst();
    B getSecond();
    C getThird();

    <R> R use(TriFunction<? super A, ? super B, ? super C, ? extends R> func);
    void use(TriConsumer<? super A, ? super B, ? super C> func);


    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    interface TriConsumer<T, U, V> {
        void accept(T t, U u, V v);
    }

}
