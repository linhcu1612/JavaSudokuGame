import java.util.HashMap;

public class Sudoku {
    //default mode
    private int size = 9;
    private String diffMode = "hard";
    private float mode;
    private String title = "Default Mode";
    private String status = "Unsolve";
    private Cell[][] sudoku;

    public Sudoku() {
        this.sudoku = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i % Math.sqrt(size) == 0) && (j % Math.sqrt(size) == 0)) {
                    sudoku[i][j] = new Cell(i, j, 80*j+5, 80*i+5);
                } else if ((i % Math.sqrt(size) == 0)) {
                    sudoku[i][j] = new Cell(i, j, 80*j, 80*i+5);
                } else if ((j % Math.sqrt(size) == 0)) {
                    sudoku[i][j] = new Cell(i, j, 80*j+5, 80*i);
                } else {
                    sudoku[i][j] = new Cell(i, j, 80*j, 80*i);
            
                }
            }
        }
    }

    public void setSize(int size) {
        this.size = size;
        this.sudoku = new Cell[size][size]; 
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sudoku[i][j] = new Cell(i, j, 80*j, 80*i);
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public void setDiffMode(String diffMode) {
        this.diffMode = diffMode;
    }

    public String getDiffMode() {
        return this.diffMode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
    
    public Cell[][] getSudoku() {
        return this.sudoku;
    }

    public void setSudoku(Cell[][] sudoku) {
        this.sudoku = sudoku;
    }

    public float getMode() {
        return this.mode;
    }

    public void ChooseDiff(String x) {
        HashMap<String, Float> linh = new HashMap<String, Float>();
        linh.put("hard", 0.21f);
        linh.put("medium", 0.5f);
        linh.put("easy",0.71f);

        if (linh.containsKey(x)) {
            this.mode = linh.get(x);
            this.diffMode = x;
        } else {
            System.out.println("There are only 3 modes of this game : hard, medium and easy");
        }
    }
}
