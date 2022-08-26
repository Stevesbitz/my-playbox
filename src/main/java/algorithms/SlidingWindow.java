package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SlidingWindow {
    enum KycLevel {
        ZERO, ONE, TWO, THREE
    }
    public static void main(String[] args) {
//        System.out.println(UUID.randomUUID());
        KycLevel[] values = KycLevel.values();
        KycLevel highest = values[values.length-1];
//        System.out.println(highest.name());
        int[] data = {2,3,1,7,2,3,8};
        int[] data2 = {1, 3, 2, 6, -1, 4, 1, 8, 2};
//        maxSubArray(data, 3);
//        slidingWindow2(data2, 5);

//         int[] dt = {2, 1, 5, 2, 3, 2};
//         int s = 7;
//        System.out.println(smallestSubArrayGreaterThan(dt, s));

        String st ="araaci";
        int k=2;
        System.out.println(longestSubstringWithMaximumKDistinctCharacters(st, k));

//        Map<String,String> step = Map.of("errr", "null");
//        System.out.println(Objects.isNull(step.get("error")));
    }

    // Given a string, find the length of the longest substring in it
    // with no more than K distinct characters.
    static int longestSubstringWithMaximumKDistinctCharacters(String str, int k) {
        if (str == null || str.length() == 0)
            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }
        return maxLength;
    }

    static void maxSubArray(int[] data, int window) {
        int windowSum =0;
        int maxSum =0;
        int begin =0;
        for (int i=0; i < data.length; i++) {
            windowSum += data[i];

            if (i >= window-1) {
                System.out.println("windowSum "+windowSum);
                maxSum = Math.max(maxSum,windowSum);
                windowSum -= data[begin];
                System.out.println(maxSum);
                begin++;
            }
        }
        System.out.println("*******");
    }

    //Given an array of positive numbers and a positive number ‘S,’
    // find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
    // Return 0 if no such subarray exists.
    static int smallestSubArrayGreaterThan(int[] data, int number) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < data.length; windowEnd++) {
            windowSum += data[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= number) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= data[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return minLength;
    }

    // int firstSum = 0;
    //        List<Integer> result = new ArrayList<>();
    ////        List<Double> avResult = new ArrayList<>();
    //        List<Integer> max = new ArrayList<>();
    //        for (int i=0; i < window; i++) {
    //            firstSum += data[i];
    //        }
    ////        double av = firstSum/ (double)window;
    //        result.add(firstSum);
    //        max.add(firstSum);
    ////        avResult.add(av);
    //        int k=0;
    //        for (int j=window; j < data.length; j++) {
    //
    //
    //            int windowSum = firstSum + data[j] - data[k];
    //            result.add(windowSum);
    //            if (windowSum > firstSum){
    //                max.add(windowSum);
    //            }
    //
    //            firstSum = windowSum;
    ////            double avv = windowSum/ (double)window;
    ////            avResult.add(avv);
    //            k++;
    //        }
    //        System.out.println("sum of "+window+" sub elements--- "+result);
    ////        System.out.println(" max--- "+max);
    ////        System.out.println("average "+window+" sub elements--- "+avResult);
    //        System.out.println("max sum of "+window+" sub elements--- "+max.get(max.size()-1));
}

