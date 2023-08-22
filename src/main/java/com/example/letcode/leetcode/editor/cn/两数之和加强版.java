package com.example.letcode.leetcode.editor.cn;

import com.azul.crs.client.service.ClientService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author lijiaxu
 * @Description
 * @date 2023/8/22 22:16
 */
 class Solution {

     public static List<List<Integer>> towSu(int[] nums, int target) {
         //首先排序
         Arrays.sort(nums);
         ArrayList<List<Integer>> result = new ArrayList<>();


         int a = 0;
         int b = nums.length-1;
         HashSet<Integer> set = new HashSet<>();
         while (a<b) {
             if(a<b && set.contains(nums[a])) {
                 a++;
             }
             if(a<b && set.contains(nums[b])) {
                 b--;
             }
             if (a<b ) {
                 if(nums[a]+nums[b] == target) {
                     List<Integer> integers = new ArrayList<>();
                     integers.add(nums[a]);
                     integers.add(nums[b]);
                     result.add(integers);

                     //把 a的数值存入 set
                     set.add(nums[a]);
                     set.add(nums[b]);
                 }
                 if(nums[a]+nums[b]<target) {
                     a++;
                 } else {
                     b--;
                 }


             }
         }

         return result;


     }

    public static void main(String[] args) {

        List<List<Integer>> lists = towSu(new int[]{1, 1, 2, 2, 3, 3}, 4);
        System.out.println(lists);
    }
}
