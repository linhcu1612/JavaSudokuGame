public class Client{
    public static void main(String[] args) {
        Game game = new Game();

        int[][] sudoku = game.randSudoku();
        int[][] start = new int[9][9];

        game.solvedSudoku(sudoku);

        start = game.generateSudoku(sudoku);

        game.printSudoku(start);
        
        System.out.println("here is the answer");

        game.solvedSudoku(start);

        game.printSudoku(start);





        //JFrame f = new JFrame();

        //f.setLayout(new GridLayout(9,9,100,100));

        //f.setTitle("vi du ");

        //f.setSize(900,900);
        //f.setLayout(null);
        //f.setVisible(true);
    }
}
