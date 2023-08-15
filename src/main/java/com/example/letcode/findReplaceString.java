package com.example.letcode;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author lijiaxu
 * @Description 字符串的查找与替换
 *你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,  targets。
 *
 * 要完成第 i 个替换操作:
 *
 * 检查 子字符串  sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。
 * 如果没有出现， 什么也不做 。
 * 如果出现，则用 targets[i] 替换 该子字符串。
 * 例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么替换的结果将是 "eeecd" 。
 *
 * 所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。
 *
 * 例如，一个 s = "abc" ，  indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 和 "bc" 替换重叠。
 * 在对 s 执行所有替换操作后返回 结果字符串 。
 *
 * 子字符串 是字符串中连续的字符序列。
 *
 *
 * @date 2023/8/15 20:57
 */
public class findReplaceString {

    public static void main(String[] args) {
        String s = "aaaccd";
        int [] indices = {1,3};
       String [] sources = new String[]{"aa", "f"};
       String [] targets = new String[] {"tttt","1"};
        String replaceString = findReplaceString(s, indices, sources, targets);
        System.out.println(replaceString);

    }


    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int[] order = IntStream.range(0, indices.length).boxed().sorted(Comparator.comparingInt(i -> indices[i]))
                .mapToInt(i -> i).toArray();
        StringBuilder sb = new StringBuilder();
        int preIndex = 0;
        for (int i : order) {
            int index = indices[i];
            sb.append(s, preIndex, index);
            if (s.startsWith(sources[i], index)) {
                sb.append(targets[i]);
                preIndex = index + sources[i].length();
            } else {
                preIndex = index;
            }
        }
        sb.append(s.substring(preIndex));
        return sb.toString();
    }
}
