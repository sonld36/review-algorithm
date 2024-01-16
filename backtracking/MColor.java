package backtracking;

import java.util.Arrays;

public class MColor {
    private static int[] colors;

    public static void show() {
        for (int i = 0; i < colors.length; i++) {
            System.out.print(colors[i] + " ");
        }
    }

    public static boolean mColor(int[][] graph, int M, int row, int n) {
        if (row == n) {
            show();
            return true;
        }

        for (int i = 1; i <= M; i++) {
            if (check(graph, row, i)) {
                colors[row] = i;
                var valid = mColor(graph, M, row + 1, n);
                if (valid) {
                    return true;
                }
            }
            colors[row] = 0;
        }

        return false;
    }

    public static boolean check(int[][] graph, int row, int color) {
        int[] rowArray = graph[row];
        for (int i = 0; i < rowArray.length; i++) {
            if (rowArray[i] == 1 && colors[i] == color) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 }
        };
        int m = 3;
        colors = new int[graph.length];
        var res = mColor(graph, m, 0, graph.length);
        if (!res) {
            System.out.println("No solution");
        }
        // if (mColor(graph, m, 0, graph.length)) {
        // for (int i = 0; i < colors.length; i++) {
        // System.out.print(colors[i] + " ");
        // }
        // } else {
        // System.out.println("No solution");
        // }
    }
}
