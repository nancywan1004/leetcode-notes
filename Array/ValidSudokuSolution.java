// 36. Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:
// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidSudokuSolution {
    // HashMap(or HashSet) for each row and column to check duplicates
    // HashMap for the 3x3 grids inside the 9x9 grid 
    public boolean isValidSudoku(char[][] board) {
        Map<String, HashSet<Character>> columns = new HashMap<>();
        Map<String, HashSet<Character>> rows = new HashMap<>();
        Map<String, HashSet<Character>> squares = new HashMap<>(); // key = (r/3, c/3)

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                char currentChar = board[r][c];
                String squareKey = "(" + r / 3 + "," + c / 3 + ")";
                if (columns.containsKey(String.valueOf(c)) && columns.get(String.valueOf(c)).contains(currentChar) || rows.containsKey(String.valueOf(r)) && rows.get(String.valueOf(r)).contains(currentChar) || squares.containsKey(squareKey) && squares.get(squareKey).contains(currentChar)) {
                    return false;
                }

                // use computeIfAbsent instead of putIfAbsent to compute a new value for the specified key using a provided mapping function if the key is not already present in the map.
                columns.computeIfAbsent(String.valueOf(c), k -> new HashSet<>()).add(board[r][c]);
                rows.computeIfAbsent(String.valueOf(r), k -> new HashSet<>()).add(board[r][c]);
                squares.computeIfAbsent("(" + r / 3 + "," + c / 3 + ")", k -> new HashSet<>()).add(board[r][c]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudokuBoard = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        ValidSudokuSolution validator = new ValidSudokuSolution();
        System.out.println("Is the Sudoku board valid? " + validator.isValidSudoku(sudokuBoard));
    }
}
