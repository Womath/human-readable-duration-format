import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();

        String input = scanner.nextLine();

        if (validator.validateInput(input)) {
            DurationConverter durationConverter = new DurationConverter();
            Duration duration = durationConverter.convertDuration(Long.parseLong(input));
            DurationFormatter durationFormatter = new DurationFormatter(duration);
            durationFormatter.formatDuration();
            System.out.println(duration.getFormattedText());

        } else {
            System.out.println("Incorrect input data");
        }
    }
}