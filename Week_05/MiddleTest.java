import java.util.*;

public class MiddleTest {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> records = new ArrayList<>();
        if (nums == null && nums.length < 4) return records;

        Arrays.sort(nums);
        for (int i=0; i < nums.length-3; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            for (int j=i+1; j < nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                if (nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                if (nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target) continue;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        records.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                        while (left < nums.length-1 && (nums[left] == nums[left-1])) left++;
                        while (right > left && (nums[right] == nums[right+1])) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return records;
    }

    public static void main(String[] args) {
//        int nums[] = {1, 0, -1, 0, -2, 2};
//        int target = 0;
//        int nums[] = {0,0,0,0};
//        int target = 1;
//        int nums[] = {-3,-2,-1,0,0,1,2,3};
//        int target = 0;
//        System.out.println(new MiddleTest().fourSum(nums, target));

        int num[][] = new int[4][4];
        System.out.println(num[1][1]);
    }
}
