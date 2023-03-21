package crackingcodinginterview.ArraysAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class F_StringCompression {

    public static void main(final String[] args) {
        final String origin = "aabcccccaaa";
        stringCompression(origin);

        final String incorrectOrigin = "pale";
        stringCompression(incorrectOrigin);
    }

    private static void stringCompression(final String origin) {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionSimpleVersion(origin));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionEnterpriseVersion(origin));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    public static String solutionSimpleVersion(final String origin) {
        validateParameter(origin);

        if (origin.length() < 3) {
            return origin;
        }

        final StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < origin.length(); i++, count++) {
            if (origin.length() == i + 1 || origin.charAt(i) != origin.charAt(i + 1)) {
                stringBuilder
                        .append(origin.charAt(i))
                        .append(count);
                count = 0;
            }
        }
        return stringBuilder.toString();
    }

    public static String solutionEnterpriseVersion(final String origin) {
        validateParameter(origin);

        if (origin.length() < 3) {
            return origin;
        }
        final List<Character> originChars = charToList(origin);
        final List<CountOfLetter> countOfLetters = countingLetters(originChars);

        return CountOfLetter.countOfLettersToString(countOfLetters);
    }

    private static List<CountOfLetter> countingLetters(final List<Character> originChars) {
        final List<CountOfLetter> countOfLetters = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < originChars.size(); i++) {
            if (originChars.get(i).equals(originChars.get(i - 1))) {
                count++;
            } else {
                countOfLetters.add(new CountOfLetter(originChars.get(i - 1), count));
                count = 1;
            }

            if (i + 1 == originChars.size()) {
                countOfLetters.add(new CountOfLetter(originChars.get(i), count));
            }
        }
        return countOfLetters;
    }

    private static List<Character> charToList(final String origin) {
        return origin.chars()
                .mapToObj(x -> (char) x)
                .toList();
    }

    private static void validateParameter(final String stringParam) {
        if (stringParam == null || stringParam.isBlank()) {
            throw new RuntimeException("String cannot be null or empty");
        }
    }

    public record CountOfLetter(char letter, int count) {

        public static String countOfLettersToString(List<CountOfLetter> countOfLetters) {
            StringBuilder stringBuilder = new StringBuilder();
            for (CountOfLetter countOfLetter : countOfLetters) {
                stringBuilder
                        .append(countOfLetter.letter)
                        .append(countOfLetter.count);
            }
            return stringBuilder.toString();
        }
    }
}
