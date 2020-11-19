import java.awt.Graphics;
import java.awt.event.*;

public class ChoosingNumber implements GameState {

    int newValue;

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
            newValue = 0;
        } 
        if (x == KeyEvent.VK_1) {
            newValue = 1;
        }
        if (x == KeyEvent.VK_2) {
            newValue = 2;
        }
        if (x == KeyEvent.VK_3) {
            newValue = 3;
        }
        if (x == KeyEvent.VK_4) {
            newValue = 4;
        }
        if (x == KeyEvent.VK_5) {
            newValue = 5;
        }
        if (x == KeyEvent.VK_6) {
            newValue = 6; 
        }
        if (x == KeyEvent.VK_7) {
            newValue = 7;
        }
        if (x == KeyEvent.VK_8) {
            newValue = 8;
        }
        if (x == KeyEvent.VK_9) {
            newValue = 9;
        }
        if (x == KeyEvent.VK_SPACE) {
            s.choosingCell.setValue(newValue);
            System.out.println(s.choosingCell.getValue());
        } 
        if (x == KeyEvent.VK_ESCAPE) {
            //s.choosingCell.setValue(newValue);
            //System.out.println(s.choosingCell.getValue());
        }

    }
}
