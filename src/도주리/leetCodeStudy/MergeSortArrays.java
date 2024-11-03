package 도주리.leetCodeStudy;

import java.util.Arrays;
public class MergeSortArrays {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // 0이 아닌 값만 필터링하여 새로운 배열 생성
        nums1 = Arrays.stream(nums1)
                .filter(nums -> nums != 0)
                .toArray();
        nums2 = Arrays.stream(nums2)
                .filter(nums -> nums != 0)
                .toArray();
        System.out.println(Arrays.toString(nums1));//nums1.toString());
        System.out.println(Arrays.toString(nums2));
        if(m==0&&n>0){

            Arrays.sort(nums2);
            nums1=nums2;
            return nums1;
        }else if(m>0&n==0){
            Arrays.sort(nums1);
            return nums1;
        }else{
            // 새 배열 생성 (nums1와 nums2의 길이의 합)
            int[] result = Arrays.copyOf(nums1, nums1.length + nums2.length);

            // b 배열을 result 배열의 a.length 위치부터 복사
            System.arraycopy(nums2, 0, result, nums1.length, nums2.length);

            Arrays.sort(result);
            nums1=result;
            return nums1;
        }

        /*
        정답
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
        */
    }

    public static void main(String args[]) {
/*
Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

*/

        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int m=3;
        int n=3;
/*
    int[] nums1={1};
    int[] nums2={};
    int m=1;
    int n=0;

    int[] nums1={0};
    int[] nums2={1};
    int m=0;
    int n=1;*/
        int[] result = merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(result));

    }

}
