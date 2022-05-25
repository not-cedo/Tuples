package dev.cedo.tuples;

import dev.cedo.Unit;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author cedo
 * @since 05/24/2022
 */
public class MutableUnit<A> implements Unit<A> {
    private A a;

    public MutableUnit(A a){
        this.a = a;
    }


    @Override
    public A get() {
        return a;
    }

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
