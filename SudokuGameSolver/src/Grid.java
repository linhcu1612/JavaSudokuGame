import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.Optional;
import java.util.function.Consumer;

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

    public void paintOverlay(Cell c,Color color){
        c.setColor(color);
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

    
}
