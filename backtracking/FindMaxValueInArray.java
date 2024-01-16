package backtracking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMaxValueInArray {

    // private static BigDecimal maxValue = BigDecimal.ZERO;
    // private static List<BigDecimal> maxList = new ArrayList<>();

    // public static List<BigDecimal> findMaxUnderTarget(List<BigDecimal> nums,
    // BigDecimal target) {
    // Collections.sort(nums, Comparator.reverseOrder());
    // BigDecimal totalSum = nums.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

    // search(nums, target, 0, BigDecimal.ZERO, new ArrayList<>(), totalSum);

    // return maxList;
    // }

    // private static void search(List<BigDecimal> nums, BigDecimal target, int
    // start, BigDecimal currentSum,
    // List<BigDecimal> currentList, BigDecimal remaining) {
    // if (currentSum.compareTo(target) <= 0 && currentSum.compareTo(maxValue) > 0)
    // {
    // maxValue = currentSum;
    // maxList = new ArrayList<>(currentList);
    // }
    // if (start < nums.size()) {
    // BigDecimal num = nums.get(start);
    // if (currentSum.add(num).compareTo(target) <= 0) {
    // currentList.add(num);
    // search(nums, target, start + 1, currentSum.add(num), currentList,
    // remaining.subtract(num));
    // currentList.remove(currentList.size() - 1);
    // }
    // if (currentSum.add(remaining.subtract(num)).compareTo(maxValue) > 0) {
    // search(nums, target, start + 1, currentSum, currentList,
    // remaining.subtract(num));
    // }
    // }
    // }

    private static BigDecimal maxValue = BigDecimal.ZERO;
    private static List<BigDecimal> maxList = new ArrayList<>();
    private static Map<String, BigDecimal> memo = new HashMap<>();

    public static List<BigDecimal> findMaxUnderTarget(List<BigDecimal> nums, BigDecimal target) {
        Collections.sort(nums, Comparator.reverseOrder());
        BigDecimal totalSum = nums.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        search(nums, target, 0, BigDecimal.ZERO, new ArrayList<>(), totalSum);

        return maxList;
    }

    private static void search(List<BigDecimal> nums, BigDecimal target, int start, BigDecimal currentSum,
            List<BigDecimal> currentList, BigDecimal remaining) {
        String key = start + "|" + currentSum;
        if (memo.containsKey(key)) {
            return;
        }

        if (currentSum.compareTo(target) <= 0 && currentSum.compareTo(maxValue) > 0) {
            maxValue = currentSum;
            maxList = new ArrayList<>(currentList);
        }

        if (start < nums.size()) {
            BigDecimal num = nums.get(start);
            if (currentSum.add(num).compareTo(target) <= 0) {
                currentList.add(num);
                search(nums, target, start + 1, currentSum.add(num), currentList,
                        remaining.subtract(num));
                currentList.remove(currentList.size() - 1);
            }
            if (currentSum.add(remaining.subtract(num)).compareTo(maxValue) > 0) {
                search(nums, target, start + 1, currentSum, currentList,
                        remaining.subtract(num));
            }
        }

        memo.put(key, maxValue);
    }

    public static void main(String[] args) {
        List<BigDecimal> arr = Arrays.asList(
                new BigDecimal(10_000),
                new BigDecimal(20_000),
                new BigDecimal(18_000),
                new BigDecimal(40_000),
                new BigDecimal(5_000),
                new BigDecimal(60_000),
                new BigDecimal(14000),
                new BigDecimal(80000),
                new BigDecimal(4000)
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(10_000),
        // new BigDecimal(20_000),
        // new BigDecimal(18_000),
        // new BigDecimal(40_000),
        // new BigDecimal(5_000),
        // new BigDecimal(60_000),
        // new BigDecimal(14000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(10_000),
        // new BigDecimal(20_000),
        // new BigDecimal(18_000),
        // new BigDecimal(40_000),
        // new BigDecimal(5_000),
        // new BigDecimal(60_000),
        // new BigDecimal(14000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(10_000),
        // new BigDecimal(20_000),
        // new BigDecimal(18_000),
        // new BigDecimal(40_000),
        // new BigDecimal(5_000),
        // new BigDecimal(60_000),
        // new BigDecimal(14000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(10_000),
        // new BigDecimal(20_000),
        // new BigDecimal(18_000),
        // new BigDecimal(40_000),
        // new BigDecimal(5_000),
        // new BigDecimal(60_000),
        // new BigDecimal(14000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(10_000),
        // new BigDecimal(20_000),
        // new BigDecimal(18_000),
        // new BigDecimal(40_000),
        // new BigDecimal(5_000),
        // new BigDecimal(60_000),
        // new BigDecimal(14000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000),
        // new BigDecimal(80000),
        // new BigDecimal(4000),
        // new BigDecimal(85000),
        // new BigDecimal(43000),
        // new BigDecimal(21000),
        // new BigDecimal(23000),
        // new BigDecimal(140000),
        // new BigDecimal(6000),
        // new BigDecimal(23000));
        );
        BigDecimal order = new BigDecimal(250000);
        System.out.println("total of array: " + arr.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
        var result = findMaxUnderTarget(arr, order);
        System.out.println(result);
        System.out.println("size: " + result.size());
        System.out.println(result.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
