package Button; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class ButtonFrameConcise extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrameConcise(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel(); 
        makeButton("Yellow", Color.YELLOW);
        makeButton("Blue", Color.BLUE); 
        makeButton("red", Color.RED);
        
    }
}