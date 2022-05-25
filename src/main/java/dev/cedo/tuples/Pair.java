package dev.cedo;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author cedo
 * @since 05/24/2022
 */
public interface Pair<A, B> {
    A getFirst();
    B getSecond();

    <R> R use(BiFunction<? super A, ? super B, ? extends R> func);
    void use(BiConsumer<? super A, ? super B> func);
}
