package HW7_1;
import java.awt.*;
import javax.swing.*;

public class hw_7_1 {
    
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new hw_7_1_buttonframe(); 
                frame.setTitle("buttonDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true); 
                //
            }
        });
    }
}

