package dsa.arrays_strings.brute;

import java.util.ArrayList;
import java.util.List;

//228
//take a as num[0], then check a-num[], take counter for length of subsort,
// then num[i-counter] should equal a, if not put subsorted in list and then do a=num[i]"


public class SummaryRangesBrute {

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
        SummaryRangesBrute solution = new SummaryRangesBrute();

        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(solution.summaryRanges(nums1));
    }

}
