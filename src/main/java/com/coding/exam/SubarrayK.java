package com.coding.exam;

import java.util.HashMap;
import java.util.Map;

public class SubarrayK {

    public static void main(String[] args) {
        int result = subarraySum(new int[]{1,1,1}, 2);
        System.out.println(result);
    }
    public static int subarraySum(int[] nums, int k) {
        int answer = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("sum=" + sum + ", nums[i]=" + nums[i] + ", sum - k=" +(sum - k));
            if (map.containsKey(sum - k)) {
                answer += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(map);
        return answer;
    }

}
