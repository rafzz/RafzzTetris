

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafzz
 */
public class Sblock extends Block{
    
    private boolean state1=true;
    private boolean state2=false;
    
    protected BufferedImage basicBlock = loadImage("img/basicBlock3.gif");
    
    public Sblock() {
        this.block1 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter(),0));
        this.block2 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter()-mainSize,0));
        this.block3 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter(),mainSize));
        this.block4 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter()+mainSize,mainSize));
        this.start();
    }
    
    public void rotate(java.awt.event.KeyEvent evt){
        
        
        
        if(state1){
            switch(evt.getKeyCode()){
            case KeyEvent.VK_X: 
                block2.getPoint().y=block2.getPoint().y-mainSize;
                block2.getPoint().x=block2.getPoint().x+mainSize;
                block3.getPoint().x=block3.getPoint().x-mainSize;
                block3.getPoint().y=block3.getPoint().y-mainSize;
                block4.getPoint().x=block4.getPoint().x-mainSize*2;
                break;
            }
            state1=false;
            state2=true;
            
            
        }else if(state2){
            switch(evt.getKeyCode()){
            case KeyEvent.VK_X:
                block2.getPoint().y=block2.getPoint().y+mainSize;
                block2.getPoint().x=block2.getPoint().x-mainSize;
                block3.getPoint().x=block3.getPoint().x+mainSize;
                block3.getPoint().y=block3.getPoint().y+mainSize;
                block4.getPoint().x=block4.getPoint().x+mainSize*2;
                break;
            }
            state1=true;
            state2=false;
            
            
        }
        
        
    }
    
}
