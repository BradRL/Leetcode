import java.util.*;

/**
 * My solution today's daily Leetcode problem (06/12/2024)
 * Difficulty: Medium
 * Runtime: 29ms | Beats 84.24%
 * Memory 45.22MB | Beats 98.18%
 * (Class will need renaming to "Solution" to run in Leetcode)
 */
public class Leetcode2554 {
    /**
     * finds the maximum number of integers that can be selected from a range of 1-n that are NOT
     * present in the list of banned numbers AND have a sum which is less than maxSum
     * @param banned A basic list of banned numbers that cannot be chosen
     * @param n the upper bound for the range of numbers to select from
     * @param maxSum the maximum value for what the selected numbers can total to
     * @return the maximum number of integers found
     */
    public int maxCount(int[] banned, int n, int maxSum) {
        // creates a set of all banned numbers making it more efficient to see if a value is banned
        HashSet<Integer> lookup = new HashSet<>(10001);
        for (int bannedNo : banned) {
            lookup.add(bannedNo);
        }

        int sum = 0;
        int count = 0;

        // iterates though the given range, incrementing the count given that the current
        // number is not present in the banned list and does not cause the sum to go over the limit
        for (int i = 1; i <= n; i++) {
            if (! lookup.contains(i)) {
                sum += i;
                if (sum > maxSum) {
                    break;
                }
                count++;
            } 
        }
        return count;
    }
}

