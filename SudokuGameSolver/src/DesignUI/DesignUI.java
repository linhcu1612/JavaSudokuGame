package DesignUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DesignUI extends JFrame {
    JFrame f;

    public DesignUI() {
        f = new JFrame();

        JButton gameMode1 = new JButton();
        gameMode1.setText("CreatingMode");
        gameMode1.setBounds(100, 225, 100, 50);
        gameMode1.addMouseListener(new mouseClickedButton1());
        JButton gameMode2 = new JButton();
        gameMode2.setText("SolvingMode");
        gameMode2.setBounds(300, 225, 100, 50);
        gameMode2.addMouseListener(new mouseClickedButton2());
        
        f.add(gameMode1);
        f.add(gameMode2);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    class DrawPanel extends JPanel {
        private void drawSudoku(Graphics g) {

            var g2d = (Graphics2D) g;
        
            int boxHeight = this.getHeight() / 9;
            int boxWidth = this.getWidth() / 9;

            int sudokuWidth = (this.getWidth() / 9) * 9;
            int sudokuHeight = (this.getHeight() / 9) * 9;

            g2d.setColor(Color.white);
		
    		g2d.fillRect(0, 0,this.getWidth(),this.getHeight());
            
    		g2d.setColor(Color.BLACK);
    		for(int x = 0;x <= this.getWidth();x+=boxWidth) {
    			if((x/(this.getWidth()/9)) % 3 == 0) {
	    			g2d.setStroke(new BasicStroke(2));
	    			g2d.drawLine(x, 0, x, sudokuHeight);
    			}
	    		else {
    				g2d.setStroke(new BasicStroke(1));
	    			g2d.drawLine(x, 0, x, sudokuHeight);
	    		}
    		}
		
	    	for(int y = 0;y <= this.getHeight();y+=boxHeight) {
	    		if((y/(this.getHeight()/9)) % 3 == 0) {
	    			g2d.setStroke(new BasicStroke(2));
	    			g2d.drawLine(0, y, sudokuWidth, y);
	    		}
	    		else {
		    		g2d.setStroke(new BasicStroke(1));
		    		g2d.drawLine(0, y, sudokuWidth, y);
		    	}
	    	}
        }

        @Override
        public void paintComponents(Graphics g) {

            super.paintComponents(g);
           drawSudoku(g);
        }
    }

    public class mouseClickedButton1 implements MouseListener {
		@Override
        public void mousePressed(MouseEvent e) {
        }

		@Override
		public void mouseClicked(MouseEvent e) {
            System.out.println("this is creatingMode");
                //var drawPanel = new DrawPanel();
                //add(drawPanel);
                //f.repaint();


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

    public class mouseClickedButton2 implements MouseListener {
		@Override
        public void mousePressed(MouseEvent e) {
        }

		@Override
		public void mouseClicked(MouseEvent e) {
            System.out.println("this is solvingMode");
            f.removeAll();

            JButton gameMode3 = new JButton();
            gameMode3.setText("Testing");
            gameMode3.setBounds(300, 225, 100, 50);

            f.add(gameMode3);
        


            //var drawPanel = new DrawPanel();
            //add(drawPanel);
            System.out.println("repaint ?");


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