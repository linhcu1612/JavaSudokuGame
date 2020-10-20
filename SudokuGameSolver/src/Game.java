import java.util.HashMap;
import java.util.Random;

public class Game {
    private int size;
    private String difMode;
    private String title;
    private int[][] sudoku;

    public Game() {
        this.size = 9;
        this.difMode = "hard";
        this.sudoku = new int[size][size];
        this.sudoku = generateSudoku();
    }

    public int[][] getSudoku() {
        return this.sudoku;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public void printSudoku() {
        System.out.println("Title: " + this.title);
        System.out.println("Difficult Mode : " + this.difMode);
        for (int i = 0; i < sudoku.length; i++) {
            if ( i == 0 || (i % Math.sqrt(sudoku.length) == 0)) {
                System.out.print(" ");
                for (int j = 0; j < sudoku.length+(Math.sqrt(sudoku.length) + 1); j++) {
                    System.out.print("- ");
                }
                System.out.println(" ");
            }
            for (int j = 0; j < sudoku.length; j++) {
                if (j == 0) {
                    System.out.print(" | " + sudoku[i][j] + " ");
                } else if (((j+1) % Math.sqrt(sudoku.length)) == 0 ) {
                    System.out.print(sudoku[i][j] + " | ");
                } else {
                    System.out.print(sudoku[i][j] + " ");
                }
            }
            System.out.println("");
        }
        System.out.print(" ");
        for (int j = 0; j < sudoku.length+(Math.sqrt(sudoku.length) + 1); j++) {
            System.out.print("- ");
        }
        System.out.println(" ");
    }

    public void ChooseDiff(String x) {
        HashMap<String, Integer> linh = new HashMap<String, Integer>();
        linh.put("hard", 9);
        linh.put("medium", 6);
        linh.put("easy",4);

        if (linh.containsKey(x)) {
            this.size = linh.get(x);
            this.difMode =  x;
        } else {
            System.out.println("There are only 3 modes of this game : hard, medium and easy");
        }
    }

    public boolean isAvailable(int row, int col, int num) {
        for (int i = 0; i < this.sudoku.length; i++) {
            if (this.sudoku[row][i] == num) {
                return false;
            }
        }

        for (int k = 0; k < this.sudoku.length; k++) {
            if (this.sudoku[k][col] == num) {
                return false;
            }
        }

        int box = (int) Math.sqrt(this.sudoku.length);
        int startRowBox = row - row % box;
        int startColBox = col - col % box;

        for (int j = startColBox;j < startColBox + box; j++) {
            for (int l = startRowBox; l < startRowBox + box; l++) {
                if (this.sudoku[l][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solvedSudoku() {
        this.title = "Solved Sudoku Set";
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (this.sudoku[i][j] == 0) {
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

        for (int num = 1; num <= this.sudoku.length; num++) {
            if (isAvailable(row,col,num)){
                this.sudoku[row][col] = num;
                if (solvedSudoku()) {
                    return true;
                } else {
                    this.sudoku[row][col] = 0;
                }
            }
        }

        return false;
    }

    public int[][] randSudoku(){
        this.title = "Generated Random Sudoku Set";

        Random rand = new Random();

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                int randomNumber = (int) ((Math.random() * (size - 1)) + 1);
                float random = rand.nextFloat();
                if (isAvailable(i,j,randomNumber) & random > 0.5) {
                    sudoku[i][j] = randomNumber;
                }
            }
        }
        return this.sudoku;
    }

    public int[][] generateSudoku() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                    sudoku[i][j] = 0;
            }
        }
        return sudoku;
    }
}
