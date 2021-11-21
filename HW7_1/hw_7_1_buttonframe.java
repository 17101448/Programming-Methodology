package HW7_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 


public class hw_7_1_buttonframe extends JFrame 
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public hw_7_1_buttonframe()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel(); 
        buttonPanel.setLayout(new GridLayout(5,5)); // 실제 개수보다 적으면 행부터 채우므로 조심할 것 
    
        buttonPanel.add(makeButton("참새", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("두루미", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("황새", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("비둘기", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("까오기", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("오리", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("타조", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("부엉이", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("올빼미", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("뱁새", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("꿩", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("닭", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("구관조", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("잉꼬", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("매", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("거위", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("독수리", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("콘돌", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("봉황", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("공작", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("까치", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("까마귀", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("앵무새", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("꾀꼬리", Color.LIGHT_GRAY));
        buttonPanel.add(makeButton("고니", Color.LIGHT_GRAY));
        add(buttonPanel);
    }

    private JButton makeButton(String name, final Color backGroundColor)//버튼이름과, 지정 색을 인자로 받아옴 
    {
        JButton button = new JButton(name); //버튼이름으로 버튼 생성 
        button.setBackground(Color.ORANGE); // 초기 버튼의 색을 주황색으로 설정 
    
        button.addActionListener(new ActionListener(){ // 버튼 클릭시 액션 
            public void actionPerformed(ActionEvent e){
                button.setBackground(backGroundColor); // 버튼 색 바꾸기
                System.out.println(name);              //버튼 이름 콘솔에 출력 
            }
        });
        return button; // 버튼 반환 
    }
}
