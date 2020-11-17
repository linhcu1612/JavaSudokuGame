import java.awt.*;

public class Stage {
    Grid grid;
    
    public Stage() {
        grid = new Grid();
    }

    public void writeNumber(int number, Point mouseLoc) {
        grid.writeNumber(number,mouseLoc);
    }

    public void paint(Graphics g, Point mouseLoc) {
        grid.paint(g,mouseLoc);
    }
}
