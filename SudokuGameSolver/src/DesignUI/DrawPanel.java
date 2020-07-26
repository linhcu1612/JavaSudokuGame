package DesignUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

class DrawPanel extends JPanel {

    private void doDrawing(Graphics g) {

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
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}