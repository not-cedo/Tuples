import dev.cedo.tuples.Pair;
import dev.cedo.tuples.mutable.MutablePair;
import dev.cedo.tuples.mutable.MutableTriplet;

/**
 * @author cedo
 * @since 05/24/2022
 */
public class Test {
    public static void main(String[] args) {
        Pair<Integer, Integer> pair = Pair.of(2,2);

        pair.use((a, b) -> System.out.println("First Value: " + a + ", Second Value: " + b));
        MutableTriplet<Integer, Boolean, String> triplet = MutableTriplet.of(20, false, "cedo");


        String data = triplet.apply((a, b, c) -> String.format("%s - %d - %b", c, a, b));
        triplet.computeSecond(i -> !i);

        System.out.println(data);


    }
}
