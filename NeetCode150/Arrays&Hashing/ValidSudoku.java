import java.util.ArrayList;
import java.util.List;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int len = 9;
        List<List<Character>> rowList = new ArrayList<>(len);
        List<List<Character>> columnList = new ArrayList<>(len);
        List<List<Character>> boxList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            rowList.add(new ArrayList<>());
            columnList.add(new ArrayList<>());
            boxList.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                char c = board[i][j];
                if(c != '.') {
                    if(rowList.get(i).contains(c)) return false;
                    if(columnList.get(j).contains(c)) return false;
                    int box = findBoxNumber(i, j);
                    if(boxList.get(box).contains(c)) return false;
                    rowList.get(i).add(c);
                    columnList.get(j).add(c);
                    boxList.get(box).add(c);
                }
            }
        }
        return true;
    }

    private int findBoxNumber(int row, int col) {
        int boxSize = 3;
        int boxRow = row / boxSize;
        int boxCol = col / boxSize;
        return boxRow * boxSize + boxCol;
    }

    public static void main(String... args) {
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(new char[][]{
            {'.','.','.','.','5','.','.','1','.'},
            {'.','4','.','3','.','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','1'},
            {'8','.','.','.','.','.','.','2','.'},
            {'.','.','2','.','7','.','.','.','.'},
            {'.','1','5','.','.','.','.','.','.'},
            {'.','.','.','.','.','2','.','.','.'},
            {'.','2','.','9','.','.','.','.','.'},
            {'.','.','4','.','.','.','.','.','.'}
        }));
    }
}