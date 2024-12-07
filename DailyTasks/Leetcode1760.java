import java.util.Arrays;

/**
 * My solution today's daily Leetcode problem (07/12/2024)
 * Difficulty: Medium
 * Runtime: 30ms | Beats 73.57%
 * Memory 59.98MB | Beats 76.32%
 * (Class will need renaming to "Solution" to run in Leetcode)
 */
public class Leetcode1760 {
    /**
     * You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.
     * You can perform the following operation at most maxOperations times:
     * Take any bag of balls and divide it into two new bags with a positive number of balls.
     * Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.
     * @param nums integer array nums where the ith bag contains nums[i] balls
     * @param maxOperations sets the value for the max ammount of operations permitted
     * @return the minimum possible penalty after performing the operations
     */
    public int minimumSize (int[] nums, int maxOperations) {
        int min = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        int minPenalty = max;

        while (min <= max) {
            int mid = (max + min) / 2;
            int ops = 0;

            for (int eachNum : nums) {
                ops += (eachNum - 1) / mid;
                if (ops > maxOperations) {
                    break;
                }
            }

            if (ops <= maxOperations) {
                max = mid - 1;
                minPenalty = mid;
            } else {
                min = mid + 1;
            }
        }
        return minPenalty;
    }
}
