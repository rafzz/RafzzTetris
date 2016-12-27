
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafzz
 */
public class Sblock1 extends Block {

    private boolean state1=true;
    private boolean state2=false;

    
    public Sblock1() {
        //this.start();
        points.add(new Point(Board.getBoardCenter(),0));
        points.add(new Point(Board.getBoardCenter()+mainSize,0));
        points.add(new Point(Board.getBoardCenter(),mainSize));
        points.add(new Point(Board.getBoardCenter()-mainSize,mainSize));
    }
    
    @Override
    public void draw(Graphics2D g, ImageObserver io) {
        for(Point p : points){
            g.drawImage(basicBlock,p.x,p.y,io);
        }
    }
    
    public void rotate(java.awt.event.KeyEvent evt){
        
        
        
        if(state1){
            switch(evt.getKeyCode()){
            case KeyEvent.VK_X: 
                points.get(1).y= points.get(1).y+30;
                points.get(1).x= points.get(1).x-30;
                
                points.get(2).x= points.get(2).x-30;
                points.get(2).y= points.get(2).y-30;
                
                
                points.get(3).y= points.get(3).y-60;
                break;
        
            }
            state1=false;
            state2=true;
            
            
        }else if(state2){
            switch(evt.getKeyCode()){
            case KeyEvent.VK_X:
                points.get(1).y= points.get(1).y-30;
                points.get(1).x= points.get(1).x+30;
                
                points.get(2).x= points.get(2).x+30;
                points.get(2).y= points.get(2).y+30;
                
                //points.get(3).x= points.get(3).x-60;
                points.get(3).y= points.get(3).y+60;
                break;
            }
            state1=true;
            state2=false;
            
            
        }
        
        
    }
}
