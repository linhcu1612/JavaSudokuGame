public class Test {
    public static void main(String args[]) {
        Sudoku newSudoku = new Sudoku();
        Game newGame = new Game("hard",9,newSudoku);
        newSudoku = newGame.randSudoku(newSudoku);
        newGame.printSudoku(newSudoku);
        newGame.solvedSudoku(newSudoku,10);
        newGame.printSudoku(newSudoku);
    }
}
