package Button_usually; 

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
        add(buttonPanel);
    }
// 익명 클래스를 활용해 사용함 
    private void makeButton(String name, final Color backGroundColor)
    {
        JButton button = new JButton(name); 
        buttonPanel.add(button); 
        /*람다 표현식 
        buttonPanel.addActionListener(event -> buttonPanel.setBackground(backGroundColor));
         */
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                buttonPanel.setBackground(backGroundColor);
            }
        });
    }
}