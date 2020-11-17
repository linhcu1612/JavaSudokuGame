import java.awt.Graphics;
import java.awt.Point;
import java.util.function.Consumer;

public class Grid implements Iterable<Cell> {

    private Sudoku sudoku;


    public Grid() {
        sudoku = new Sudoku();
        Game game = new Game("hard", sudoku);
        sudoku = game.randSudoku(sudoku);
    }

    public void paint(Graphics g, Point mousePos){
        doToEachCell(   (Cell c) -> c.paint(g, mousePos)  );
    }

    @Override
    public CellIterator iterator(){
        return new CellIterator(sudoku.getSudoku());
    }

    public void doToEachCell(Consumer<Cell> func){
        for(Cell c : this){
            func.accept(c);
        }
    }
}
