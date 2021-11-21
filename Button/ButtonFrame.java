package Button;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.*; 
import javax.swing.*;
import javax.swing.*; 
import java.awt.event.*;


public class ButtonFrame extends JFrame  {
        private JPanel buttonPanel; 
        private static final int DEFAULT_WIDTH = 300; 
        private static final int DEFAULT_HEIGHT = 200; 
        
        public ButtonFrame(){
            setSize(DEFAULT_WIDTH, DEFAULT_WIDTH);

            //버튼 객체 생성 
            JButton yellowButton = new JButton("Yellow");
            JButton redButton = new JButton("Red");
            JButton blueButton = new JButton("Blue");

            //판넬에 버튼 추가
            buttonPanel = new JPanel(); 
            buttonPanel.add(yellowButton);
            buttonPanel.add(blueButton);
            buttonPanel.add(redButton);
            add(buttonPanel);
            
            // 버튼 액션 추가 
            ColorAction yellowAction = new ColorAction(Color.YELLOW);
            ColorAction blueAction = new ColorAction(Color.BLUE);
            ColorAction redAction = new ColorAction(Color.RED); 

            //액션을 버튼에 할당함 
            yellowButton.addActionListener((yellowAction));
            redButton.addActionListener(redAction);
            blueButton.addActionListener(blueAction);
        }
        private class ColorAction implements ActionListener{
            private Color bgColor; 
            public ColorAction(Color c)
            {
                bgColor = c; 
            }
            
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(bgColor);    
            }

        }
}


