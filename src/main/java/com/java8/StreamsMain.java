package com.java8;

import com.java8.model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsMain {
    public static void main(String[] args) {

        //1
        //if nums is List of Integer
        List<Integer> list1 = Arrays.asList(5, 2, 4, 65, 24, 12, 64, 23);
        int min = list1.stream().min(Comparator.comparing(Integer::valueOf)).get();
        int count = (int) list1.stream().count();
        int sum = list1.stream().reduce(Integer::sum).get();
        System.out.println(min);

        //If nums is array of int
        int[] nums = {3, 4, 5, 1, 2};
        int minVal = Arrays.stream(nums).min().getAsInt();
        System.out.println(minVal);


        System.out.println("Second Last element of an array: "+list1.stream().skip(list1.size()-2).findFirst().get());

        //2
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1;
        System.out.println("Random number between 1 and 10: " + randomNumber);

        //3
        // Creating a List of Lists
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Geeks", "For"),
                Arrays.asList("GeeksForGeeks", "A computer portal"),
                Arrays.asList("Java", "Programming")
        );
        listOfLists.stream()
                .flatMap(list2 -> list2.stream())
                .forEach(System.out::println);

        //4
        StringJoiner stj = new StringJoiner(",");
        stj.add("Saket");
        stj.add("John");
        stj.add("Franklin");
        stj.add("Ricky");
        stj.add("Trevor");
        System.out.println(stj);//Saket,John,Franklin,Ricky,Trevor

        //5
        StringJoiner stj1 = new StringJoiner(",", "(", ")");
        stj.add("Saket");
        stj.add("John");
        stj.add("Franklin");
        stj.add("Ricky");
        stj.add("Trevor");
        System.out.println(stj1); //(Saket,John,Franklin,Ricky,Trevor)

        //6
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", "sajdk", 100000),
                new Employee(2, "Bill Gates", "dsad", 200000),
                new Employee(3, "Mark Zuckerberg", "dsad", 300000)
        };

        final Map<String, Long> productCatCounting = Arrays.asList(arrayOfEmps).stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println("productCatCounting: "+productCatCounting);

        Arrays.asList(arrayOfEmps).stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getName))
                .forEach(System.out::println);

        //7
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        //8
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(10);
        streamIterated.forEach(System.out::println);//40 42 44 46 48 50 52 54 56 58

        //9
        "abc".chars().forEach(System.out::println);//97,98,99

        //10
        List<String> numbersAsString = Arrays.asList("1.5", "2.5", "3.5");
        DoubleStream doubleStream = numbersAsString.stream()
                .mapToDouble(Double::parseDouble);
        doubleStream.forEach(System.out::println);

        //11
        Stream<String> strings = Stream.of("1,2,3", "4,5");
        IntStream intStream = strings.flatMapToInt(s -> Arrays.stream(s.split(","))
                .mapToInt(Integer::parseInt));
        intStream.forEach(System.out::println);

        //12
        Stream<Integer>
                s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer> >
                map = s.collect(
                Collectors.partitioningBy(num -> num > 3));
        //Elements in stream partitioned by less than equal to 3:
        //{false=[1, 2, 3], true=[4, 5, 6, 7, 8, 9, 10]}
        System.out.println("Elements in stream "
                + "partitioned by "
                + "less than equal to 3: \n"
                + map);

        Stream<Integer>
                s1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, Long>
                map1 = s1.collect(
                Collectors.partitioningBy(
                        num -> (num > 3), Collectors.counting()));
        // Displaying the result as a map
        // true if greater than 3, false otherwise
        System.out.println("Elements in stream "
                + "partitioned by "
                + "less than equal to 3: \n"
                + map1);

        //13
        List<String> g
                = Arrays.asList("geeks", "for", "geeks");
        Map<String, Long> result
                = g.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));//{geeks=2, for=1}

        // Print the result
        System.out.println(result);

        //14
        List<Character> ch = Arrays.asList(
                'G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G',
                'e', 'e', 'k', 's');

        // Converting character list into string
        // using joining() method of Collectors class
        String chString
                = ch.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        // Printing the concatenated string
        System.out.println(chString);

        // Create a string list
        List<String> str = Arrays.asList("Geeks", "for", "Geeks");

        // Convert the string list into String
        // using Collectors.joining() method
        String chString1
                = str.stream().collect(Collectors.joining(","));

        // Print the concatenated String
        System.out.println(chString1);

        //15
        // creating a string stream
        Stream<String> s2 = Stream.of("3", "4", "5");

        // using Collectors averagingDouble(ToDoubleFunction mapper)
        // method to find arithmetic mean of inputs given
        double ans = s2
                .collect(Collectors
                        .averagingDouble(
                                num -> Double.parseDouble(num)));

        // displaying the result
        System.out.println(ans);

        //16
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(new Employee(101, "Glady", "Mumbai", 2500000, "Manager", "Male"));
        employeesList.add(new Employee(102, "Vlad", "Delhi", 1500000, "Software Engineer", "Female"));
        employeesList.add(new Employee(103, "Shine", "Delhi", 2000000, "Lead Engineer", "Female"));
        employeesList.add(new Employee(104, "Nike", "Nagpur", 2500000, "Manager", "Female"));
        employeesList.add(new Employee(105, "Slagan", "Delhi", 1500000, "Software Engineer", "Male"));
        employeesList.add(new Employee(106, "Murekan", "Chennai", 1800000, "Software Engineer", "Male"));
        employeesList.add(new Employee(107, "Gagy", "Mumbai", 1500000, "Software Engineer", "Male"));
        Map<String, Map<String, Long>> genderCountByDesign = employeesList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDesignation,
                                Collectors.groupingBy(Employee::getGender,
                                        Collectors.counting())));

        // printing the count based on the designation and gender.
        System.out.println("genderCountByDesign" + genderCountByDesign);

        Map<String, Double> averageSalaryByDesign = employeesList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDesignation, Collectors.averagingInt(emp-> emp.getSalary())));

        // printing the count based on the designation and average salary.
        System.out.println("averageSalaryByDesign" + averageSalaryByDesign);

        //17
        Arrays.stream(new int[] {1, 2, 3})
                .average()
                .ifPresent(System.out::println);  // 2.0

        //18
        Stream.of("a1", "a2", "a3")
                .map(s5 -> s5.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);  // 3

        //19
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println); // a1 a2 a3

        //20
        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((str1, str2) -> {
                    System.out.printf("sort: %s; %s\n", str1, str2);
                    return str1.compareTo(str2);
                })
                .filter(str1 -> {
                    System.out.println("filter: " + str1);
                    return str1.startsWith("a");
                })
                .map(str1 -> {
                    System.out.println("map: " + str1);
                    return str1.toUpperCase();
                })
                .forEach(str1 -> System.out.println("forEach: " + str1));

        //21
        Supplier<String> defaultSupplier = () -> "Default Value";
        List<String> list = Arrays.asList("a", "b");
        System.out.println(list.stream().findAny().orElseGet(defaultSupplier));
        System.out.println(list.stream().findAny().orElseGet(()->"Getting default value inline"));

        //22
        //Sorting
        System.out.println("Sorting on EmpId:");
        employeesList.stream().sorted((e1,e2) -> e1.getEmpId() - e2.getEmpId()).forEach(System.out::println);
        System.out.println("Sorting on Address:");
        employeesList.stream().sorted(Comparator.comparing(employee -> employee.getAddress())).forEach(System.out::println);
        System.out.println("Sorting on Name:");
        employeesList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);


        //23
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mohit", 34);
        hashMap.put("Shiwani", 30);
        hashMap.put("Luv", 3);
        hashMap.put("Lavi", 2);

        List<Map.Entry<String, Integer>> entry = new ArrayList<>(hashMap.entrySet());
        Comparator<Map.Entry<String, Integer>> nameComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        };
        System.out.println("Compare map using Comparator based on name: ");
        entry.stream().sorted(nameComparator).forEach(System.out::println);
        System.out.println("Compare map using Lambda based on name: ");
        hashMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        Map<Employee, Integer> empMap = new HashMap<>();
        empMap.put(new Employee(101, "Glady", "Mumbai", 2500000, "Manager", "Male"), 478);
        empMap.put(new Employee(102, "Vlad", "Delhi", 1500000, "Software Engineer", "Female"), 923);
        empMap.put(new Employee(103, "Shine", "Delhi", 2000000, "Lead Engineer", "Female"), 76);
        empMap.put(new Employee(104, "Nike", "Nagpur", 2500000, "Manager", "Female"), 82);
        empMap.put(new Employee(105, "Slagan", "Delhi", 1500000, "Software Engineer", "Male"), 936);
        empMap.put(new Employee(106, "Murekan", "Chennai", 1800000, "Software Engineer", "Male"), 2534);
        empMap.put(new Employee(107, "Gagy", "Mumbai", 1500000, "Software Engineer", "Male"), 364);

        System.out.println("Compare Employee map using Lambda based on name: ");
        empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName))).forEach(System.out::println);

        //24
        Optional<Object> optionalEmpty = Optional.empty();
        System.out.println(optionalEmpty);

        Optional<Object> optionalInt = Optional.of(Integer.valueOf(0));
        System.out.println(optionalInt);

        Optional<Object> optionalNullable = Optional.ofNullable(null);
        System.out.println(optionalNullable);//If value null then it will print empty optional

        // Optional<Object> optionalNull = Optional.of(null);
        // System.out.println(optionalNull);// It will throw null pointer.

        // Optional<Object> optionalNullableExcep = Optional.ofNullable(null);
        // System.out.println(optionalNullableExcep.get());// NoSuchElementException

        Optional<Object> optionalNullableExcepSolu = Optional.ofNullable(null);
        if (optionalNullableExcepSolu.isPresent()){
            System.out.println(optionalNullableExcepSolu.get());
        }

        Optional<Object> optionalNullableExcepSolu1 = Optional.ofNullable("ygas");
        if (optionalNullableExcepSolu1.isPresent()){
            System.out.println(optionalNullableExcepSolu1.get());
        }

        Optional<String> optionalNullableExcepSolu2 = Optional.ofNullable(null);
        System.out.println(optionalNullableExcepSolu2.orElse("Default Null Value"));

        //Best practice for Optional
        /*
        public Optional<String> getAddress(){
            return Optional.ofNullable(address);
        }
        */

        //25
        List<Integer> nums1 = Arrays.asList(2,4,6,1,33,22,88,45,123);
        System.out.println(nums1.stream().mapToInt(i->i).sum());

        System.out.println(nums1.stream().reduce(0, (a,b)->a+b));

        System.out.println(nums1.stream().reduce((a,b)->a+b).get());

        System.out.println(nums1.stream().reduce(Integer::sum).get());

        System.out.println("Multiply: " +nums1.stream().reduce(1, (a,b) -> a*b ));

        System.out.println("Max: "+nums1.stream().reduce(Integer::max));

        List<String> stmt = Arrays.asList("Hi", "This", "is", "Mohit");

        final Optional<String> longestWord = stmt.stream().reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2);
        System.out.println("longestWord: "+longestWord.get());

        //26
        System.out.println("Average Salary: "+employeesList.stream().mapToDouble(Employee::getSalary).average().getAsDouble());

        //27
        String st = "I am a reverse string";
        System.out.println("Reverse String: "+Arrays.stream(st.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" ")));

        //28
        System.out.println(IntStream.range(1,11).sum());

        //29
        Set<Integer> set = new HashSet<>();
        nums1.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());

        //30
        st.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        //31
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //32
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        System.out.println("String with Prefix and Suffix: "+listOfStrings.stream().collect(Collectors.joining(",", "[", "]")));

        //33
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        listOfIntegers.stream().filter(i->i%5==0).forEach(System.out::println);

        //34
        List<Integer> listOfIntegerss = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("Minimum: "+listOfIntegerss.stream().min(Comparator.comparing(Integer::valueOf)).get());
        System.out.println("Maximum: "+listOfIntegerss.stream().max(Comparator.comparing(Integer::valueOf)).get());

        //35
        List<Integer> listOfIntegersss = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("3 Max Numbers: "+listOfIntegersss.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));
        System.out.println("3 Min Numbers: "+listOfIntegersss.stream().sorted(Comparator.naturalOrder()).limit(3).collect(Collectors.toList()));

        //36
        int i = 15623;
        Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));

        //37
        List<Integer> listOfIntege = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("Second Larget Element: " +listOfIntege.stream().sorted(Comparator.naturalOrder()).skip(listOfIntege.size()-2).findFirst().get());

        //38
        List<String> listOfString = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        System.out.println("Sort list with length: "+listOfString.stream().sorted(Comparator.comparing(word->word.length())).collect(Collectors.toList()));

        //39
        List<Integer> list11 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list22 = Arrays.asList(12, 56, 17, 21, 94, 34);
        System.out.println("Common Elements: "+list11.stream().filter(p->list22.contains(p)).collect(Collectors.toList()));

        //40
        //find the most repeated element in an array?
        List<String> listOfStringss = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String, Long> countMap = listOfStringss.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<String, Long> entryy = countMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();

        //41
        List<Integer> list2 = Arrays.asList(10,15,8,49,25,98,32);
        System.out.println("Even Numbers: "+list2.stream().filter(q->q%2==0).collect(Collectors.toList()));

        //42
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        System.out.println("Integers starting with 1: "+myList.stream().map(String::valueOf).filter(r->r.startsWith("1")).collect(Collectors.toList()));

        //43
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 60000),
                new Employee("Bob", "Finance", 75000),
                new Employee("Charlie", "IT", 90000),
                new Employee("David", "Finance", 50000),
                new Employee("Eve", "HR", 65000)
        );

        // Group by department, then find max salary
        Map<String, Optional<Employee>> highestPaidByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        // Print result
        highestPaidByDept.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.get().getName() + " (" + emp.get().getSalary() + ")"));

    }
}