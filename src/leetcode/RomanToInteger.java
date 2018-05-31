package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private static final Map<String, Integer> singleMap = initializeSingleMap();
    private static final Map<String, Integer> doubleMap = initializeDoubleMap();

    public int romanToInt(String s) {
        int currentIndex = 0;
        int length = s.length();
        int result = 0;

        String nextOne;
        String nextTwo;

        Integer nextOneValue;
        Integer nextTwoValue;

        while (currentIndex < length) {
            if (currentIndex < length - 1) {
                nextTwo = s.substring(currentIndex, currentIndex + 2);
                nextTwoValue = doubleMap.get(nextTwo);
                if (nextTwoValue != null) {
                    result += nextTwoValue;
                    currentIndex += 2;
                    continue;
                }
            }
            nextOne = s.substring(currentIndex, currentIndex + 1);
            nextOneValue = singleMap.get(nextOne);
            result += nextOneValue;
            currentIndex += 1;
        }

        return result;
    }

    private static Map<String, Integer> initializeSingleMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        return map;
    }

    private static Map<String, Integer> initializeDoubleMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        return map;
    }
}
