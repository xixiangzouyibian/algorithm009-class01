import java.util.Arrays;

//[1,2,3,4,5,6,7] k =3 -> [5,6,7,1,2,3,4]
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

    // 1 will move to nums[k]
    // temp = nums[k], curIndex = k
    // 4 will move to nums[length - 1]
    public static void rotate2(int[] nums, int k) {
        if (k <= 0 || nums.length == 0) {
            return;
        }
        int startIndex = 0;
        int curNum = nums[startIndex];
        int curIndex = startIndex;
        for (int swapTimes = 0; swapTimes < nums.length; swapTimes++) {
            int nextIndex = (curIndex + k) % nums.length;
            int tempNum = nums[nextIndex];
            nums[nextIndex] = curNum;
            curNum = tempNum;
            curIndex = nextIndex;
            if (startIndex == curIndex && ++startIndex < nums.length) { // avoid 2 nums swap casue endless loop
                curNum = nums[startIndex];
                curIndex = startIndex;
            }
        }
    }

    public static void rotate3(int[] nums, int k) {
        if (k <= 0) {
            return;
        }
        reverseArray(nums, 0, nums.length -1);
        k %= nums.length;
        reverseArray(nums, 0, k -1);
        reverseArray(nums, k, nums.length -1);
    }

    private static void reverseArray(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int [] nums2= {1,2,3,4,5,6,7};
        int [] num3= {1,2};
//        rotate(nums, 3);
//        System.out.println(Arrays.toString(nums));
        rotate2(num3, 2);
        System.out.println(Arrays.toString(num3));
    }
}
