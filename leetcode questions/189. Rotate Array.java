/******************************************************************************

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*******************************************************************************/

// class Solution {
//     public void rotate(int[] nums, int k) {
//         for(int i = 1; i < k; i++) {
//             nums[i] = nums[i + k] % nums.length;
//         }
//     }
// }



class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        // Calculate the effective rotation
        k = k % n;
        // Copy elements to temp array
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        // Copy elements back to nums array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}

