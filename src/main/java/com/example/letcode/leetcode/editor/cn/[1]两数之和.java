
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int a = 0;
        int b = nums.length-1;
        while (a<b) {
            int sum = nums[a]+nums[b];
            if(sum<target) {
                a++;
            }
            if(sum>target) {
                b--;
            }

            if(sum == target) {
                return new int[]{a,b};
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
