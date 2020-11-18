import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Duration;
import java.time.Instant;

class Main extends JFrame {
    
    class NewGame extends JPanel implements MouseListener,KeyListener {

        Stage stage;

        public NewGame() {
            setPreferredSize(new Dimension(725, 725));
            this.addMouseListener(this);
            stage = new Stage();
        }

        @Override
        public void paint(Graphics g) {
            stage.paint(g,getMousePosition());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            stage.mouseClicked(e.getPoint());
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

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }
}

    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    private Main() {
        super("SuDoKu Game");
        addKeyListener(new NumberPress());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NewGame newGame = new NewGame();
        newGame.setLayout(null);
        setContentPane(newGame);
        pack();
        setVisible(true);
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
