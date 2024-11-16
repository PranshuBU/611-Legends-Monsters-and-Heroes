/*
 * InputHandler.java
 * This utility class simplifies and validates user input handling for different data types.
 * It supports common types like Integer, Double, Boolean, and String, and provides methods
 * for input validation within a range, from a set of options, or with custom parsing logic.
 * The class also includes case-insensitive input validation for string options.
 */


package Exception;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class InputHandler<T> {
    private final Scanner scanner;
    private final Function<String, T> parser;
    private final String typeName;

    @SuppressWarnings("unchecked")
    public InputHandler(Class<T> type) {
        this.scanner = new Scanner(System.in);
        this.typeName = type.getSimpleName();

        // Define default parsers for common types
        if (type == Integer.class) {
            this.parser = str -> (T) Integer.valueOf(str);
        } else if (type == Double.class) {
            this.parser = str -> (T) Double.valueOf(str);
        } else if (type == Boolean.class) {
            this.parser = str -> (T) Boolean.valueOf(str);
        } else if (type == String.class) {
            this.parser = str -> (T) str;
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type.getName());
        }
    }

    public InputHandler(Function<String, T> customParser, String typeName) {
        this.scanner = new Scanner(System.in);
        this.parser = customParser;
        this.typeName = typeName;
    }


    public T getInput(String prompt, Predicate<T> validator, String validationMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                T parsedInput = parser.apply(input);
                if (validator.test(parsedInput)) {
                    return parsedInput;
                } else {
                    System.out.println(validationMessage);
                }
            } catch (Exception e) {
                System.out.printf("Invalid input. Enter a valid %s.%n", typeName);
            }
        }
    }

    /**
     * Get input within a range (for numeric types)
     */
    @SuppressWarnings("unchecked")
    public T getInput(String prompt, T min, T max) {
        if (!(min instanceof Comparable && max instanceof Comparable)) {
            throw new IllegalArgumentException("Min and max must be Comparable");
        }

        String validationMessage = String.format("Please enter a value between %s and %s", min, max);

        return getInput(
                prompt,
                value -> {
                    Comparable<T> cMin = (Comparable<T>) min;
                    Comparable<T> cMax = (Comparable<T>) max;
                    return cMin.compareTo(value) <= 0 && cMax.compareTo(value) >= 0;
                },
                validationMessage
        );
    }

    /**
     * Get input from a set of valid options
     */
    public T getInput(String prompt, T... validOptions) {
        Set<T> validSet = new HashSet<>(Arrays.asList(validOptions));
        String validationMessage = "Valid options are: " + Arrays.toString(validOptions);

        return getInput(
                prompt,
                validSet::contains,
                validationMessage
        );
    }

    /**
     * Get string input with case-insensitive comparison
     */
    public String getStringInputIgnoreCase(String prompt, String... validOptions) {
        Set<String> validSet = new HashSet<>();
        for (String option : validOptions) {
            validSet.add(option.toLowerCase());
        }

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (validSet.contains(input)) {
                return input;
            }
            System.out.println("Valid options are: " + Arrays.toString(validOptions));
        }
    }

    public void close() {
        scanner.close();
    }
}
