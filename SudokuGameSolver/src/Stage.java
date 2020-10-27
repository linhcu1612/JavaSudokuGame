import java.awt.*;

public class Stage {
    Grid grid;
    
    public Stage() {
        grid = new Grid();
    }

    public void paint(Graphics g, Point mouseLoc) {
        grid.paint(g,mouseLoc);
    }
}
