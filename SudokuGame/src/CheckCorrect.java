import java.awt.Color;
import java.awt.Graphics;

public class CheckCorrect implements GameState {

    public CheckCorrect(Stage s) {
        if (s.choosingCell.getValue() == s.grid.getSolvedCell()[s.choosingCell.getCol()][s.choosingCell.getRow()].getValue()) {
            s.correctCell.add(s.choosingCell);
            s.pendingCell.remove(s.choosingCell);
            s.choosingCell.setColor(new Color(144,238,144));
        } else {
            s.choosingCell.setColor(new Color(233,116,81));
        }
    }

    @Override
    public void MouseClick(int x, int y, Stage s) {
        s.currentState = new ChoosingCell();
    }

    @Override
    public void keyPressed(int x, Stage s) {
    }

    @Override
    public void paint(Graphics g, Stage s) {
    }

}
