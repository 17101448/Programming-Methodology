

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 


    class View extends JPanel {
        public View(){
          //  Rectangle r=new Rectangle(10,10,100,100);
        }
        public void paint(Graphics g){
            paintComponent(g);
            g.drawRect(10,10,100,100);
            g.drawString("Hello World",20,20);
            g.draw3DRect(30,30, 50,50, true);
        }
    }
     
    public class JavaT extends JFrame implements ActionListener
    {
        View v;
        Label my1, my2, my3;
        Button bt1;
        public JavaT(){
             v=new View();
             setSize(300,400);
             setTitle("Hello");
             setVisible(true);
             my1=new Label();
             my1.setText(" C  language !!!     ");
             my1.setBackground(Color.cyan);
             bt1=new Button("Button");
             bt1.addActionListener(this);
             v.add(bt1);
             v.add(my1);
             add(v);         
        }
        
        public static void main(String[] args) {
            JavaT  a=new JavaT();  
           
        }    
     
        @Override
        public void actionPerformed(ActionEvent e) {
                 my1.setText("Button Click");
        }
    }
