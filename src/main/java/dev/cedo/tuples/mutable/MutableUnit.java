package dev.cedo.tuples.mutable;

import dev.cedo.tuples.Unit;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author cedo
 * @since 05/24/2022
 */
public class MutableUnit<A> extends Unit<A> {
    private A a;

    MutableUnit(A a){
        this.a = a;
    }

    public static <A> MutableUnit<A> of(A a){
        return new MutableUnit<>(a);
    }

    @Override
    public A get() {
        return a;
    }

    public void set(A a) { this.a = a; }

    @Override
    public <R> R use(Function<? super A, ? extends R> func) {
        return func.apply(a);
    }

    @Override
    public void use(Consumer<? super A> func) {
        func.accept(a);
    }

    public void compute(UnaryOperator<A> mapper) {
        this.a = mapper.apply(a);
    }
}
