import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Duration;
import java.time.Instant;

class Main extends JFrame {

    class UI extends JPanel implements MouseListener {

        private JButton StartNewGame, ContinueLastGame;
    
        private final int ButtonSizeX = 100;
        private final int ButtonSizeY = 50;
        private final int StartNewGameLocationX = 100;
        private final int StartNewGameLocationY = 250;
        private final int ContinueLastGameLocationX = 300;
        private final int ContinueLastGameLocationY = 250;
    
    
        public UI() {
    
            this.setPreferredSize(new Dimension(500,500));
            StartNewGame = new JButton("New Game");
            ContinueLastGame = new JButton("Continue");
            StartNewGame.setSize(ButtonSizeX, ButtonSizeY);
            ContinueLastGame.setSize(ButtonSizeX,ButtonSizeY);
            StartNewGame.setLocation(StartNewGameLocationX, StartNewGameLocationY);
            ContinueLastGame.setLocation(ContinueLastGameLocationX, ContinueLastGameLocationY);
            StartNewGame.addMouseListener(this);
            this.add("new game", StartNewGame);
            this.add("continue", ContinueLastGame);
        }
    
        @Override
        public void mouseClicked(MouseEvent e) {
            NewGame newGame = new NewGame();
            switchPanels(newGame);
        }
    
        @Override
        public void mousePressed(MouseEvent e) {
        }
    
        @Override
        public void mouseReleased(MouseEvent e) {
        }
    
        @Override
        public void mouseEntered(MouseEvent e) {
        }
    
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    class NewGame extends JPanel implements MouseListener {

        Stage stage;

        public NewGame() {
            setPreferredSize(new Dimension(720, 720));
            this.addMouseListener(this);
            stage = new Stage();
        }

        @Override
        public void paint(Graphics g) {
            stage.paint(g, getMousePosition());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
}

    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    private Main() {
        super("SuDoKu Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NewGame newGame = new NewGame();
        newGame.setLayout(null);
        setContentPane(newGame);
        pack();
        setVisible(true);
    }

    public void switchPanels(JPanel panel) {
        //pane = panel;
        //repaint();
    }

    public void run() {
        while (true) {
            Instant startTime = Instant.now();
            this.repaint();
            Instant endTime = Instant.now();
            long howLong = Duration.between(startTime, endTime).toMillis();
            try {
                Thread.sleep(20l - howLong);
            } catch (InterruptedException e) {
                System.out.println("thread was interrupted, but who cares?");
            } catch (IllegalArgumentException e) {
                System.out.println("application can't keep up with framerate");
            }
        }
    }
}
