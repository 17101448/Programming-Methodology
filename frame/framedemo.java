package frame;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.*; 
import javax.swing.*;

public class framedemo {

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){ // 2가지 기능을 한번에 실현하기 위함 
            public void run(){
                SimpleFrame frame = new SimpleFrame();
                frame.setTitle("Sized Frame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료버튼 구현 
                frame.setVisible(true);
            }
        });
    }
    
}

class SimpleFrame extends JFrame { // 프레임 크기 설정 
    
    /*크기를 상수로 설정 
    private static final int DEFAULT_WIDTH = 300; 
    private static final int DEFAULT_HEIGHT = 200; 
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    */ 

    public SimpleFrame() {// 생성자 역할 
        add(new HelloComponent()); // 컴포넌트에 담아서 프레임에 넣어야 한다. 
        pack(); // preferred size of components 사용하기 위함 
        


        /*screen size 맞추서 사용하기 위함 
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth, screenHeight);
        setLocationByPlatform(true); 
        */


        /*아이콘 설정 
        Image img = new ImageIcon("icon.png").getImage();
        setIconImage(img);*/ 
    }
}

class HelloComponent extends JComponent{ //프레임에 그림을 그리는 것이 아닌 컴포넌트에 그려서 넣어준다. 
    private static final int DEFAULT_WIDTH = 300; 
    private static final int DEFAULT_HEIGHT = 200; 

    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g; // 그래픽스 사용하기 위해 항상 필요함 

        //폰트 설정 
        Font f = new Font("Serif", Font.BOLD, 36); // 폰트, 스타일, 크기 
        g2.setFont(f); 

        String message = "Hello, Wordl!"; // 메세지 설정 
        FontRenderContext context = g2.getFontRenderContext(); // 
        Rectangle2D bounds = f.getStringBounds(message, context); //
        double x = (getWidth()-bounds.getWidth())/2;
        double y = (getHeight() - bounds.getHeight())/2; 
        double ascent = -bounds.getY();
        double baseY = y + ascent; 

        g2.drawString(message, (int) x, (int) baseY);

        // 폰트 감싸는 사각형 만들기 
        g2.setPaint(Color.LIGHT_GRAY);
        g2.draw(new Line2D.Double(x, baseY, x+bounds.getWidth(), baseY));
        Rectangle2D recFont = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(recFont); 

        //사각형 
        double recx = 100;
        double recy = 100;
        double width = 200;
        double height = 150; 
        Rectangle2D rect = new Rectangle2D.Double(recx, recy, width, height);
        g2.draw(rect); 

        //타원형 
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        //선 
        g2.draw(new Line2D.Double(recx,recy,recx+width,recy+height));

        //원
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY(); 
        double radius = 150; 
        Ellipse2D circle = new Ellipse2D.Double(); 
        circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
        g2.draw(circle);
        
        g.drawString("Hello, Swing!", 110, 100);//문자열, 위치 좌표 
    }

    public Dimension getPrefferedSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}