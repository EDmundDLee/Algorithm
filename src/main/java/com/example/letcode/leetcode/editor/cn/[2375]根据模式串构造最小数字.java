import java.util.ArrayList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestNumber(String pattern) {
        //需要构建的字符串长度
        int length = pattern.length();
        //创建一个降序数组
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int num = 1;
        for(int i = 0; i < length; i ++ ){
            //如果字符是D 则放入堆栈中
            if (pattern.charAt(i) =='D') {
                stack.push(num);
            } else if (pattern.charAt(i) == 'I'){
                result.append(num);
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
            num++;

        }

        stack.add(num);

        while (!stack.isEmpty()) { result.append(stack.pop()); }

        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
