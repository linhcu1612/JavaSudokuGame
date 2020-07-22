package GamePlay;

public class Client {
    public static void main(String[] args) {
        Game game = new Game();
        int[][] sudoku = game.randSudoku();
        game.solvedSudoku(sudoku);
        game.generateSudoku(sudoku);
        game.printSudoku(sudoku);
        
    
    }
}
