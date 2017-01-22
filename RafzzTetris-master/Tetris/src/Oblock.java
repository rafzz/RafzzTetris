

import java.awt.Point;
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
public class Oblock extends Block {
    
    protected BufferedImage basicBlock = loadImage("img/basicBlock4.gif");
    
    public Oblock() {
        this.block1 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter(),0));
        this.block2 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter()-mainSize,0));
        this.block3 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter(),mainSize));
        this.block4 = new AtomBlock(basicBlock,new Point(Board.getBoardCenter()-mainSize,mainSize));
        this.start();
    }
}
