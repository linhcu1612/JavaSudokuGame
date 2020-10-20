import java.util.HashMap;

public class Sudoku {
    private int size;
    private String diffMode = "null";
    private String title = "null";
    private String status = "null";
    private int[][] sudoku;

    public Sudoku() {
        this.sudoku = new int[size][size];
    }

    public void setSize(int size) {
        this.size = size;
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

    public void ChooseDiff(String x) {
        HashMap<String, Integer> linh = new HashMap<String, Integer>();
        linh.put("hard", 9);
        linh.put("medium", 6);
        linh.put("easy",4);

        if (linh.containsKey(x)) {
            this.size = linh.get(x);
            this.diffMode = x;
            this.sudoku = new int[size][size];
        } else {
            System.out.println("There are only 3 modes of this game : hard, medium and easy");
        }
    }
}
