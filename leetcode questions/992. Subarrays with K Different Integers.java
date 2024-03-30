/******************************************************************************

Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

*******************************************************************************/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostK(nums,k)-atmostK(nums,k-1);
    }
    private int atmostK(int[]nums,int k){
        int start =0,ans=0;
        Map<Integer , Integer>map=new HashMap<>();
        for(int end=0;end<nums.length;end++){
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            while(map.size()>k){
                if(map.get(nums[start])>1){
                    map.put(nums[start],map.get(nums[start])-1);
                }else{
                    map.remove(nums[start]);
                }
                start++;
            }
            ans+=(end-start+1);
        }
        return ans;
        }
}