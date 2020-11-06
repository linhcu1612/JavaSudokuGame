import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Duration;
import java.time.Instant;

class Main extends JFrame {

    class UI extends JPanel implements MouseListener {

        JButton StartNewGame, ContinueLastGame;

        public UI() {

            this.setPreferredSize(new Dimension(500,500));
            StartNewGame = new JButton("New Game");
            ContinueLastGame = new JButton("Continue");
            StartNewGame.setSize(100, 100);
            StartNewGame.setLocation(75, 200);
            ContinueLastGame.setSize(100,100);
            ContinueLastGame.setLocation(175, 200);
            this.addMouseListener(this);
            this.add("new game", StartNewGame);
            this.add("continue", ContinueLastGame);

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI canvas = new UI();
        NewGame game = new NewGame();
        this.setContentPane(game);
        this.pack();
        this.setVisible(true);
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
