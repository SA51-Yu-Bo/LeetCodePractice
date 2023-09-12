import java.util.*;

public class Main {
    public static void main(String[] args) {
    }
    public static int[] solution(int[] A, int F, int M) {
        // Implement your solution here
        int totalLength = A.length + F;
        int sum = totalLength*M;
        int currentSum = 0;
        for (int i : A)
            currentSum += i;
        int gap = sum - currentSum;
        if (gap < F || gap > 6*F) return new int[]{0};
        int[] result = new int[F];
        Arrays.fill(result, 0);
        int i = 0;
        for (int time = 0; time < gap; ++time){
            result[i] += 1;
            i = (i+1) % F;
        }
        return result;
    }
    public static String solution1(int N) {
        // Implement your solution here
        int maxFactor = 1;
        for (int i = 2; i <= 26; ++i){
            if (N % i == 0)
                maxFactor = i;
        }
        int times = N / maxFactor;
        StringBuilder result = new StringBuilder();
        char base = 'a';
        for (int i = 0; i < maxFactor; ++i){
            char curr = (char) (base + i);
            for (int p = 0; p < times; ++p){
                result.append(curr);
            }
        }
        return result.toString();
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int p1 = 0;
        int p2 = 0;
        int max = 0;
        for(; p2 < s.length(); ++p2){
            char c = s.charAt(p2);
            if(map.containsKey(c)){
                Integer idx = map.get(c);
                for(; p1 <= idx; ++p1){
                    map.remove(s.charAt(p1));
                }
            }
            map.put(c, p2);
            max = Math.max(max, p2-p1+1);
        }
        return max;
    }
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1 != null || l2 != null || carry != 0){
            int v1 = 0, v2 = 0;
            v1 = l1 == null? 0: l1.val;
            v2 = l2 == null? 0: l2.val;
            p.next = new ListNode((v1+v2+carry)%10);
            p = p.next;
            carry = (v1+v2+carry)/10;
            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
        }
        return dummy.next;
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            int remain = target-nums[i];
            if(!map.containsKey(nums[i])){
                map.put(remain, i);
            }
            else{
                return new int[]{map.get(nums[i]), i};
            }
        }
        return new int[]{};
    }
    /**
     *
     * @param s the string that need to be judged if it is palindrome
     * @param start the start index of string
     * @param end the end index of string
     * @param remain the remaining times of delete characters
     * @return true if s is palindrome with remain times of delete characters opportunities.
     */

    public static boolean palindrome(String s, int start, int end, int remain){
        if(s == null || s.length() == 0) return true;
        if(start >= end) return true;       //递归写退出条件

        if(s.charAt(start) == s.charAt(end)){
            return palindrome(s, start + 1, end - 1, remain);
        }
        else if(remain > 0){
            return palindrome(s, start+1, end, remain-1) || palindrome(s, start, end-1, remain-1);
        }
        else {
            return false;
        }
    }
    public static boolean palindrome2(String s, int start, int end, int remain){
        if(s == null || s.length() == 0) return true;
        if(start >= end) return true;       //递归写退出条件

        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
               if(remain <= 0) return false;
               return palindrome2(s, start+1, end, remain-1) || palindrome2(s, start, end-1, remain-1);
            }
            start++;
            end--;
        }
        return true;
    }
    /**
     * return the last element in array that is less or equal to target, array is a sorted int collection
     * @param array array that is applied to binary search, array must be ascending
     * @param target search element
     * @return the index of last element that less or equal to target, -1 if all element greater than target
     */
    public static int binSearch(int[] array, int target){
        if(array.length == 0) return -1;
        int start = 0, end = array.length;
        while(start < end){
            int mid = (start + end) >> 1;
            if(array[mid] <= target){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return end-1;
    }
    /**
     * return the first element in array that is greater or equal to target, array is a sorted int collection
     * @param array array that is applied to binary search, array must be ascending
     * @param target search element
     * @return the index of first element that greater or equal to target, return array's length if all element less than target
     */
    public static int binSearch2(int[] array, int target){
        if(array.length == 0) return -1;
        int start = 0, end = array.length;
        while(start < end){
            int mid = (start + end) >> 1;
            if(array[mid] >= target){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }
}
