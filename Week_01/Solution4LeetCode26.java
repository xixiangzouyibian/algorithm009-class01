import java.util.Arrays;

// [0,0,0,0,1,1]
public class Solution4LeetCode26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int needToCompared = nums[0];
        int comparedTimes = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == needToCompared) {
                continue;
            } else {
                //replace nums[i] to i - cursor index
                nums[comparedTimes++] = nums[i];
                needToCompared = nums[i];
            }
        }
        return comparedTimes;
    }
}
