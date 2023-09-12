import java.util.*;
import java.util.Map;

public class Array {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * No.1 Two Sum
     * <a href="https://leetcode.com/problems/two-sum/description/">link</a>
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(resultMap.containsKey(target-curr)){
                return new int[]{resultMap.get(target-curr), i};
            }
            resultMap.put(curr, i);
        }
        return new int[]{0, 0};
    }

    /**
     * No.3 Longest Substring Without Repeating Characters
     * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">link</a>
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> appearance = new HashMap<>();
        int maxLen = 0;
        int startIdx = 0;
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if (appearance.containsKey(c) && appearance.get(c) >= startIdx){
                Integer idx = appearance.get(c);
                startIdx = idx+1;
            }
            appearance.put(c, i);
            maxLen = Math.max(i-startIdx+1, maxLen);
        }
        return maxLen;
    }
}
