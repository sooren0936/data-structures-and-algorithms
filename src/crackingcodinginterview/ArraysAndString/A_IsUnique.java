package crackingcodinginterview.ArraysAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class A_IsUnique {

    public static void main(String[] args) {
        String x = "1234567890qwertyuiopasdfghjkl;'zxcvbnm,./";
        int[] xx = {1, 3, 4};

        long l = System.currentTimeMillis();
        System.out.println("solution(x) = " + solutionWithAdditionalDataStructureASCII(x));
        System.out.println(System.currentTimeMillis() - l);

        long m = System.currentTimeMillis();
        System.out.println("solution(x) = " + solutionWithoutAdditionalDataStructureASCII(x));
        System.out.println(System.currentTimeMillis() - m);

        long b = System.currentTimeMillis();
        System.out.println("solution(x) = " + solutionWithoutAdditionalDataStructureASCIILowMemory(x));
        System.out.println(System.currentTimeMillis() - b);

        long a = System.currentTimeMillis();
        System.out.println("solution(x) = " + solutionWithoutAdditionalDataStructureASCIIWithSorting(x));
        System.out.println(System.currentTimeMillis() - a);
    }


    public static Boolean solutionWithAdditionalDataStructureASCII(String string) {
        if (string == null || string.isEmpty()) {
            throw new RuntimeException("String cannot be null or empty");
        }

        if (string.length() > 128) {
            return false;
        }

        char[] chars = string.toCharArray();

        Set<Character> characters = new HashSet<>();
        for (char charElement : chars) {
            if (characters.contains(charElement)) {
                return false;
            }
            characters.add(charElement);
        }
        return true;
    }

    public static Boolean solutionWithoutAdditionalDataStructureASCII(String string) {
        if (string == null || string.isEmpty()) {
            throw new RuntimeException("String cannot be null or empty");
        }
        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean solutionWithoutAdditionalDataStructureASCIILowMemory(String string) {
        if (string == null || string.isEmpty()) {
            throw new RuntimeException("String cannot be null or empty");
        }

        if (string.length() > 128) {
            return false;
        }

        boolean[] chars = new boolean[128];
        for (int i = 0; i < string.length(); i++) {
            int c = string.charAt(i);
            if (chars[c]) {
                return false;
            }
            chars[i] = true;
        }
        return true;
    }

    public static Boolean solutionWithoutAdditionalDataStructureASCIIWithSorting(String string) {
        if (string == null || string.isEmpty()) {
            throw new RuntimeException("String cannot be null or empty");
        }
        if (string.length() > 128) {
            return false;
        }

        char[] chars1 = string.toCharArray();
        Arrays.sort(chars1);

        for (int i = 0; i < chars1.length - 1; i++) {
            if (chars1[i] == chars1[i + 1]) {
                return false;
            }
        }
        return true;
    }
}