package 김현정.array_string;

import java.util.*;

public class Merge_Sorted_Array_88 {

    /*
    내가 풀이
    runtime : 1ms | beats 28.75%
    memory  : 41.90 MB | beats 88.07%
    공간 복잡도 :  O(m + n) | 시간 복잡도 : O((m + n) log(m + n))
    */
    class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < m; i++) {
                list.add(nums1[i]);
            }

            for(int i = 0; i < n; i++) {
                list.add(nums2[i]);
            }

            Collections.sort(list);

            for(int i = 0; i<list.size(); i++) {
                nums1[i] = list.get(i);
            }
        }
    }

    /*
    chatgpt 참고 변형
    runtime : 0ms | beats 100%
    memory  : 42.13 MB | beats 44.16%
    시간 복잡도 : O(m + n)
    */
    class Solution2 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;

            while(j >= 0) {
                nums1[k--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            }
        }
    }
}
