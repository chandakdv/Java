/******************************************************************************

2962. Count Subarrays Where Max Element Appears at Least K Times
Medium

866

38

Add to List

Share
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.

 

Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
Example 2:

Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.

*******************************************************************************/
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        
        //max element
        int maxElement = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxElement = Math.max(maxElement,nums[i]);
        }
        int start =0;
        int end=0;
        long count=0;
        int maxElementFreqCount=0;
        while(end<n){
            //expanstion based
            if(nums[end]==maxElement){
                maxElementFreqCount++;
            }
            //shrinking
            while(maxElementFreqCount==k){
                count = count+(n-end);
                if(nums[start]==maxElement){
                    maxElementFreqCount--;
                }
                start++;
            }
            end++;
        }
        return count;
    }
}