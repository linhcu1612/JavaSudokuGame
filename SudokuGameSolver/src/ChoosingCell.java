import java.awt.Graphics;

public class ChoosingCell implements GameState {

    @Override
    public void MouseClick(int x, int y, Stage s) {
        for (Cell c : s.grid) {
            if (c.contains(x, y) && c.getValue() == 0) {
                s.choosingCell = c;
                s.pendingCell.add(c);
                s.currentState = new ChoosingNumber();
            }
        }
    }

    @Override
    public void paint(Graphics g, Stage s) {
    }

    @Override
    public void keyPressed(int x, Stage s) {
        // TODO Auto-generated method stub

    }
    
}
