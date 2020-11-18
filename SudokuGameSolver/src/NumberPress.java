import java.awt.event.*;

public class NumberPress implements KeyListener  {

    Stage stage;
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override 
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == e.VK_1) {
            //stage.writeNumber(1, mouseLoc);
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
    }
}
