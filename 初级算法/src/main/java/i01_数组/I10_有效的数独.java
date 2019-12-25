package i01_数组;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * @Title: I10_有效的数独.java
 * @description: TODO
 * @time: 2019/12/25 10:23
 * @author: liyongda
 * @version: 1.0
 * 有效的数独
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
 * src/main/resources/I10_有效的数独.svg.png
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 示例 1:
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class I10_有效的数独 {

    public static void main(String[] args) throws Exception {
        String str = "[[\".\",\".\",\".\",\".\",\"5\",\".\",\".\",\"1\",\".\"],[\".\",\"4\",\".\",\"3\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\"3\",\".\",\".\",\"1\"],[\"8\",\".\",\".\",\".\",\".\",\".\",\".\",\"2\",\".\"],[\".\",\".\",\"2\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\".\",\"1\",\"5\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\"],[\".\",\"2\",\".\",\"9\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\"4\",\".\",\".\",\".\",\".\",\".\",\".\"]]";
        ObjectMapper mapper = new ObjectMapper();
        List<List<String>> list = mapper.readValue(str, List.class);
        char[][] board = new char[9][9];
        for (int i = 0; i < board.length; i++) {
            List<String> strings = list.get(i);
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = strings.get(j).charAt(0);
            }
        }
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        for (int i = 0; i < 9; i++) {
            // 行判断
            for (int j = 0; j < 9; j++) {
                int position = board[i][j] - 49; // 49 ASCII: 1
                if (position < 0) // 46 ASCII: .
                    continue;
                if (row[position] == 0) {
                    row[position]++;
                } else {
                    return false;
                }
            }
            // 列判断
            for (int j = 0; j < 9; j++) {
                int position = board[j][i] - 49;
                if (position < 0)
                    continue;
                if (col[position] == 0) {
                    col[position]++;
                } else {
                    return false;
                }
            }
            for (int j = 0; j < 9; j++) {
                row[j] = 0;
                col[j] = 0;
            }
        }
        // 3x3 宫格判断
        for (int k = 0; k < 3; k++) { // 每一小块
            for (int m = 0; m < 3; m++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int position = board[(k * 3) + i][(m * 3) + j] - 49;
                        if (position < 0)
                            continue;
                        if (row[position] == 0) {
                            row[position]++;
                        } else {
                            return false;
                        }
                    }
                }
                for (int j = 0; j < 9; j++) {
                    row[j] = 0;
                }
            }
        }
        return true;
    }
}
