package epam.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondHighestFrequencyWord {

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "apple", "banana", "orange", "apple", "orange", "banana",
                "banana", "apple", "grape", "orange", "apple", "orange", "apple"
        );

        final Map<String, Long> freqGroup = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(freqGroup.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst()
                .get()
                .getKey());

        int[] nums = {1, 2, 3, 1, 3, 1, 1, 2, 2};

        //Given array of Integer, return the second highest frequency integer. EX:{4,4,4,2,2,3}  out:2
        final Integer key = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).skip(1).findFirst().get().getKey();
        System.out.println(key);

        //Given list of Integer, return list of unique integers sorted in descending order of their frequency. EX:{4,4,4,2,2,3}  out: 4,2,3
        Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(i -> i.getKey())
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);


        //Given List of names, filter names which starts with A and return answer in capitals
        //{"abc", "def", "Akf"} => {ABC, "AKF}

        String[] str = {"abc", "def", "Akf"};
        Arrays.stream(str)
                .filter(word->word.startsWith("a") || word.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //From given List of String, return the longest string in all caps
        final String s = words.stream().map(String::toUpperCase)
                .max((a, b) -> Integer.compare(a.length(), b.length()))
                .get();
        System.out.println(s);

    }
}
