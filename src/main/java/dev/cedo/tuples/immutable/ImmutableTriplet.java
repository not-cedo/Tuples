package dev.cedo.tuples.immutable;

import dev.cedo.tuples.Triplet;

/**
 * @author cedo
 * @since 05/24/2022
 */
public final class ImmutableTriplet<A, B, C> extends Triplet<A, B, C> {
    private final A a;
    private final B b;
    private final C c;

    ImmutableTriplet(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static <A, B, C> ImmutableTriplet<A, B, C> of(A a, B b, C c) {
        return new ImmutableTriplet<>(a, b, c);
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
    public <R> R apply(TriFunction<? super A, ? super B, ? super C, ? extends R> func) {
        return func.apply(a, b, c);
    }

    @Override
    public void use(TriConsumer<? super A, ? super B, ? super C> func) {
        func.accept(a, b, c);
    }
}
