package Utils;

import java.util.Random;

public class RandomHelper {
    private static String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static int EMAIL_LENGTH = 6;

    public static String generateRandomString( ) {
        Random rnd = new Random();
        StringBuilder emailName = new StringBuilder(EMAIL_LENGTH);

        for (int i = 0; i < EMAIL_LENGTH; i++) {
            int randomIndex = rnd.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            emailName.append(randomChar);
        }
        return emailName.toString();
    }
}