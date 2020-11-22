import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.Optional;
import java.util.function.Consumer;
import java.awt.*;

public class Grid implements Iterable<Cell> {

    private Sudoku sudoku;
    private Game game;


    public Grid() {
        sudoku = new Sudoku();
        game = new Game("hard", sudoku);
        sudoku = game.randSudoku(sudoku);
    }

    public void paint(Graphics g, Point mouseLoc) {
        doToEachCell(   (Cell c) -> c.paint(g,mouseLoc));
    }

    public void paintOverlay(Graphics g,Cell c,Color color){
        if (c != null) {
            g.setColor(color);
            g.fillRect(c.x+2, c.y+2, c.width-4, c.height-4);
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            if (c.getValue() != 0) {
                g.drawString(String.valueOf(c.getValue()), c.x+35, c.y+50);
            }
        }
    }

    @Override
    public CellIterator iterator(){
        return new CellIterator(sudoku.getSudoku());
    }

    public Optional<Cell> cellAtPoint(Point p){
        for(Cell c: this){
            if (c.contains(p)){
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    public void doToEachCell(Consumer<Cell> func){
        for(Cell c : this){
            func.accept(c);
        }
    }

    public Game getGame() {
        return this.game;
    }

    public Sudoku getSudoku() {
        return this.sudoku;
    }

    public Cell[][] getCell() {
        return sudoku.getSudoku();
    }

    public Cell[][] getSolvedCell() {
        return game.getSolvedSudoku().getSudoku();
    }
    
}
