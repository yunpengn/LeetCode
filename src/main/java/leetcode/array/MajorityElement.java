package leetcode.array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;

        for (int current: nums) {
            if (count == 0) {
                majority = current;
                count++;
            } else if (current == majority) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}
