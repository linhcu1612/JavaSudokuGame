public class Client {
    public static void main(String[] args) {
        Game game = new Game();

        int[][] sudoku = game.randSudoku();
        int[][] start = new int[9][9];

        game.solvedSudoku(sudoku);

        start = game.generateSudoku(sudoku);

        for (int i = 0; i < 9; i++) {
            if ( i == 0) {
                System.out.println(" - - - - - - - - - - - - - ");
            }
            for (int j = 0; j < 9; j++) {
                if (j == 0) {
                    System.out.print(" | " + start[i][j] + " ");
                } else if (((j+1) % 3) == 0 ) {
                    System.out.print(start[i][j] + " | ");
                } else {
                    System.out.print(start[i][j] + " ");
                }
            }
            System.out.println("");
            if ( (i + 1) % 3 == 0) {
                System.out.println(" - - - - - - - - - - - - - ");
            }
        }



        //JFrame f = new JFrame();

        //f.setLayout(new GridLayout(9,9,100,100));

        //f.setTitle("vi du ");

        //f.setSize(900,900);
        //f.setLayout(null);
        //f.setVisible(true);
    }
}
