package DesignUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class DesignUI {
    JFrame f;

    public DesignUI() {
        f = new JFrame();

        JButton gameMode1 = new JButton();
        gameMode1.setText("CreatingMode");
        gameMode1.setBounds(100, 225, 100, 50);
        gameMode1.addMouseListener(l);
        JButton gameMode2 = new JButton();
        gameMode2.setText("SolvingMode");
        gameMode2.setBounds(300, 225, 100, 50);
        
        

        f.add(gameMode1);
        f.add(gameMode2);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}