package DesignUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DesignUI extends JFrame {
    JFrame f;
    JButton gameMode1;
    JButton gameMode2;

    public DesignUI() {
        f = new JFrame();

        var drawPanel = new DrawPanel();
        add(drawPanel);
        

        //
        //gameMode1 = new JButton();
        //gameMode1.setText("CreatingMode");
        //gameMode1.setBounds(100, 225, 100, 50);
        //gameMode1.addMouseListener(new mouseClickedButton1());
        //gameMode2 = new JButton();
        //gameMode2.setText("SolvingMode");
        //gameMode2.setBounds(300, 225, 100, 50);
        //gameMode2.addMouseListener(new mouseClickedButton2());
        
        //f.add(gameMode1);
        //f.add(gameMode2);
        //
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public class mouseClickedButton1 implements MouseListener {
		@Override
        public void mousePressed(MouseEvent e) {
        }

		@Override
		public void mouseClicked(MouseEvent e) {
            System.out.println("this is creatingMode");
            f.removeAll();
            var drawPanel = new DrawPanel();
            f.add(drawPanel);


            setSize(500, 500);
            setTitle("Sudoku");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public class mouseClickedButton2 implements MouseListener {
		@Override
        public void mousePressed(MouseEvent e) {
        }

		@Override
		public void mouseClicked(MouseEvent e) {
            System.out.println("this is solvingMode");
            f.removeAll();


            //var drawPanel = new DrawPanel();
            //add(drawPanel);


                //setSize(500, 500);
                //setTitle("Sudoku");
                //setLocationRelativeTo(null);
                //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}