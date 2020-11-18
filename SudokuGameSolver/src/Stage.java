import java.awt.*;

public class Stage {
    Grid grid;
    
    public Stage() {
        grid = new Grid();
    }

    public void paint(Graphics g, Point mouseLoc) {
        grid.paint(g,mouseLoc);
    }
    
    public void mouseClicked(Point mouseLoc) {
        grid.paintOverlay(grid.cellAtPoint(mouseLoc).get(), new Color(0f, 0f, 1f, 0.5f));
    }
}
