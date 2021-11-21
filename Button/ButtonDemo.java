package Button;

import java.awt.*;
import javax.swing.*;

public class ButtonDemo{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new ButtonFrameConcise(); 
                frame.setTitle("buttonDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true); 
            }
        });
    }
}