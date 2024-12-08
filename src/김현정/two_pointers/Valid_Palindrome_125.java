package 김현정.two_pointers;


class Solution {

    /*
    내가 풀이
    runtime : 5ms | beats 42.58%
    memory  : 43.62 MB | beats 47.64%
    시간 복잡도 : O(n) | 공간 복잡도 : O(n)
    */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        String origin = sb.toString();
        String reverse = sb.reverse().toString();

        if(origin.equals(reverse)) {
            return true;
        }
        return false;
    }

    /*
     chatgpt 참고 변형
     runtime : 2ms | beats 99.09%
     memory  : 42.79 MB | beats 83.20%
     시간 복잡도 : O(n) | 공간 복잡도 : O(1)
     */
    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right)) ) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
