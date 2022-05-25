package dev.cedo.tuples;

import dev.cedo.Triplet;

/**
 * @author cedo
 * @since 05/24/2022
 */
class ImmutableTriplet<A, B, C> implements Triplet<A, B, C> {
    private final A a;
    private final B b;
    private final C c;

    ImmutableTriplet(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
    public C getThird() {
        return c;
    }

    @Override
    public <R> R use(TriFunction<? super A, ? super B, ? super C, ? extends R> func) {
        return func.apply(a, b, c);
    }

    @Override
    public void use(TriConsumer<? super A, ? super B, ? super C> func) {
        func.accept(a, b, c);
    }
}
