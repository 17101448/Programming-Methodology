package HW_7_2;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*; 

public class hw_7_2_CalendarFrame extends JFrame 
{
    private JPanel UIPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    static LocalDate date = LocalDate.now(); 
    static int year = date.getYear();    
    static int month = date.getMonthValue();
    int weekday = date.getDayOfWeek().getValue();

    public JLabel yydd = new JLabel(); //년월을 담아올 JLabel 생성 

    public hw_7_2_CalendarFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        UIPanel = new JPanel(); 
        UIPanel.add(makePreviousButton());
        yydd.setText(this.year+"년"+this.month+"월"); //오늘 YYDD 표시 
        UIPanel.add(yydd);
        UIPanel.add(makeNextButton());
        
        add(UIPanel, BorderLayout.NORTH); //7_3에서 사용해야하므로 최상단에 위치하도록 조정 
    }

    private JButton makeNextButton() //다음 월로 넘어가는 버튼 클래스 
    {
        JButton button = new JButton("▶"); 
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //버튼 클릭시 다음달 객체의 년 월로 클래스 변수 업데이트 시켜줌 
                hw_7_2_CalendarFrame.date =date.plusMonths(1);
                hw_7_2_CalendarFrame.year = date.getYear(); 
                hw_7_2_CalendarFrame.month = date.getMonthValue();   
                //업데이트 된 클래스 변수로 새 YYDD 표현 
                yydd.setText(hw_7_2_CalendarFrame.year+"년"+hw_7_2_CalendarFrame.month+"월");
            }
        });
        return button;
    }
    private JButton makePreviousButton() // 이전 월로 넘어가는 버튼 클래스 
    {
        JButton button = new JButton("◀"); 
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //버튼 클릭시 이전달 객체의 년 월로 클래스 변수 업데이트 시켜줌 
                hw_7_2_CalendarFrame.date =date.minusMonths(1);
                hw_7_2_CalendarFrame.year = date.getYear(); 
                hw_7_2_CalendarFrame.month = date.getMonthValue(); 
                //업데이트 된 클래스 변수로 새 YYDD 표현 
                yydd.setText(hw_7_2_CalendarFrame.year+"년"+hw_7_2_CalendarFrame.month+"월");
            }
        });
        return button;
    }
}

