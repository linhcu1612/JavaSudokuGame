package GamePlay;

import DesignUI.DesignUI;

public class Client {
    public static void main(String[] args) {
        
        Game game = new Game();
        int[][] sudoku = game.randSudoku();
        new DesignUI();
        
    }
}
