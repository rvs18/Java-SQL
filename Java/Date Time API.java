// Date-Time API

// Parse the string, validate it, and convert to local date time object

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeParsing {
    public static void main(String[] args) {
        // Input string representing date-time
        String dateTimeString = "2024-05-15T12:30:45";

        // Define the date-time format expected in the input string
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
            // Parse the input string into a LocalDateTime object
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

            // Validate the parsed LocalDateTime object (optional)
            if (isValidDateTime(dateTime)) {
                System.out.println("Parsed LocalDateTime: " + dateTime);
            } else {
                System.out.println("Invalid date-time format");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing date-time: " + e.getMessage());
        }
    }

    private static boolean isValidDateTime(LocalDateTime dateTime) {
        // Add any custom validation logic here
        // For example, you can check if the parsed date-time falls within a certain range
        return true; // For simplicity, assuming all parsed date-times are valid
    }
}


// In this example:

// We have a string dateTimeString representing a date-time in the format "yyyy-MM-dd'T'HH:mm:ss".
// We define a DateTimeFormatter object formatter with the specified pattern.
// We use LocalDateTime.parse() method to parse the input string into a LocalDateTime object, using the defined formatter.
// We can optionally validate the parsed LocalDateTime object using custom logic in the isValidDateTime() method.
// If the input string is successfully parsed and passes validation, we print the parsed LocalDateTime object.

// Given Two strings, compare them and find the difference in time.

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeDifference {
    public static void main(String[] args) {
        // Input strings representing time
        String timeString1 = "10:30:00";
        String timeString2 = "12:45:30";

        // Define the time format expected in the input strings
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Parse the input strings into LocalTime objects
        LocalTime time1 = LocalTime.parse(timeString1, formatter);
        LocalTime time2 = LocalTime.parse(timeString2, formatter);

        // Calculate the difference between the two times
        long hoursDiff = Math.abs(ChronoUnit.HOURS.between(time1, time2));
        long minutesDiff = Math.abs(ChronoUnit.MINUTES.between(time1, time2));
        long secondsDiff = Math.abs(ChronoUnit.SECONDS.between(time1, time2));

        // Output the difference in time
        System.out.println("Difference in time:");
        System.out.println("Hours: " + hoursDiff);
        System.out.println("Minutes: " + minutesDiff);
        System.out.println("Seconds: " + secondsDiff);
    }
}

// In this code:

// We have two input strings timeString1 and timeString2 representing times in the format "HH:mm:ss".
// We define a DateTimeFormatter object formatter with the specified pattern.
// We use LocalTime.parse() method to parse the input strings into LocalTime objects, using the defined formatter.
// We calculate the difference between the two times using the ChronoUnit class, which provides various units of time (such as hours, minutes, and seconds) for calculating temporal differences.
// Finally, we output the difference in hours, minutes, and seconds between the two times.