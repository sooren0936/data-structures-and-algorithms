package crackingcodinginterview.ArraysAndString;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 */
public class C_URLify {

    public static void main(final String[] args) {
        final String nonUniqueString = "    1abcd egf1";
        urlify(nonUniqueString);

        final String UniqueString = "1 a b c d e g f";
        urlify(UniqueString);
    }

    private static void urlify(final String urlifyString) {
        long currentTimeMillis;

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithString(urlifyString));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(solutionWithCharArray(urlifyString.toCharArray()));
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

    public static String solutionWithString(final String urlifyString) {
        if (urlifyString == null || urlifyString.isBlank()) {
            throw new RuntimeException("String cannot be null or empty");
        }
        final String strippedUrlifyString = urlifyString.strip();
        final String regexpedUrlifyString = strippedUrlifyString.replaceAll("(\\s)+", "%20");
        return regexpedUrlifyString;
    }

    public static String solutionWithCharArray(char[] urlifyChars) {
        if (urlifyChars == null || urlifyChars.length == 0) {
            throw new RuntimeException("String cannot be null or empty");
        }
        final char[] correctUrlifyChars = new char[urlifyChars.length * 3];

        int correctUrlifyCounter = 0;
        boolean isRepeatedWhiteSpace = false;
        boolean isStart = true;
        for (int counter = correctUrlifyCounter; counter < urlifyChars.length; counter++) {
            if (urlifyChars[counter] == ' ') {
                if (isRepeatedWhiteSpace) {
                    continue;
                }
                isRepeatedWhiteSpace = true;
            } else {
                if (isRepeatedWhiteSpace && !isStart) {
                    correctUrlifyChars[correctUrlifyCounter++] = '%';
                    correctUrlifyChars[correctUrlifyCounter++] = '2';
                    correctUrlifyChars[correctUrlifyCounter++] = '0';
                }
                correctUrlifyChars[correctUrlifyCounter++] = urlifyChars[counter];
                isStart = false;
                isRepeatedWhiteSpace = false;
            }
        }
        return new String(correctUrlifyChars)
                .replace('\0', ' ')
                .strip();
    }
}
