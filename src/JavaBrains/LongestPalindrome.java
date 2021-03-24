package JavaBrains;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("sdfsdfabad"));
    }

    static int palBegin;
    static int palLength;

    /**
     * finds the longest palindrome sequence
     * @param s input string
     * @return longest palindrome
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int start = 0; start < s.length() - 1; start++) {
            checkForPal(s, start, start);
            checkForPal(s, start, start + 1);
        }
        return s.substring(palBegin, palBegin + palLength);
    }

    public static void checkForPal(String s, int start, int end) {
        while (start >= 0 && end < s.length() &&
                s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (palLength < (end - start - 1)) {
            palBegin = start + 1;
            palLength = end - start - 1;
        }
    }
}
