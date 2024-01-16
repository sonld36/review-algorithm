public class Sudoku {
    private static final int N = 9;

    private static boolean isSafe(int value, int[][] grid, int row, int column) {
        for (int i = 0; i < N; i++) {
            if (grid[row][i] == value) {
                return false;
            }

            if (grid[i][column] == value) {
                return false;
            }
        }
        ;

        int startRow = row - row % 3, startCol = column - column % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == value) {
                    return false;
                }

        return true;
    }

    private static boolean solveSudoku(int grid[][], int row, int column) {
        if (row == N - 1 && column == N) {
            return true;
        }

        if (column == N) {
            row++;
            column = 0;
        }

        if (grid[row][column] != 0) {
            return solveSudoku(grid, row, column + 1);
        }

        for (int val = 1; val <= N; val++) {
            if (isSafe(val, grid, row, column)) {
                grid[row][column] = val;

                var result = solveSudoku(grid, row, column + 1);
                if (result) {
                    return result;
                }
            }

            grid[row][column] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        var result = solveSudoku(grid, 0, 0);
        System.out.println(result);
    }
}
