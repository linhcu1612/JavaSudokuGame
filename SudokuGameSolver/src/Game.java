import java.util.HashMap;

public class Game {
    private int size;
    private String difMode;

    public Game() {
        this.size = 9;
        this.difMode = "hard";
    }

    public void ChooseDiff(String x) {
        HashMap<String, Integer> linh = new HashMap<String, Integer>();
        linh.put("hard", 9);
        linh.put("medium", 6);
        linh.put("easy",4);

        if (linh.containsKey(x)) {
            this.size = linh.get(x);
        } else {
            System.out.println("There are 3 modes of this game : hard, medium and easy");
        }
    }

    public boolean isAvailable(int[][] sudoku,int row, int col, int num) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == num) {
                return false;
            }
        }

        for (int k = 0; k < sudoku.length; k++) {
            if (sudoku[k][col] == num) {
                return false;
            }
        }

        int box = (int) Math.sqrt(sudoku.length);
        int startRowBox = row - row % box;
        int startColBox = col - col % box;

        for (int j = startColBox;j < startColBox + box; j++) {
            for (int l = startRowBox; l < startRowBox + box; l++) {
                if (sudoku[l][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solvedSudoku(int[][] sudoku) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= sudoku.length; num++) {
            if (isAvailable(sudoku,row,col,num)){
                sudoku[row][col] = num;
                if (solvedSudoku(sudoku)) {
                    return true;
                } else {
                    sudoku[row][col] = 0;
                }
            }
        }

        return false;
    }

    public int[][] randSudoku(){
        int[][] sudoku = new int[this.size][this.size];
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                sudoku[i][j] = 0;
            }
        }

        int randomNumber = (int) (Math.random() * (this.size - 1) + 1);
        for (int i = 0; i < sudoku. length; i++) {
            if (isAvailable(sudoku,0,i,randomNumber)) {
                sudoku[0][i] = randomNumber;
            }
        }

        for (int i = 1; i < (int) Math.sqrt(sudoku.length); i++) {
            for (int j = 0; j < (int) Math.sqrt(sudoku.length); j++) {
                if (isAvailable(sudoku,i,j,randomNumber)) {
                    sudoku[i][j] = randomNumber;
                }
            }
        }

        return sudoku;
    }

    public int[][] generateSudoku(int[][] sudoku) {
        int[][] generatedSudoku = sudoku;
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                double random = Math.random() * 2;
                if (random < 1) {
                    generatedSudoku[i][j] = 0;
                }
            }
        }
        return generatedSudoku;
    }
}
