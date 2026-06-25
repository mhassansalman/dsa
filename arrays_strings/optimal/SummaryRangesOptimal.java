package dsa.arrays_strings.optimal;

import java.util.ArrayList;
import java.util.List;

public class SummaryRangesOptimal {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                result.add(start == nums[i-1] ? String.valueOf(start) : start + "->" + nums[i-1]);
                start = nums[i];
            }
        }

        result.add(start == nums[nums.length-1] ? String.valueOf(start) : start + "->" + nums[nums.length-1]);
        return result;
    }
    public static void main(String[] args) {
        SummaryRangesOptimal solution = new SummaryRangesOptimal();

        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(solution.summaryRanges(nums1));
    }


}
/*Takeaways for Summary Ranges
1. Core Pattern

Track consecutive sequences in sorted array

Start new range when gap found (nums[i] != nums[i-1] + 1)

2)
Standard: Check nums[i] == nums[i-1] + 1

3. Time & Space

Time: O(n) - one pass through array

Space: O(1) - excluding output list

4. Edge Cases

Empty array → return empty list

Single element → return ["a"]

All consecutive → return ["a->b"]

No consecutive → return ["a", "b", "c"...]

5. Key Insight

You only need to track start of current range

Gap detection is the trigger to close a range

Always handle the last range after loop ends

6. Output Format

Single number: "a"

Range: "a->b"

7. Problem Pattern

Range compression - converting consecutive sequences into compact string representation

Common in data compression and log aggregation

*/