package 김현정.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // 처음 풀이
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] arr = ransomNote.toCharArray();
        Arrays.sort(arr);
        char[] arr2 = magazine.toCharArray();
        Arrays.sort(arr2);
        boolean[] result = new boolean[arr.length];

        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = index; j < arr2.length; j++) {
                if(arr[i] == arr2[j]) {
                    index = j+1;
                    result[i] = true;
                    break;
                }
            }
        }

        for(boolean i : result) {
            if(!i) return false;
        }

        return true;
    }

    //HashMap 이용한 풀이
    public boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for(char a : magazine.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0)+ 1);
        }

        for(char a : ransomNote.toCharArray()) {
            if(!map.containsKey(a) || map.get(a) == 0) {
                return false;
            }
            map.put(a, map.get(a) - 1);
        }

        return true;
    }

    //알파벳 개수를 이용한 풀이 - 제일 효율적
    public boolean canConstruct3(String ransomNote, String magazine) {
        int[] charCount = new int[26];

        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--charCount[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

}
