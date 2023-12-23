package com.jaybee291998.mangadex_download_service.mangadex_download_service.util;

public class StringUtil {
    public static String padLeft(String input, int targetLenght, char padChar) {
        if(input.length() > targetLenght) {
            throw new IllegalArgumentException("you've done goof." + " input: " + input + ", targetLen: " + targetLenght);
        }
        int numberOfCharToPad = targetLenght - input.length();

        return generatePadding(padChar, numberOfCharToPad) + input;
    }

    public static String padRight(String input, int targetLenght, char padChar) {
        if(input.length() > targetLenght) {
            throw new IllegalArgumentException("you've done goof");
        }
        int numberOfCharToPad = targetLenght - input.length();
        return input + generatePadding(padChar, numberOfCharToPad);
    }

    public static String generatePadding(char charToPad, int times) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < times; i++) {
            sb.append(charToPad + "");
        }
        return sb.toString();
    }
}
