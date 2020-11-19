import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
//import java.awt.event.*;
import java.util.*;

public class Stage {
    Grid grid;
    GameState currentState;
    Cell choosingCell;
    List<Cell> pendingCell;
    List<Cell> correctCell;
    
    public Stage() {
        grid = new Grid();
        currentState = new ChoosingCell();
        choosingCell = new Cell();
        pendingCell = new ArrayList<Cell>();
        correctCell = new ArrayList<Cell>();
    }

    public void paint(Graphics g, Point mouseLoc) {
        grid.paint(g,mouseLoc);
        grid.paintOverlay(g, choosingCell, new Color(247, 247, 129));
        
        for (Cell c : pendingCell) {
            c.pending();
        }
    }
    
    public void mouseClicked(int X,int Y) {
        currentState.MouseClick(X, Y, this);
    }

    public void keyPressed(int x) {
        currentState.keyPressed(x,this);
    }
}
