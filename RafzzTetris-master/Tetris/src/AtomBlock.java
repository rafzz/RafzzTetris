
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
public class AtomBlock {
    private Point point;
    
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    

    public Point getPoint() {
        return point;
    }

    public BufferedImage getImage() {
        return image;
    }
    private BufferedImage image;
    
    private int  upBorder;
    private int downBorder;
   

    public AtomBlock(BufferedImage image, Point point) {
        this.image = image;
        this.point = point;
        
    }

   
    
    
}
