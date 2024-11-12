  //给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2277 👎 0

  
  package com.Iiqian.leetcode.editor.cn;
  public class MinimumSizeSubarraySum{
      public static void main(String[] args) {
           Solution solution = new MinimumSizeSubarraySum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        //idea刷leetcode的感觉真不错啊

//        int[] presum = new int[nums.length+1];
//        for(int i=0;i<nums.length;i++){
//            if(nums[i] >= target) return 1;
//            presum[i+1] = presum[i] + nums[i];
//        }
//        if(presum[nums.length] < target) return 0;
//        int ans = 2;
//        while(ans <= nums.length){
//            for(int i=0;i+ans <= nums.length;i++){
//                if(presum[i+ans] - presum[i] >= target){
//                    return ans;
//                }
//            }
//            ans++;
//        }
//        return ans;

        //前缀和直接超时   不过也确实是n^2
        //还是双指针吧

        int l = 0;
        int r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;


        while(r < nums.length){
            sum += nums[r++];
            while(sum >= target){
                sum -= nums[l++];
                min = Math.min(r-l+1,min);
            }
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }