package DesignUI;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class PointsEx extends JFrame {

    public PointsEx() {
        
        initUI();
    }

    private void initUI() {
        
        var drawPanel = new DrawPanel();
        add(drawPanel);


        setSize(500, 500);
        setTitle("Sudoku");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            
            var ex = new PointsEx();
            ex.setVisible(true);
        });
    }
}
    