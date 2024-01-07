import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionStringLength {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left =0, right = 0;
        int res = 0;

        while (right<s.length()) {
            char c = s.charAt(right);
            right ++;
            //如果这个Map中有这个值窗口的value 就+1
            window.put(c,window.getOrDefault(c,0)+1);
           //大于1说明找到重复的值了
            while (window.get(c)>1) {
                char d = s.charAt(left);
                left++;
                window.put(d,window.getOrDefault(d,0)-1);

            }
            res = Math.max(res,right-left);


        }

        return  res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
