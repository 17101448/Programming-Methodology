package HW_7_4;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*; 
import javax.swing.*;

public class MouseFrame extends JFrame {
    public MouseFrame(){
    add(new BoardComponent());
    pack(); 
    }
}

class BoardComponent extends JComponent{
    private static final int LINE_NUM = 9;
    private static final int LINE_WIDTH = 30;
    private static final int BOARD_SIZE = LINE_WIDTH*(LINE_NUM-1);
    private static final int STONE_SIZE = (int)(LINE_WIDTH*0.8);

    private ArrayList<Ellipse2D> blackStones;
    private ArrayList<Ellipse2D> whiteStones;
    private Ellipse2D current;

    public BoardComponent(){
        blackStones = new ArrayList<>();
        whiteStones = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
    }

        public void paintComponent(Graphics g)
        {   
            int x=30, y =30; 
            Graphics2D g2 = (Graphics2D)g; 
            for(int i=0; i<LINE_NUM; i++)
            {
                g2.draw(new Line2D.Double(x, y+i*LINE_WIDTH, x+BOARD_SIZE, y+i*LINE_WIDTH));
                g2.draw(new Line2D.Double(x+i*LINE_WIDTH, y, x+i*LINE_WIDTH, y+BOARD_SIZE));
            }
            
            
            for(Ellipse2D b: blackStones)
            {   
                g2.setColor(Color.BLACK);
                g2.fill(b);
                g2.draw(b);
            }
            for(Ellipse2D w: whiteStones)
            {   
                g2.setColor(Color.WHITE);
                g2.fill(w);
                g2.draw(w);
            }
        }


        public void addBlack(Point2D p) // 좌표를 넣어주면 
        {
            int x = (int)((p.getX()/30)*10+0.5f)/10*30; 
            int y = (int)((p.getY()/30)*10+0.5f)/10*30; 

            Rectangle2D stoneframe = new Rectangle2D.Double(x-STONE_SIZE/2,y-STONE_SIZE/2,STONE_SIZE, STONE_SIZE);
            Ellipse2D current = new Ellipse2D.Double(); //네모 생성 
            current.setFrame(stoneframe);
            blackStones.add(current); // 어레이리스트에 넣어서 관리 
            System.out.println("Black");
            repaint();
        }

        public void addWhite(Point2D p) // 좌표를 넣어주면 
        {
            int x = (int)((p.getX()/30)*10+0.5f)/10*30; 
            int y = (int)((p.getY()/30)*10+0.5f)/10*30; 

            Rectangle2D stoneframe = new Rectangle2D.Double(x-STONE_SIZE/2,y-STONE_SIZE/2,STONE_SIZE, STONE_SIZE);
            Ellipse2D current = new Ellipse2D.Double(); //네모 생성 
            current.setFrame(stoneframe);
            whiteStones.add(current); // 어레이리스트에 넣어서 관리 
            System.out.println("white");
            repaint();
        }
    private class MouseHandler extends MouseAdapter{
        public void mousePressed(MouseEvent event)
        {
            current = find(event.getPoint()); //클릭한 지점 좌표 가져오기 
            if((current == null) && (event.getButton()==MouseEvent.BUTTON3))
                addBlack(event.getPoint()); // 클릭한 좌표에 add메서드 
                System.out.println("좌클릭");
            if((current) == null && (event.getButton()==MouseEvent.BUTTON1))
                addWhite(event.getPoint()); // 클릭한 좌표에 add메서드 
                System.out.println("우클릭");
        }

        public void mouseClicked(MouseEvent event){
            current = find(event.getPoint());
        }
    }

    public Ellipse2D find(Point2D p)
    {
        for(Ellipse2D r: blackStones){
            if(r.contains(p))
                return r; 
        }
        for(Ellipse2D r: whiteStones){
            if(r.contains(p))
                return r; 
        }
        return null; 
    }

    public Dimension getPreferredSize(){
        return new Dimension(BOARD_SIZE+60, BOARD_SIZE+60);
    }
}

