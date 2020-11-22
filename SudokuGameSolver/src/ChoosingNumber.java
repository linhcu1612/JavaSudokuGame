import java.awt.Graphics;
import java.awt.event.*;

public class ChoosingNumber implements GameState {

    @Override
    public void MouseClick(int x, int y, Stage s) {
        s.currentState = new ChoosingCell();
    }

    @Override
    public void paint(Graphics g, Stage s) {
    }

    @Override
    public void keyPressed(int x, Stage s) {
        if (x == KeyEvent.VK_0) {
            s.choosingCell.setValue(0);
        } 
        if (x == KeyEvent.VK_1) {
            s.choosingCell.setValue(1);
        }
        if (x == KeyEvent.VK_2) {
            s.choosingCell.setValue(2);
        }
        if (x == KeyEvent.VK_3) {
            s.choosingCell.setValue(3);
        }
        if (x == KeyEvent.VK_4) {
            s.choosingCell.setValue(4);
        }
        if (x == KeyEvent.VK_5) {
            s.choosingCell.setValue(5);
        }
        if (x == KeyEvent.VK_6) {
            s.choosingCell.setValue(6); 
        }
        if (x == KeyEvent.VK_7) {
            s.choosingCell.setValue(7);
        }
        if (x == KeyEvent.VK_8) {
            s.choosingCell.setValue(8);
        }
        if (x == KeyEvent.VK_9) {
            s.choosingCell.setValue(9);
        }
        if (x == KeyEvent.VK_ENTER) {
            s.currentState = new CheckCorrect(s);
        } 
        if (x == KeyEvent.VK_SPACE) {
            for (Cell c : s.pendingCell) {
                c.setValue(0);
                c.setPending(false);
            }
            s.choosingCell = null;
            s.currentState = new SolveVisualize(s);
        }

    }
}
