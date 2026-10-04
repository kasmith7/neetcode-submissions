class Solution {
    public boolean isPalindrome(String s) {
        //'A' < 'a'

        char[] ca = s.toCharArray();
        int len = 0;

        for (int i = 0; i < ca.length; i++) {
            if (ca[i] >= 'A' && ca[i] <= 'Z') {
                ca[i] ^= 32;
            }
            if (isChar(ca[i])) {
                ca[len++] = ca[i];
            }
        }
        for (int i = 0, j = len - 1; i < j; i++) {
            if (ca[i] != ca[j]) return false;
            j--;
        }
        return true;
    }
    private boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') 
        || (c >= '0' && c <= '9');
    }

}
