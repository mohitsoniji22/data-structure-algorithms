package epam.java8;

import java.util.*;
import java.util.stream.Collector;

public class CustomStringCollector {

    public static Collector<String, StringJoiner, String> joiningWithDelimiter(
            String delimiter, String prefix, String suffix) {

        return Collector.of(
                // Supplier: create a new StringJoiner
                () -> new StringJoiner(delimiter, prefix, suffix),

                // Accumulator: how to add an element
                StringJoiner::add,

                // Combiner: how to merge two StringJoiners (for parallel streams)
                StringJoiner::merge,

                // Finisher: convert StringJoiner to String
                StringJoiner::toString
        );
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        String result = fruits.stream()
                .collect(joiningWithDelimiter(", ", "[", "]"));

        System.out.println(result);  // Output: [Apple, Banana, Cherry]
    }
}
