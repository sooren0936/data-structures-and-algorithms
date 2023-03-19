package crackingcodinginterview.ArraysAndString;

import java.util.List;
import java.util.stream.Collectors;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class E_OneAway {

    public static void main(final String[] args) {
        final String correctOrigin = "pale";
        final String correctWhetherOneEdit = "ple";
        oneAway(correctOrigin, correctWhetherOneEdit);

        final String incorrectOrigin = "pale";
        final String incorrectWhetherOneEdit = "plea";
        oneAway(incorrectOrigin, incorrectWhetherOneEdit);
    }

    private static void oneAway(final String origin, final String whetherOneEdit) {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solution(origin, whetherOneEdit));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    public static Boolean solution(final String origin, final String whetherOneEdit) {
        validateParameter(origin);
        validateParameter(whetherOneEdit);
        if (Math.abs(origin.length() - whetherOneEdit.length()) > 1) {
            return false;
        }

        final List<Character> originList = stringToList(origin);
        final List<Character> whetherOneEditList = stringToList(whetherOneEdit);

        return checkIsOneEdit(originList, whetherOneEditList);
    }

    private static boolean checkIsOneEdit(final List<Character> originList, final List<Character> whetherOneEditList) {
        int edits = 0;
        for (int originListIndex = 0, whetherOneEditListIndex = 0; originListIndex < originList.size(); originListIndex++, whetherOneEditListIndex++) {
            if (!originList.get(originListIndex).equals(whetherOneEditList.get(whetherOneEditListIndex))) {
                edits++;

                if (originList.size() > whetherOneEditList.size()) {
                    whetherOneEditListIndex--;
                } else if (originList.size() < whetherOneEditList.size()) {
                    originListIndex--;
                }
            }
            if (edits > 1) {
                return false;
            }
        }
        return true;
    }

    private static List<Character> stringToList(final String origin) {
        return origin.chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.toList());
    }

    private static void validateParameter(final String stringParam) {
        if (stringParam == null || stringParam.isBlank()) {
            throw new RuntimeException("String cannot be null or empty");
        }
    }
}
