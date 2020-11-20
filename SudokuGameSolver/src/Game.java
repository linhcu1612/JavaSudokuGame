import java.util.Random;

public class Game {

    Sudoku solvedSudoku;

    public Game(String difMode,int size,Sudoku sudoku) {
        solvedSudoku = new Sudoku();
        sudoku.ChooseDiff(difMode);
        sudoku.setSize(size);
    }

    public Game(String difMode,Sudoku sudoku) {
        solvedSudoku = new Sudoku();
        sudoku.ChooseDiff(difMode);
    }

    public void printSudoku(Sudoku sudoku) {
        System.out.println("Title: " + sudoku.getTitle());
        System.out.println("Difficult Mode : " + sudoku.getDiffMode());
        System.out.println("Status: " + sudoku.getStatus());
        for (int i = 0; i < sudoku.getSudoku().length; i++) {
            if ( i == 0 || (i % Math.sqrt(sudoku.getSudoku().length) == 0)) {
                System.out.print(" ");
                for (int j = 0; j < sudoku.getSudoku().length+(Math.sqrt(sudoku.getSudoku().length) + 1); j++) {
                    System.out.print("- ");
                }
                System.out.println(" ");
            }
            for (int j = 0; j < sudoku.getSudoku().length; j++) {
                if (j == 0) {
                    System.out.print(" | " + sudoku.getSudoku()[i][j].getValue() + " ");
                } else if (((j+1) % Math.sqrt(sudoku.getSudoku().length)) == 0 ) {
                    System.out.print(sudoku.getSudoku()[i][j].getValue() + " | ");
                } else {
                    System.out.print(sudoku.getSudoku()[i][j].getValue() + " ");
                }
            }
            System.out.println("");
        }
        System.out.print(" ");
        for (int j = 0; j < sudoku.getSudoku().length+(Math.sqrt(sudoku.getSudoku().length) + 1); j++) {
            System.out.print("- ");
        }
        System.out.println(" ");
    }

    public boolean isAvailable(Sudoku sudoku, int row, int col, int num) {
        for (int i = 0; i < sudoku.getSudoku().length; i++) {
            if (sudoku.getSudoku()[row][i].getValue() == num) {
                return false;
            }
        }

        for (int k = 0; k < sudoku.getSudoku().length; k++) {
            if (sudoku.getSudoku()[k][col].getValue() == num) {
                return false;
            }
        }

        int box = (int) Math.sqrt(sudoku.getSudoku().length);
        int startRowBox = row - row % box;
        int startColBox = col - col % box;

        for (int i = startColBox;i < startColBox + box; i++) {
            for (int j = startRowBox; j < startRowBox + box; j++) {
                if (sudoku.getSudoku()[j][i].getValue() == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solvedSudoku(Sudoku sudoku, int sleepTime) {
        sudoku.setTitle("Solved Sudoku Set");
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < sudoku.getSudoku().length; i++) {
            for (int j = 0; j < sudoku.getSudoku().length; j++) {
                if (sudoku.getSudoku()[i][j].getValue() == 0) {
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

        for (int num = 1; num <= sudoku.getSudoku().length; num++) {
            try {
                Thread.sleep(sleepTime);
                if (isAvailable(sudoku,row,col,num)){
                    sudoku.getSudoku()[row][col].setValue(num);
                    if (solvedSudoku(sudoku,sleepTime)) {
                        sudoku.setStatus("solved");
                        return true;
                    } else {
                        sudoku.getSudoku()[row][col].setValue(0);
                    }
                }
            }
            catch (Exception ex) {
                System.out.println("thread got interrupted");
            }
        }
        
        sudoku.setStatus("unsolved");
        return false;
    }

    public Sudoku randSudoku(Sudoku sudoku){
        Random rand = new Random();

        for (int i = 0; i < Math.sqrt(sudoku.getSudoku().length); i++) {
            for (int j = 0; j < sudoku.getSudoku().length; j++) {
                int randomNumber = (int) ((Math.random() * (sudoku.getSize() - 1)) + 1);
                float random = rand.nextFloat();
                if (isAvailable(sudoku,i,j,randomNumber) & random > 0.5) {
                    sudoku.getSudoku()[i][j].setValue(randomNumber);
                    solvedSudoku.getSudoku()[i][j].setValue(randomNumber);
                }
            }
        }

        solvedSudoku(sudoku,0);

        sudoku.setTitle("Generated Random Sudoku Set");
        sudoku.setStatus("new Sudoku Set");

        for (int i = 0; i < sudoku.getSudoku().length; i++) {
            for (int j = 0; j < sudoku.getSudoku().length; j++) {
                float random = rand.nextFloat();
                if (random > sudoku.getMode()) {
                    sudoku.getSudoku()[i][j].setValue(0);
                }
            }
        }

        return sudoku;
    }

    public Sudoku getSolvedSudoku() {
        solvedSudoku(solvedSudoku, 0);
        return this.solvedSudoku;
    }
}
