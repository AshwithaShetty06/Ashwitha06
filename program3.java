import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include lowercase characters? (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase characters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, includeLowercase, includeUppercase, includeDigits, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase,
                                           boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        // Create a string containing all allowed characters based on user's criteria
        StringBuilder allowedChars = new StringBuilder();
        if (includeLowercase) allowedChars.append(LOWERCASE_CHARS);
        if (includeUppercase) allowedChars.append(UPPERCASE_CHARS);
        if (includeDigits) allowedChars.append(DIGITS);
        if (includeSpecialChars) allowedChars.append(SPECIAL_CHARS);

        // Generate password
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
