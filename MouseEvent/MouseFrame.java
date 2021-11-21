package HW_7_4;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*; 
import javax.swing.*;



public class MouseFrame extends JFrame {
    public MouseFrame(){
        add(new MouseComponent());
        pack(); 
    }
}

class MouseComponent extends JComponent{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT=200;
    
    private static final int SIDE = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public MouseComponent(){
        squares = new ArrayList<>();
        current = null;
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for(Rectangle2D r: squares)
        g2.draw(r); 
    }

    public Rectangle2D find(Point2D p)
    {
        for(Rectangle2D r: squares){
            if(r.contains(p))
                return r; 
        }
        return null; 
    }

    public void add(Point2D p) // 좌표를 넣어주면 
    {
        double x = p.getX(); 
        double y = p.getY(); 

        current = new Rectangle2D.Double(x - SIDE /2, y-SIDE/2, SIDE, SIDE); //네모 생성 
        squares.add(current); // 어레이리스트에 넣어서 관리 
        repaint();
    }
    public void remove(Rectangle2D r)
    {
        if(r==null)return; 
        if(r==current) current = null;
        squares.remove(r);
        repaint(); 
    }
    private class MouseHandler extends MouseAdapter{
        public void mousePressed(MouseEvent event)
        {
            current = find(event.getPoint()); //클릭한 지점 좌표 가져오기 
            if(current == null)
                add(event.getPoint()); // 클릭한 좌표에 add메서드 
        }
        public void mouseClicked(MouseEvent event){
            current = find(event.getPoint());
            if(current != null && event.getClickCount() >=2) // 더블클릭시 제거 
            remove(current); 
        }
    }
    public class MouseMotionHandler implements MouseMotionListener{
        public void mouseMoved(MouseEvent event){
            if(find(event.getPoint())==null)
                setCursor(Cursor.getDefaultCursor());
            else    
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
        public void mouseDragged(MouseEvent event){
            if(find(event.getPoint())==null){
                int x = event.getX();
                int y = event.getY();

                current.setFrame(x-SIDE/2, y-SIDE/2, SIDE, SIDE);
                repaint();
            }
        }
    }
}
