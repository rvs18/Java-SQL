// Java Streams and lambda expressions to filter data

// Suppose we have a list of integers and we want to filter out even numbers from it:

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using lambda expression and stream to filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);
    }
}

// In this example:

// We start with a list of integers numbers.
// We call the stream() method on the list to create a stream of elements.
// We use the filter() method to specify a predicate (a lambda expression num -> num % 2 == 0) that selects only even numbers.
// We use the collect() method with Collectors.toList() to collect the filtered elements into a new list.
// The lambda expression num -> num % 2 == 0 is used as the predicate for the filter() method. It checks whether each number in the stream is even (i.e, when divided by 2, the remainder is 0).