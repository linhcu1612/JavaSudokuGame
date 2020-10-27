import java.awt.*;

public class Cell extends Rectangle{
    
    static int size = 80;
    int col;
    int row;

    public Cell(int col, int row, int x, int y) {
        super(x,y,size,size);
        this.col = col;
        this.row = row;
    }

    void paint(Graphics g, Point mousePos){
        if(contains(mousePos)){
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x,y,size,size);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,size,size);
    }

    public boolean contains(Point p){
        if (p != null){
            return super.contains(p);
        } else {
            return false;
        }
    }
}
