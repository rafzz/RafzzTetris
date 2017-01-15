
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
import java.util.Random;
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
    
    protected static int mainSize=30;
    private int sleepValue=700;
    protected boolean suspended = false;

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }
    
    protected AtomBlock block1;
    protected AtomBlock block2;
    protected AtomBlock block3;
    protected AtomBlock block4;
    
    public void rotate(java.awt.event.KeyEvent evt){}
    
    
    public void draw(Graphics2D g,ImageObserver io){
        if(block1!=null){
            g.drawImage(block1.getImage(),this.block1.getPoint().x,this.block1.getPoint().y,io);
            g.drawString(String.valueOf(this.getId()), this.block1.getPoint().x+15, this.block1.getPoint().y+15);
        }
        if(block2!=null){
            g.drawImage(block2.getImage(),this.block2.getPoint().x,this.block2.getPoint().y,io);
            g.drawString(String.valueOf(this.getId()), this.block2.getPoint().x+15, this.block2.getPoint().y+15);
        }
        if(block3!=null){
            g.drawImage(block3.getImage(),this.block3.getPoint().x,this.block3.getPoint().y,io);
            g.drawString(String.valueOf(this.getId()), this.block3.getPoint().x+15, this.block3.getPoint().y+15);
        }
        if(block4!=null){
            g.drawImage(block4.getImage(),this.block4.getPoint().x,this.block4.getPoint().y,io);
            g.drawString(String.valueOf(this.getId()), this.block4.getPoint().x+15, this.block4.getPoint().y+15);
        }
        
        
    }
    
    public void move(java.awt.event.KeyEvent evt){
        
        switch(evt.getKeyCode()){
                
                
            case KeyEvent.VK_RIGHT: 
                //if(block1.getPoint().x!=300-mainSize && block2.getPoint().x!=300-mainSize && block3.getPoint().x!=300-mainSize && block4.getPoint().x!=300-mainSize){
                    block1.getPoint().x+=30;
                    block2.getPoint().x+=30;
                    block3.getPoint().x+=30;
                    block4.getPoint().x+=30;
                //}
                

                break;
            
            case KeyEvent.VK_LEFT: 
                block1.getPoint().x-=30;
                block2.getPoint().x-=30;
                block3.getPoint().x-=30;
                block4.getPoint().x-=30;
                break;
                
            case KeyEvent.VK_DOWN: 
                block1.getPoint().y+=30;
                block2.getPoint().y+=30;
                block3.getPoint().y+=30;
                block4.getPoint().y+=30;
                break;
        
            }
    }
    
    public static Block randBlock(){
        Random rand = new Random(); 
        //int randInt= rand.nextInt(1);
        
        switch(rand.nextInt(7)){
            case 0:
                return new Iblock();
            case 1:
                return new Zblock();
            case 2:
                return new Sblock();
            case 3:
                return new Oblock();
            case 4:
                return new Tblock();
            case 5:
                return new Lblock();
            case 6:
                return new Jblock();
            
                
        }
        return null;
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
            /*
            for(Point p : points ){
                p.y+=30;
            }*/
            block1.getPoint().y+=30;
            block2.getPoint().y+=30;
            block3.getPoint().y+=30;
            block4.getPoint().y+=30;
            try {
                sleep(sleepValue);
            } catch (InterruptedException ex) {
                Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }  
    }
    
    
    
    
    
    
}
