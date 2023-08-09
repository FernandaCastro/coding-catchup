package com.fcastro.codility;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {

    public static void main(String[] args){
        var o = new TwoSum();

        System.out.println("[2,7,11,15] target:9 expected:[0,1]=> " + Arrays.toString(o.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("[3,2,4] target:6 expected:[1,2]=> " + Arrays.toString(o.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println("[3,3] target:6 expected:[0,1] => " + Arrays.toString(o.twoSum(new int[]{3,3}, 6)));
    }

    //Time complexity: O(n)
    //Space complexity: O(n)
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums.length; i++){

            int requiredNum = target - nums[i];
            if(indexMap.containsKey(requiredNum)){
                return new int[]{indexMap.get(requiredNum), i};
            }

            indexMap.put(nums[i], i);
        }
        return null;
    }
}
