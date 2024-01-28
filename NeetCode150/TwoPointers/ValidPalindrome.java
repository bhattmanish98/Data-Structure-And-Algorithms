class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int end = len-1;
        while(start < end) {
            while(start < end && !isAlphaNumeric(s.charAt(start))) start++;
            while(start < end && !isAlphaNumeric(s.charAt(end))) end--;
            if(!isEqualIgnoreCase(s.charAt(start), s.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return Character.isLetterOrDigit(c);
    }

    private boolean isEqualIgnoreCase(char c1, char c2) {
        return Character.toString(c1).equalsIgnoreCase(Character.toString(c2));
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("r "));
    }
}