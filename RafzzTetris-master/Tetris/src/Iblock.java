
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
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
public class Iblock extends Block {
    
    private boolean state1 = true;
    private boolean state2 = false;
    protected BufferedImage basicBlock = loadImage("img/basicBlock2.gif");
    
    public Iblock() {
        this.block1 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter(),0));
        this.block2 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter()+mainSize,0));
        this.block3 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter()+mainSize*2,0));
        this.block4 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter()-mainSize,0));
        this.start();
        
        
    }

    
    
    @Override
    public void rotate(java.awt.event.KeyEvent evt){
        
        
        
        if(state1){
            
            switch(evt.getKeyCode()){
                
                
            case KeyEvent.VK_X: 
                block2.getPoint().y=block2.getPoint().y+mainSize;
                block2.getPoint().x=block2.getPoint().x-mainSize;
                block3.getPoint().x=block3.getPoint().x-mainSize*2;
                block3.getPoint().y=block3.getPoint().y+mainSize*2;
                block4.getPoint().x=block4.getPoint().x+mainSize;
                block4.getPoint().y=block4.getPoint().y+mainSize*3;
                break;
        
            }
            state1=false;
            state2=true;
            
        }else if(state2){
            switch(evt.getKeyCode()){
                
            case KeyEvent.VK_X:
                block2.getPoint().y=block2.getPoint().y-mainSize;
                block2.getPoint().x=block2.getPoint().x+mainSize;
                block3.getPoint().x=block3.getPoint().x+mainSize*2;
                block3.getPoint().y=block3.getPoint().y-mainSize*2;
                block4.getPoint().x=block4.getPoint().x-mainSize;
                block4.getPoint().y=block4.getPoint().y-mainSize*3;
            }
            state2=false;
            state1=true;
        }
        
        
        
    }

    

    
    
}
