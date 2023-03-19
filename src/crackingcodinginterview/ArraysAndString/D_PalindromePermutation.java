package crackingcodinginterview.ArraysAndString;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Palindrome Permutation:
 * Given a string, write a function to check if it is a permutation of a palindrome
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat'; "atc o eta·; etc.)
 */
public class D_PalindromePermutation {

    public static void main(final String[] args) {
        final String correctPalindromePermutation = "Tact Coa";
        palindromePermutation(correctPalindromePermutation);

        final String incorrectPalindromePermutation = "Tact Coa1";
        palindromePermutation(incorrectPalindromePermutation);
    }

    private static void palindromePermutation(final String whetherPalindromePermutation) {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solution(whetherPalindromePermutation));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    public static Boolean solution(final String whetherPalindromePermutation) {
        if (whetherPalindromePermutation == null || whetherPalindromePermutation.isBlank()) {
            throw new RuntimeException("String cannot be null or empty");
        }

        final String formattedWhetherPalindromePermutation = formatWhetherPalindromePermutation(whetherPalindromePermutation);
        final Map<Character, Integer> palindromePermutations = makeMappingForPalindromePermutation(formattedWhetherPalindromePermutation);
        final long odds = defineOdds(palindromePermutations);

        return odds > 1;
    }

    private static Map<Character, Integer> makeMappingForPalindromePermutation(final String formattedWhetherPalindromePermutation) {
        return formattedWhetherPalindromePermutation.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.toMap(x -> x, y -> 1, (x, y) -> x + 1));
    }

    private static String formatWhetherPalindromePermutation(final String whetherPalindromePermutation) {
        return whetherPalindromePermutation
                .toLowerCase()
                .strip()
                .replace(" ", "");
    }

    private static long defineOdds(final Map<Character, Integer> palindromePermutations) {
        return palindromePermutations.entrySet().stream()
                .filter(x -> x.getValue() % 2 != 0)
                .count();
    }
}
