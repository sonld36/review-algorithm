package backtracking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Node
 */
class Node {
    int level;
    BigDecimal value;
    BigDecimal bound;
    Node parent;
    BigDecimal elementAdded;

    Node(int level, BigDecimal value, Node parent) {
        this.level = level;
        this.value = value;
        this.parent = parent;
    }
}

public class FindMaxValueInArray2 {

    static BigDecimal bound(Node u, int n, BigDecimal target, List<BigDecimal> arr) {
        if (u.value.compareTo(target) >= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal valueBound = u.value;
        int j = u.level + 1;

        while (j < n) {
            if (valueBound.add(arr.get(j)).compareTo(target) <= 0) {
                valueBound = valueBound.add(arr.get(j));
            }

            j++;
        }
        return valueBound;
    }

    public static Node findMaxUnderTarget(BigDecimal target, List<BigDecimal> arr, int n) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(
                (a, b) -> b.value.compareTo(a.value));

        Node u, v;

        u = new Node(-1, new BigDecimal(0), null);

        priorityQueue.offer(u);

        Node maxProfit = new Node(-1, BigDecimal.ZERO, null);
        while (!priorityQueue.isEmpty()) {
            u = priorityQueue.poll();
            if (u.level == -1) {
                v = new Node(0, BigDecimal.ZERO, u);

            } else if (u.level == n - 1)
                continue;
            else
                v = new Node(u.level + 1, u.value, u);

            v.value = v.value.add(arr.get(v.level));
            v.elementAdded = arr.get(v.level);

            if (v.value.compareTo(maxProfit.value) > 0 && v.value.compareTo(target) <= 0) {
                maxProfit = v;
                if (maxProfit.value.compareTo(target) == 0) {
                    return maxProfit;
                }
            }

            v.bound = bound(v, n, target, arr);

            if (v.bound.compareTo(maxProfit.value) > 0) {
                priorityQueue.offer(v);
            }

            v = new Node(u.level + 1, u.value, u);
            v.bound = bound(v, n, target, arr);

            if (v.bound.compareTo(maxProfit.value) > 0) {
                priorityQueue.offer(v);
            }
        }

        return maxProfit;
    }

    public static List<Node> getBestPath(Node bestNode) {
        List<Node> path = new ArrayList<>();
        Node currentNode = bestNode;
        while (currentNode != null) {
            path.add(currentNode);
            currentNode = currentNode.parent;
        }
        Collections.reverse(path); // Reverse the path so it goes from root to best node
        return path;
    }

    public static void main(String[] args) {
        List<BigDecimal> arr = Arrays.asList(
                new BigDecimal(150_000),

                new BigDecimal(7000),
                new BigDecimal(6000),
                new BigDecimal(820),
                new BigDecimal(1)
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
        // new BigDecimal(23000)
        );
        // arr = arr.stream().map((item) -> {
        // Random rand = new Random();
        // return item.add(new BigDecimal(rand.nextInt(1000)));
        // }).toList();
        List<BigDecimal> newArrDesc = new ArrayList<>(arr);
        newArrDesc.sort(Comparator.reverseOrder());
        BigDecimal order = new BigDecimal(156821);
        System.out.println("total of array: " + newArrDesc.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
        var resultDesc = findMaxUnderTarget(order, newArrDesc, newArrDesc.size());
        System.out.println(resultDesc.value);
        var bestPath = getBestPath(resultDesc);
        for (Node item : bestPath) {
            System.out.println(item.elementAdded);
        }

        // List<BigDecimal> newArrAsc = new ArrayList<>(arr);
        // newArrAsc.sort(Comparator.naturalOrder());
        // ;
        // System.out.println("total of array: " +
        // newArrAsc.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
        // var resultAsc = findMaxUnderTarget(order, newArrAsc, newArrAsc.size());
        // System.out.println(resultAsc);
        // System.out.println("size: " + result.size());
        // System.out.println(result.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
