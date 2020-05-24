import java.util.Arrays;

public class Solution4LeetCode189 {

    public static void rotate(int[] nums, int k) {
        if (k <= 0) {
            return;
        }
        k %= nums.length;
        //first item = nums[nums.length-k]
        for (int i = k; i > 0; i--) {
            int selectedNum = nums[nums.length - i];
            int j = nums.length - i - 1;
            // move from k-i to j
            int bound = k-i;
            while (j>=bound) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[k-i] = selectedNum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
