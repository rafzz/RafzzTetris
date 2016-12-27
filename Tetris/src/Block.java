
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafzz
 */
public abstract class Block extends Thread{
    protected ArrayList<Point> points = new ArrayList<Point>();
    protected int mainSize=30;
    protected BufferedImage basicBlock = loadImage("img/basicBlock.gif");
    private int sleepValue=700;
    
    public void draw(Graphics2D g,ImageObserver io){}
    public void rotate(java.awt.event.KeyEvent evt){}
    

    public Block() {
        this.start();
    }
    
    public void move(java.awt.event.KeyEvent evt){
        
        switch(evt.getKeyCode()){
                
                
            case KeyEvent.VK_RIGHT: 
                points.get(0).x= points.get(0).x+30;
                points.get(1).x= points.get(1).x+30;
                points.get(2).x= points.get(2).x+30;
                points.get(3).x= points.get(3).x+30;
                break;
            
            case KeyEvent.VK_LEFT: 
                points.get(0).x= points.get(0).x-30;
                points.get(1).x= points.get(1).x-30;
                points.get(2).x= points.get(2).x-30;
                points.get(3).x= points.get(3).x-30;
                break;
                
            case KeyEvent.VK_DOWN: 
                points.get(0).y= points.get(0).y+30;
                points.get(1).y= points.get(1).y+30;
                points.get(2).y= points.get(2).y+30;
                points.get(3).y= points.get(3).y+30;
                break;
        
            }
    }
    
    
    
    public  BufferedImage loadImage(String sciezka) {
        URL url=null;
        try {
            url = getClass().getClassLoader().getResource(sciezka);
            return ImageIO.read(url);
        } catch (Exception e) {
            System.out.println("Przy otwieraniu " + sciezka +" jako " + url);
            System.out.println("Wystapil blad : "+e.getClass().getName()+""+e.getMessage());
            return null;
        }
    }

    @Override
    public void run() {
        super.run();
        while(true){
            for(Point p : points ){
                p.y+=30;
            }
            try {
                sleep(sleepValue);
            } catch (InterruptedException ex) {
                Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }  
    }
    
    
    
    
    
    
}
