package crackingcodinginterview.ArraysAndString;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Check Permutation:
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class B_CheckPermutation {

    public static void main(String[] args) {
        String string = "ffasdfaassdd";
        String substring = "asdfaassddff";

        System.out.println(solutionWithContains(string, substring));
        System.out.println(solutionIterativeWithStringArrays(string, substring));
        System.out.println(solutionIterativeWithCharArrays(string, substring));
    }

    public static boolean solutionWithContains(final String string, final String substring) {
        validateParameter(string);
        validateParameter(substring);

        if (string.length() != substring.length()) {
            return false;
        }

        char[] chars1 = string.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = substring.toCharArray();
        Arrays.sort(chars2);

        return String.valueOf(chars1).contains(String.valueOf(chars2));
    }

    public static boolean solutionIterativeWithStringArrays(final String string, final String substring) {
        validateParameter(string);
        validateParameter(substring);

        if (string.length() != substring.length()) {
            return false;
        }

        final String[] splittedString = string.split("");
        final String[] splittedSubstring = substring.split("");
        final Map<String, Integer> countOfLettersFromString = Arrays.stream(splittedString)
                .collect(Collectors.toMap(x -> x, String::length, Integer::sum));

        for (final String substr : splittedSubstring) {
            if (countOfLettersFromString.get(substr) != null) {
                if (countOfLettersFromString.get(substr) == 1) {
                    countOfLettersFromString.remove(substr);
                } else {
                    countOfLettersFromString.put(substr, countOfLettersFromString.get(substr) - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean solutionIterativeWithCharArrays(final String string, final String substring) {
        validateParameter(string);
        validateParameter(substring);

        if (string.length() != substring.length()) {
            return false;
        }

        final int[] charsFromString = new int[128];

        final char[] stringChars = string.toCharArray();
        for (final char stringChar : stringChars) {
            charsFromString[stringChar] = charsFromString[stringChar] + 1;
        }

        final char[] subStringChars = substring.toCharArray();
        for (final char aChar : subStringChars) {
            if (charsFromString[aChar]-- == 0) {
                return false;
            }
        }

        return true;
    }

    private static void validateParameter(String substring) {
        if (substring == null || substring.isBlank()) {
            throw new RuntimeException("String cannot be null or empty");
        }
    }
}