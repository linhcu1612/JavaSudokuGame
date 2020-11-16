import java.awt.*;

public class Cell extends Rectangle{
    
    static int size = 80;
    int col;
    int row;
    int value;

    public Cell(int col, int row, int x, int y, int value) {
        super(x,y,size,size);
        this.col = col;
        this.row = row;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
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
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        if (value != 0) {
            g.drawString(String.valueOf(value), x+35, y+50);
        }
    }

    public boolean contains(Point p){
        if (p != null){
            return super.contains(p);
        } else {
            return false;
        }
    }
}
