public class Client {
    public static void main(String[] args) {
        
        Game game = new Game();
        game.ChooseDiff("hard");
        game.randSudoku();
        game.printSudoku();
        game.solvedSudoku();
        game.printSudoku(); 
    }
}
