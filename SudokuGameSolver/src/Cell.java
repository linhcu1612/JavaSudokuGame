import java.awt.*;

public class Cell extends Rectangle{
    
    private static int sizeRect = 80;
    private int col;
    private int row;
    private int value = 0;

    public Cell(int col, int row, int x, int y){
        super(x,y, sizeRect, sizeRect);
        this.col = col;
        this.row = row;
    }

    public int getSizeRect() {
        return this.sizeRect;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    void paint(Graphics g, Point mousePos) {
        if (contains(mousePos)) {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x, y, sizeRect, sizeRect);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, sizeRect, sizeRect);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        if (value != 0) {
            g.drawString(String.valueOf(value), x+35, y+50);
        }
    }

    public void writeNumber(int number, Point mousePos) {
        if (contains(mousePos)) {
            this.value = number;
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
