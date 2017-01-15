

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
public class Lblock extends Block{
    
    private boolean state1=true;
    private boolean state2=false;
    private boolean state3=false;
    private boolean state4=false;
    
    protected BufferedImage basicBlock = loadImage("img/basicBlock6.gif");
    
    public Lblock() {
        this.block1 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter(),0));
        this.block2 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter()-mainSize,0));
        this.block3 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter()-mainSize*2,0));
        this.block4 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter(),mainSize));
        this.start();
    }
    
    public void rotate(java.awt.event.KeyEvent evt){
        
        
        
        if(state1){
            switch(evt.getKeyCode()){
            case KeyEvent.VK_X: 
                block2.getPoint().y=block2.getPoint().y-mainSize;
                block2.getPoint().x=block2.getPoint().x+mainSize;
                
                block3.getPoint().x=block3.getPoint().x+mainSize*2;
                block3.getPoint().y=block3.getPoint().y-mainSize*2;
                
                block4.getPoint().x=block4.getPoint().x-mainSize;
                block4.getPoint().y=block4.getPoint().y-mainSize;
                break;
            }
            state1=false;
            state2=true;
            state3=false;
            state4=false;
            
            
        }else if(state2){
            switch(evt.getKeyCode()){
            case KeyEvent.VK_X:
                block2.getPoint().y=block2.getPoint().y+mainSize;
                block2.getPoint().x=block2.getPoint().x+mainSize;
                
                block3.getPoint().x=block3.getPoint().x+mainSize*2;
                block3.getPoint().y=block3.getPoint().y+mainSize*2;
                block4.getPoint().y=block4.getPoint().y-mainSize;
                block4.getPoint().x=block4.getPoint().x+mainSize;
                break;
            }
            state1=false;
            state2=false;
            state3=true;
            state4=false;
            
            
        }else if(state3){
            switch(evt.getKeyCode()){
            case KeyEvent.VK_X:
                block2.getPoint().y=block2.getPoint().y+mainSize;
                block2.getPoint().x=block2.getPoint().x-mainSize;
                
                block3.getPoint().x=block3.getPoint().x-mainSize*2;
                block3.getPoint().y=block3.getPoint().y+mainSize*2;
                
                block4.getPoint().x=block4.getPoint().x+mainSize;
                block4.getPoint().y=block4.getPoint().y+mainSize;
                break;
            }
            state1=false;
            state2=false;
            state3=false;
            state4=true;
            
            
        }else if(state4){
            switch(evt.getKeyCode()){
            case KeyEvent.VK_X:
                block2.getPoint().y=block2.getPoint().y-mainSize;
                block2.getPoint().x=block2.getPoint().x-mainSize;
                
                block3.getPoint().x=block3.getPoint().x-mainSize*2;
                block3.getPoint().y=block3.getPoint().y-mainSize*2;
                
                block4.getPoint().x=block4.getPoint().x-mainSize;
                block4.getPoint().y=block4.getPoint().y+mainSize;
                break;
            }
            state1=true;
            state2=false;
            state3=false;
            state4=false;
            
            
        }
        
        
    }
}
