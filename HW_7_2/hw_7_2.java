package HW_7_2;
import java.awt.*;
import javax.swing.*;

public class hw_7_2 {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new hw_7_2_CalendarFrame(); 
                frame.setTitle("buttonDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true); 
            }
        });
    }
}
