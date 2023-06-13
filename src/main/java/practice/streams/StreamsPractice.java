package practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsPractice {

    public static void main(String[] args) {
        filter();
        map();
        flatMap();
        distinct();
        sort();

        forEach();
        reduce();
        count();
        anyMatch();
        collect();

        filterSortedForEach();
    }

    //Filter a Stream based on a predicate
    static void filter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) //intermediate
                .collect(Collectors.toList());
        System.out.println(evenNumbers); // [2, 4, 6, 8, 10]
    }

    //Transform each element of a Stream using a function
    static void map() {
        List<String> words = Arrays.asList("hello", "world", "how", "are", "you");
        List<Integer> wordLengths = words.stream()
                .map(String::length) //intermediate
                .collect(Collectors.toList());
        System.out.println(wordLengths); // [5, 5, 3, 3, 3]
    }

    //Transform each element of a Stream into zero or more elements using a function
    static void flatMap() {
        List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6, 7, 8, 9));
        List<Integer> flattenedNumbers = numbers.stream()
                .flatMap(list -> list.stream()) //intermediate
                .collect(Collectors.toList());
        System.out.println(flattenedNumbers); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    //Remove duplicates from a Stream
    static void distinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 7, 4, 8);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct() //intermediate
                .collect(Collectors.toList());
        System.out.println(distinctNumbers); // [1, 2, 3, 4, 5, 6, 7, 8]
    }

    //Sort a Stream based on a Comparator:
    static void sort() {
        List<String> words = Arrays.asList("hello", "world", "how", "are", "you");
        List<String> sortedWords = words.stream()
                .sorted(Comparator.comparing(String::length)) //intermediate
                .collect(Collectors.toList());
        System.out.println(sortedWords); // [how, are, you, hello, world]
    }
    //-----------------------------------------------------------------------------

    static void forEach() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println); //terminal
    }

    //Calculate the sum of a list of integers
    static void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b); //terminal
        System.out.println(sum); // 15
    }

    //Count the number of elements in the Stream
    static void count() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        long count = numbers.stream()
                .count(); //terminal
        System.out.println(count); // 5
    }

    //Check if any elements of the Stream match a given predicate
    static void anyMatch() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean hasEvenNumbers = numbers.stream()
                .anyMatch(n -> n % 2 == 0);  //terminal
        System.out.println(hasEvenNumbers); // true
    }

    //Collect the elements of the Stream into a Collection or other data structure
    static void collect() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squaredNumbers); // [1, 4, 9, 16, 25]
    }
    //-----------------------------------------------------------------------------

    //filter map and collect
    static void filterMapCollect() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "David");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(filteredNames); // [ALICE, ANNA]
    }

    //flatmap distinct and count
    static void flatmapDistinctCount() {
        List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), Arrays.asList(5, 6, 7));
        long count = numbers.stream()
                .flatMap(list -> list.stream())
                .distinct()
                .count();
        System.out.println(count); // 7
    }

    //map(), reduce(), and orElse()
    static void mapReduceElse() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers.stream()
                .mapToDouble(n -> n)
                .reduce((a, b) -> (a + b) / 2)
                .orElse(0);
        System.out.println(average); // 3.5
    }

    //filter(), sorted(), and forEach()
    static void filterSortedForEach() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 25),
                new Employee("Bob", 35),
                new Employee("Charlie", 30),
                new Employee("David", 40)
        );

        employees.stream()
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(e -> System.out.println(e.getName()));
    }
}