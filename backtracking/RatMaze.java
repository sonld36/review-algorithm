package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {
    private static List<String> result = new ArrayList<>();

    private static boolean canMoveRight(int[][] m, int row, int col, List<String> path) {
        boolean check = path.size() > 0 ? path.get(path.size() - 1) != "L" : true;
        if (col < m[row].length - 1 && m[row][col + 1] != 0 && check) {
            return true;
        }
        return false;
    }

    private static boolean canMoveLeft(int[][] m, int row, int col, List<String> path) {
        boolean check = path.size() > 0 ? path.get(path.size() - 1) != "R" : true;
        if (col > 0 && m[row][col - 1] != 0 && check) {
            return true;
        }
        return false;
    }
    private static boolean canMoveDown(int[][] m, int row, int col, List<String> path) {
        boolean check = path.size() > 0 ? path.get(path.size() - 1) != "U" : true;
        if (row < m.length - 1 && m[row + 1][col] != 0 && check) {
            return true;
        }
        return false;
    }

    private static void ratMaze(int[][] matrix, List<String> path, int row, int col, int N) {
        if (row == N - 1 && col == N - 1) {
            result.add(String.join("", path));
            return;
        }

        if (canMoveLeft(matrix, row, col, path)) {
            path.add("L");
            ratMaze(matrix, path, row, col - 1, N);
            path.remove(path.size() - 1);
        }
        if (canMoveRight(matrix, row, col, path)) {
            path.add("R");
            ratMaze(matrix, path, row, col + 1, N);
            path.remove(path.size() - 1);
        }
        if (canMoveDown(matrix, row, col, path)) {
            path.add("D");
            ratMaze(matrix, path, row + 1, col, N);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        int N = 4;
        int m[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        List<String> pathInit = new ArrayList<>();
        ratMaze(m, pathInit, 0, 0, N);

        System.out.println("number of solutions: " + result.size());
        result.forEach(System.out::println);
    }
}
