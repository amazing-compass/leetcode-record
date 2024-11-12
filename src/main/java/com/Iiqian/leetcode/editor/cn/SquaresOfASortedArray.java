  //给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 1056 👎 0

  
  package com.Iiqian.leetcode.editor.cn;
  public class SquaresOfASortedArray{
      public static void main(String[] args) {
           Solution solution = new SquaresOfASortedArray().new Solution();
           int[] a = new int[]{-5,-3,-2,-1};
           solution.sortedSquares(a);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int[] sortedSquares(int[] nums) {
//
//        //设计时间复杂度为O(n)
//        if(nums.length == 1) return new int[]{nums[0]*nums[0]};
//
//        int[] ans = new int[nums.length];
//
//        int pointer = 0;
//
//        while(pointer != nums.length - 1 && Math.abs(nums[pointer]) >= Math.abs(nums[pointer+1])){
//            pointer++;
//        }
//
//        int l = pointer - 1;
//        int r = pointer + 1;
//
//        int p = 1;
//        ans[0] = nums[pointer] * nums[pointer];
//
//        while(l >=0 && r < nums.length){
//            if(Math.abs(nums[l]) <= Math.abs(nums[r])){
//                ans[p++] = nums[l] * nums[l];
//                l--;
//            }else{
//                ans[p++] = nums[r] * nums[r];
//                r++;
//            }
//        }
//
//        if(l < 0){
//            while(r < nums.length){
//                ans[p++] = nums[r] * nums[r];
//                r++;
//            }
//        }else{
//            while(l >= 0){
//                ans[p++] = nums[l] * nums[l];
//                l--;
//            }
//
//        }
//        return ans;
//    }
    public int[] sortedSquares(int[] nums)  {
        //
        //上面的解法写的有点抽象了，从数组的后端进行填充更符合直觉

        int[] ans = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int p = nums.length - 1;


        while(p >= 0){
            if(Math.abs(nums[l]) >= Math.abs(nums[r])){
                ans[p--] = nums[l] * nums[l];
                l++;
            }else{
                ans[p--] = nums[r] * nums[r];
                r--;
            }

        }
        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }