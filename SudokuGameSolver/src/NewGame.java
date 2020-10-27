import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewGame extends JPanel implements MouseListener {

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
