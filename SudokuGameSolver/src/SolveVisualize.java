import java.awt.Color;
import java.awt.Graphics;

public class SolveVisualize implements GameState {

    Stage s;

    public SolveVisualize(Stage s) {
        this.s = s;
        SolveVisualizeMethod(s,0);
        for (Cell c : s.grid) {
            c.setColor(Color.WHITE);
        }
    }

    public boolean SolveVisualizeMethod(Stage s, int delayTime) {

        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < s.grid.getCell().length; i++) {
            for (int j = 0; j < s.grid.getCell().length; j++) {
                if (s.grid.getCell()[i][j].getValue() == 0) {
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
            for (int num = 1; num <= s.grid.getCell().length; num++) {
                if (s.grid.getGame().isAvailable(s.grid.getSudoku(),row,col,num)){
                    s.grid.getCell()[row][col].setValue(num);
                    try {
                        Thread.sleep(delayTime);
                        if (SolveVisualizeMethod(s,delayTime)) {
                            return true;
                        } else {
                            s.grid.getCell()[row][col].setValue(0);
                        }
                    } catch (Exception e) {

                    }
            }
        }
        return false;
    }

    @Override
    public void MouseClick(int x, int y, Stage s) {
        s.currentState = new ChoosingCell();
    }

    @Override
    public void paint(Graphics g, Stage s) {
        
    }

    @Override
    public void keyPressed(int x, Stage s) {

    }
    
}
