package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Valid Sudoku
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Example 2:
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * [[".",".",".",".","5",".",".","1","."],
 * [".","4",".","3",".",".",".",".","."],
 * [".",".",".",".",".","3",".",".","1"],
 * ["8",".",".",".",".",".",".","2","."],
 * [".",".","2",".","7",".",".",".","."],
 * [".","1","5",".",".",".",".",".","."],
 * [".",".",".",".",".","2",".",".","."],
 * [".","2",".","9",".",".",".",".","."],
 * [".",".","4",".",".",".",".",".","."]]
 */
public class Sudoku {
    public static void main(String[] args) {
        char[][] it = { {'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','1'},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}};
//        System.out.println(isValidSudoku(it));
        createSubs(it);
    }

    static boolean isValidSudoku(char[][] board) {
        return checkSideways(board) && checkDownward(board);
    }

    static void createSubs(char[][] board) {
        char[] sub = {0,0,0,0,0,0,0,0,0};

        int subBIndex = 0;
        int srcPos = 0;
        int count2 = 0;

//
//        while (count2 < 3) {
//            int desPos = 0;
//            for (subBIndex =0; subBIndex < 3; subBIndex++) {
//                System.arraycopy(board[subBIndex], srcPos, sub, desPos, 3);
//                desPos+=3;
//            }
//            srcPos+=3;
//            count2++;
//
//            System.out.println(sub);
//
//        }


        while (count2 < 3) {
            int desPos = 0;
            for (subBIndex =0; subBIndex < 3; subBIndex++) {
                System.arraycopy(board[subBIndex], srcPos, sub, desPos, 3);
                desPos+=3;
            }
            srcPos+=3;
            count2++;

            System.out.println(sub);

        }
    }

    static boolean checkSideways(char[][] board) {
        for (char[] chars : board) {
            if (!hasUniqueElements(chars)) {
                return false;
            }
        }
        return true;
    }


    static boolean checkDownward(char[][] board) {
        for (int i =0; i < board[0].length; i++) {
            Set<Character> set = new HashSet<>();
            for (char[] chars : board) {
                if (!set.add(chars[i]) && chars[i] != '.') {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean hasUniqueElements(char[] chars) {
        Set<Character> set = new HashSet<>();
        for (Character c : chars) {
            if (!set.add(c) && c != '.') {
                return false;
            }
        }
        return true;
    }
}
