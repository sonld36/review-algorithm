import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Queens
 */
public class Queens {
    private static int[] queens;
    private static int[] leftDiagonal;
    private static int[] rightDiagonal;

    private static boolean sameDiagonal(int r1, int c1, int r2, int c2) {
        return r1 + c1 == r2 + c2 || r1 - c1 == r2 - c2;
    }

    private static void show() {
        for (int i = 0; i < queens.length; i++) {
            System.out.println("row: " + i + " - column: " + queens[i]);
        }
        System.out.println("================");
    }

    private static boolean checkCondition(int row, int column) {
        if (queens[row] != -1) {
            return false;
        }

        for (int i = 0; i < queens.length; i++) {
            if (queens[i] == column) {
                return false;
            }

            if (queens[i] != -1 && sameDiagonal(i, queens[i], row, column)) {
                return false;
            }
        }

        return true;

    }

    private static void backtracking(int row, int column, int n) {
        if (row == n) {
            show();
            return;
        }

        if (column == n) {
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!checkCondition(row, col)) {
                continue;
            }

            queens[row] = col;
            backtracking(row + 1, col, n);
            queens[row] = -1;
        }
    }

    public static void main(String[] args) {
        int n = 8;
        queens = new int[n];
        leftDiagonal = new int[2 * n];
        rightDiagonal = new int[2 * n];

        // init board
        for (int i = 0; i < n; i++) {
            queens[i] = -1;
        }

        backtracking(0, 0, n);
    }
}