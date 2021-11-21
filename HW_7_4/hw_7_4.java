package HW_7_4;
import java.awt.*;
import javax.swing.*;

public class hw_7_4 {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new MouseFrame(); 
                frame.setTitle("buttonDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true); 
                //
            }
        });
    }
}



