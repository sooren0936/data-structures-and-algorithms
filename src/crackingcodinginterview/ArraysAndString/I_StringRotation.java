package crackingcodinginterview.ArraysAndString;

/**
 * String Rotation: Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
 */
public class I_StringRotation {

    public static void main(final String[] args) {
        final String correctOrigin = "waterbottle";
        final String correctWhetherSubstring = "erbottlewat";
        rotateString(correctOrigin, correctWhetherSubstring);

        final String incorrectOrigin = "ewaterbottl";
        final String incorrectWhetherSubstring = "awaterbottl";
        rotateString(incorrectOrigin, incorrectWhetherSubstring);
    }

    private static void rotateString(final String origin, final String whetherSubstring) {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionIsSubstringSimple(origin, whetherSubstring));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionIsSubstringWithTwoLoops(origin, whetherSubstring));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    public static boolean solutionIsSubstringSimple(final String s1, final String s2) {
        validateParameter(s1);
        validateParameter(s2);

        if (s1.length() != s2.length()) {
            return false;
        }
        final String doubleS1 = s1 + s1;

        return (doubleS1).contains(s2);
    }

    public static boolean solutionIsSubstringWithTwoLoops(final String s1, final String s2) {
        validateParameter(s1);
        validateParameter(s2);

        if (s1.length() != s2.length()) {
            return false;
        }

        int sequence = 0;
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(j) != s2.charAt(i)) {
                sequence = 0;
                j = 0;
                continue;
            }
            sequence++;
            j++;
        }

        if (s1.length() == sequence) {
            return true;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(j) != s2.charAt(i)) {
                return false;
            }
            sequence++;
            j++;

            if (s1.length() == sequence) {
                return true;
            }
        }

        return false;
    }

    private static void validateParameter(final String stringParam) {
        if (stringParam == null || stringParam.isBlank()) {
            throw new RuntimeException("String cannot be null or empty");
        }
    }
}