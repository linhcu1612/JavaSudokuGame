import java.util.HashMap;

public class Sudoku {
    //default mode
    private int size = 9;
    private String diffMode = "hard";
    private float mode;
    private String title = "Default Mode";
    private String status = "Unsolve";
    private int[][] sudoku;

    public Sudoku() {
        this.sudoku = new int[size][size];
    }

    public void setSize(int size) {
        this.size = size;
        this.sudoku = new int[size][size];
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
    
    public int[][] getSudoku() {
        return this.sudoku;
    }

    public void setSudoku(int[][] sudoku) {
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
