
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
    
    protected static final int mainSize=30;
    
    private static int gameSpeed=700; //300 

    public static int getGameSpeed() { return gameSpeed; }

    public static void setGameSpeed(int gameSpeed) { Block.gameSpeed = gameSpeed; }
    
    protected boolean suspended = false;
    
    private static final int arcSize=15;
    
    private static final int randRange=7; //zalezy od ilosci klockow

    public boolean isSuspended() { return suspended; }

    public void setSuspended(boolean suspended) { this.suspended = suspended; }
    
    protected AtomBlock block1;
    
    protected AtomBlock block2;
    
    protected AtomBlock block3;
    
    protected AtomBlock block4;
    
    public void rotate(java.awt.event.KeyEvent evt){}
    
    public void drawPreview(Graphics2D g,ImageObserver io){
        if(block1!=null){
            g.drawImage(block1.getImage(),this.block1.getPoint().x-mainSize*2,this.block1.getPoint().y+mainSize*2,io);
            g.drawRoundRect(this.block1.getPoint().x-mainSize*2,this.block1.getPoint().y+mainSize*2,mainSize , mainSize, arcSize, arcSize);
        }
        if(block2!=null){
            g.drawImage(block2.getImage(),this.block2.getPoint().x-mainSize*2,this.block2.getPoint().y+mainSize*2,io);
            g.drawRoundRect(this.block2.getPoint().x-mainSize*2,this.block2.getPoint().y+mainSize*2,mainSize , mainSize, arcSize, arcSize);
        }
        if(block3!=null){
            g.drawImage(block3.getImage(),this.block3.getPoint().x-mainSize*2,this.block3.getPoint().y+mainSize*2,io);
            g.drawRoundRect(this.block3.getPoint().x-mainSize*2,this.block3.getPoint().y+mainSize*2,mainSize , mainSize, arcSize, arcSize);
        }
        if(block4!=null){
            g.drawImage(block4.getImage(),this.block4.getPoint().x-mainSize*2,this.block4.getPoint().y+mainSize*2,io);
            g.drawRoundRect(this.block4.getPoint().x-mainSize*2,this.block4.getPoint().y+mainSize*2,mainSize , mainSize, arcSize, arcSize);
        }
        
        
            
    }
    
    
    public void draw(Graphics2D g,ImageObserver io){
        if(block1!=null){
            g.drawImage(block1.getImage(),this.block1.getPoint().x,this.block1.getPoint().y,io);
            g.drawRoundRect(this.block1.getPoint().x,this.block1.getPoint().y,mainSize , mainSize, arcSize, arcSize);
        }
        if(block2!=null){
            g.drawImage(block2.getImage(),this.block2.getPoint().x,this.block2.getPoint().y,io);
            g.drawRoundRect(this.block2.getPoint().x,this.block2.getPoint().y,mainSize , mainSize, arcSize, arcSize);
        }
        if(block3!=null){
            g.drawImage(block3.getImage(),this.block3.getPoint().x,this.block3.getPoint().y,io);
            g.drawRoundRect(this.block3.getPoint().x,this.block3.getPoint().y,mainSize , mainSize, arcSize, arcSize);
        }
        if(block4!=null){
            g.drawImage(block4.getImage(),this.block4.getPoint().x,this.block4.getPoint().y,io);
            g.drawRoundRect(this.block4.getPoint().x,this.block4.getPoint().y,mainSize , mainSize, arcSize, arcSize);
        }
        
        
    }
    
    public void move(java.awt.event.KeyEvent evt){
        
        switch(evt.getKeyCode()){
                
                
            case KeyEvent.VK_RIGHT: 
                if(block1.getPoint().x!=Board.getBoardW()-mainSize && 
                        block2.getPoint().x!=Board.getBoardW()-mainSize && 
                        block3.getPoint().x!=Board.getBoardW()-mainSize && 
                        block4.getPoint().x!=Board.getBoardW()-mainSize){
                    block1.getPoint().x+=mainSize;
                    block2.getPoint().x+=mainSize;
                    block3.getPoint().x+=mainSize;
                    block4.getPoint().x+=mainSize;
                }
                

                break;
            case KeyEvent.VK_LEFT: 
                if(block1.getPoint().x!=0 && 
                            block2.getPoint().x!=0 && 
                            block3.getPoint().x!=0 && 
                            block4.getPoint().x!=0){

                    block1.getPoint().x-=mainSize;
                    block2.getPoint().x-=mainSize;
                    block3.getPoint().x-=mainSize;
                    block4.getPoint().x-=mainSize;
                }
                break;
                
            case KeyEvent.VK_DOWN: 
                block1.getPoint().y+=mainSize;
                block2.getPoint().y+=mainSize;
                block3.getPoint().y+=mainSize;
                block4.getPoint().y+=mainSize;
                break;
        
            }
    }
    
    public static Block randBlock(){
        Random rand = new Random(); 
        
        switch(rand.nextInt(randRange)){
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
            
            block1.getPoint().y+=mainSize;
            block2.getPoint().y+=mainSize;
            block3.getPoint().y+=mainSize;
            block4.getPoint().y+=mainSize;
            try {
                sleep(gameSpeed);
            } catch (InterruptedException ex) {
                Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
        }  
    }
    
    
    
    
    
    
}
