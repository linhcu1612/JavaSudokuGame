import java.awt.Graphics;
import java.awt.Point;
import java.util.function.Consumer;

public class Grid implements Iterable<Cell> {

    Sudoku sudoku;
    Game game;
    int[][] unsolveSudoku;
    Cell[][] cells;

    public Grid() {
        Sudoku sudoku = new Sudoku();
        Game game = new Game("hard",6, sudoku);
        sudoku = game.randSudoku(sudoku);
        unsolveSudoku = sudoku.getSudoku();

        //sudoku.setSudoku(unsolveSudoku);
        //game.solvedSudoku(sudoku);
        //unsolveSudoku = sudoku.getSudoku();

        cells = new Cell[unsolveSudoku.length][unsolveSudoku.length];
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                cells[i][j] = new Cell( i, j, 80*i, 80*j, unsolveSudoku[j][i]);
            }
        }
    }

    public void paint(Graphics g, Point mousePos){
        doToEachCell(   (Cell c) -> c.paint(g, mousePos)  );
    }

    @Override
    public CellIterator iterator(){
        return new CellIterator(cells);
    }

    public void doToEachCell(Consumer<Cell> func){
        for(Cell c : this){
            func.accept(c);
        }
    }
}
