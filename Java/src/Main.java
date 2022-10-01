

public class Main {
    public static void main(String[] args) {
        String s = "arbcba";
        System.out.println(palindrome2(s, 0, s.length() - 1, 1));
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
