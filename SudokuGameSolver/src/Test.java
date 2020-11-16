public class Test {
    public static void main(String args[]) {
        Sudoku newSudoku = new Sudoku();
        Game newGame = new Game("hard",newSudoku);
        newSudoku = newGame.randSudoku(newSudoku);
        for (int i = 0; i < newSudoku.getSize(); i++) {
            for (int j = 0; j < newSudoku.getSize(); j++) {
                System.out.print(String.valueOf(newSudoku.getSudoku()[i][j]) + " ");
            }
        }
        newGame.printSudoku(newSudoku);
        //newGame.solvedSudoku(newSudoku);
        //newGame.printSudoku(newSudoku);
    }
}
