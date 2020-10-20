public class Client {
    public static void main(String[] args) {
        
        Sudoku sudoku = new Sudoku();
        Game game = new Game("hard",sudoku);
        sudoku = game.randSudoku(sudoku);
        game.printSudoku(sudoku);
        game.solvedSudoku(sudoku);
        game.printSudoku(sudoku); 
    }
}
