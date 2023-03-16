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

        System.out.println(solution1(string, substring));
        System.out.println(solution2(string, substring));
        System.out.println(solution3(string, substring));
    }

    public static boolean solution1(String string, String substring) {
        if (string == null || string.isBlank()) {
            return false;
        }

        if (substring == null || substring.isBlank()) {
            return false;
        }

        if (string.length() != substring.length()) {
            return false;
        }

        char[] chars1 = string.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = substring.toCharArray();
        Arrays.sort(chars2);

        return String.valueOf(chars1).contains(String.valueOf(chars2));
    }

    public static boolean solution2(String string, String substring) {
        if (string == null || string.isBlank()) {
            return false;
        }

        if (substring == null || substring.isBlank()) {
            return false;
        }

        if (string.length() != substring.length()) {
            return false;
        }


        String[] split1 = string.split("");
        String[] split2 = substring.split("");
        Map<String, Integer> collect = Arrays.stream(split1).collect(Collectors.toMap(x -> x, String::length, Integer::sum));

        for (String s : split2) {
            if (collect.get(s) != null) {
                if (collect.get(s) == 1) {
                    collect.remove(s);
                } else {
                    collect.put(s, collect.get(s) - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean solution3(String string, String substring) {
        if (string == null || string.isBlank()) {
            return false;
        }

        if (substring == null || substring.isBlank()) {
            return false;
        }

        if (string.length() != substring.length()) {
            return false;
        }

        int[] x = new int[128];

        char[] stringChars = string.toCharArray();
        for (char stringChar : stringChars) {
            x[stringChar] = x[stringChar] + 1;
        }

        char[] chars = substring.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (x[aChar]-- == 0) {
                return false;
            }
        }

        return true;
    }
}