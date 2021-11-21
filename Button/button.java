package Button;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class button {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){ // 2가지 기능을 한번에 실현하기 위함 
            public void run(){
                ButtonFrame frame = new ButtonFrame();
                frame.setTitle("Sized Frame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료버튼 구현 
                frame.setVisible(true);
            }
        });
    }

}



