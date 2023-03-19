package helpers;

import java.util.Random;

public class UniCodeRandomer {

    public static String getRandomUnicode() {
        Random random = new Random();
        int codePoint = random.nextInt(Character.MAX_CODE_POINT + 1);
        char[] charArray = Character.toChars(codePoint);
        String unicodeChar = new String(charArray);
        return unicodeChar;
    }

    public static char getRandomHiragana() {

        Random rand = new Random();
        int codePoint = rand.nextInt(0x309F - 0x3040 + 1) + 0x3040; // Generate a random code point within the Hiragana Unicode block
        // Character character = new Character(Character.toChars(codePoint)); // Convert the code point to a string
        Character character = Character.toChars(codePoint)[0];
        // System.out.println(character);
            // + " " + "に"
        return character;

    }
}
