
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafzz
 */
public class Board extends javax.swing.JPanel {

    /**
     * Creates new form Board
     */
    
    //private Hashtable<Point,Block> dc = new Hashtable<Point,Block>();
    private static  int boardCenter;
    public static int getBoardCenter() {
        return boardCenter;
    }
    
    
    private static final int boardW=300;
    private static final int boardH=600;
    private int licz=0;
    private List<Block> blockList= new ArrayList<Block>();
    private List<Point> pointList = new ArrayList<Point>();
    private Block currentBlock; 
    
    private int border;
    
    private List<Point> removePointList = new ArrayList<Point>();
    
    int count=0;
    private int layerCount=0;
    
    public Board() {
        this.setFocusable(true);
        this.setSize(300, 600);
        
        
        
        //System.out.println(dc);
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                repaint();
                
                
                while(licz==0){
                    currentBlock = blockList.get(blockList.size()-1);
                                                                                        //570
                    if(currentBlock.block1!=null && currentBlock.block1.getPoint().y==boardH-Block.mainSize ||
                       currentBlock.block2!=null && currentBlock.block2.getPoint().y==boardH-Block.mainSize ||
                       currentBlock.block3!=null && currentBlock.block3.getPoint().y==boardH-Block.mainSize ||
                       currentBlock.block4!=null && currentBlock.block4.getPoint().y==boardH-Block.mainSize ){

                        if(currentBlock.block1!=null){
                                                
                                if(!pointList.contains(new Point(currentBlock.block1.getPoint().x,
                                        currentBlock.block1.getPoint().y))){
                                    
                                    pointList.add(new Point(currentBlock.block1.getPoint().x,
                                            currentBlock.block1.getPoint().y));
                                }

                        }
                        if(currentBlock.block2!=null){
                            
                            if(!pointList.contains(new Point(currentBlock.block2.getPoint().x,
                                    currentBlock.block2.getPoint().y))){
                                
                                pointList.add(new Point(currentBlock.block2.getPoint().x,
                                        currentBlock.block2.getPoint().y));
                            }
                        
                            
                        }
                        if(currentBlock.block3!=null){
                            
                            
                            if(!pointList.contains(new Point(currentBlock.block3.getPoint().x,
                                    currentBlock.block3.getPoint().y))){
                                
                                pointList.add(new Point(currentBlock.block3.getPoint().x,
                                        currentBlock.block3.getPoint().y));
                            }

                        }
                        if(currentBlock.block4!=null){
                            
                            
                            if(!pointList.contains(new Point(currentBlock.block4.getPoint().x,currentBlock.block4.getPoint().y))){
                                pointList.add(new Point(currentBlock.block4.getPoint().x,currentBlock.block4.getPoint().y));
                            }
                        
                            //pointList.add(new Point(currentBlock.block4.getPoint().x,currentBlock.block4.getPoint().y));
                        }

                        //currentBlock.suspend();
                        currentBlock.stop();
                        //currentBlock.setSuspended(true);
                   

                    //System.out.println(dc);
                }
                break;
                }
                
                
                
                for( Point p : pointList){
                    
                    currentBlock = blockList.get(blockList.size()-1);
                    //System.out.println("wchodze");
                    //if(currentBlock.isSuspended()){
                    if(!currentBlock.isAlive()){
                        //currentBlock= new Iblock();
                        blockList.add( Block.randBlock());
                        licz=0;
 
                    }
                    
                    if( currentBlock.block1!=null && p.y==currentBlock.block1.getPoint().y+30 && p.x==currentBlock.block1.getPoint().x || 
                            currentBlock.block2!=null && p.y==currentBlock.block2.getPoint().y+30 && p.x==currentBlock.block2.getPoint().x || 
                            currentBlock.block3!=null && p.y==currentBlock.block3.getPoint().y+30 && p.x==currentBlock.block3.getPoint().x || 
                            currentBlock.block4!=null && p.y==currentBlock.block4.getPoint().y+30 && p.x==currentBlock.block4.getPoint().x){

                        
                        
                        
                            if(currentBlock.block1!=null && !pointList.contains(new Point(currentBlock.block1.getPoint().x,currentBlock.block1.getPoint().y))){
                                pointList.add(new Point(currentBlock.block1.getPoint().x,currentBlock.block1.getPoint().y));
                            }
                        
                        //pointList.add(new Point(currentBlock.block1.getPoint().x,currentBlock.block1.getPoint().y));
                        
                        
                            if(currentBlock.block2!=null && !pointList.contains(new Point(currentBlock.block2.getPoint().x,currentBlock.block2.getPoint().y))){
                                pointList.add(new Point(currentBlock.block2.getPoint().x,currentBlock.block2.getPoint().y));
                            }
                        
                        //pointList.add(new Point(currentBlock.block2.getPoint().x,currentBlock.block2.getPoint().y));
                        
                        
                            if(currentBlock.block3!=null && !pointList.contains(new Point(currentBlock.block3.getPoint().x,currentBlock.block3.getPoint().y))){
                                pointList.add(new Point(currentBlock.block3.getPoint().x,currentBlock.block3.getPoint().y));
                            }
                        
                        //pointList.add(new Point(currentBlock.block3.getPoint().x,currentBlock.block3.getPoint().y));
                        
                        
                            if(currentBlock.block4!=null && !pointList.contains(new Point(currentBlock.block4.getPoint().x,currentBlock.block4.getPoint().y))){
                                pointList.add(new Point(currentBlock.block4.getPoint().x,currentBlock.block4.getPoint().y));
                            }
                        
                        //pointList.add(new Point(currentBlock.block4.getPoint().x,currentBlock.block4.getPoint().y));
                        //currentBlock.block.setIndex(pointList.size()-1);
                    
                        //currentBlock.suspend();
                        currentBlock.stop();
                        //currentBlock.setSuspended(true);

                        break;

                    }
                }
                
                
                for(int i=0;i<boardH;i+=Block.mainSize){
                    //System.out.println(i);
                    border=i;
                    count=0;
                    for(Block b : blockList){
                        //if(b.block1!=null && b.block1.getPoint().y==i && b.isSuspended()){
                        if(b.block1!=null && b.block1.getPoint().y==i && !b.isAlive()){
                            count++;
                            //System.out.println(count);
                        }
                        if(b.block2!=null && b.block2.getPoint().y==i && !b.isAlive()){
                            count++;
                            //System.out.println(count);
                        }
                        if(b.block3!=null && b.block3.getPoint().y==i && !b.isAlive()){
                            count++;
                            //System.out.println(count);
                        }
                        if(b.block4!=null && b.block4.getPoint().y==i && !b.isAlive()){
                            count++;
                            //System.out.println(count);
                        }
                    
                    }
                    
                    
                    if(count==10){
                        layerCount++;
                        removePointList.clear();
                        System.out.println(pointList);
                        for(Block b : blockList){
                            if(b.block1!=null && b.block1.getPoint().y==i && !b.isAlive()){
                                
                                //pointList.remove(b.block1.getPoint());
                                removePointList.add(b.block1.getPoint());
                                
                                
                                //pointList.removeAll(Collections.singleton(b.block1.getPoint()));
                                b.block1=null;
                            }
                            if(b.block2!=null && b.block2.getPoint().y==i && !b.isAlive()){
                                
                                //pointList.remove(b.block2.getPoint());
                                removePointList.add(b.block2.getPoint());
                                
                                b.block2=null;
                            }
                            if(b.block3!=null && b.block3.getPoint().y==i && !b.isAlive()){
                                
                                //pointList.remove(b.block3.getPoint());
                                removePointList.add(b.block3.getPoint());
                                b.block3=null;
                            }
                            if(b.block4!=null && b.block4.getPoint().y==i && !b.isAlive()){
                                
                                //pointList.remove(b.block4.getPoint());
                                removePointList.add(b.block4.getPoint());
                                b.block4=null;

                            }
                            //System.out.println(pointList);

                        }
                        pointList.removeAll(removePointList);
                        
                        /*
                        for(Block b : blockList){
                            if(b.isSuspended() && b.block1!=null && b.block1.getPoint().y<i || 
                                    b.isSuspended() && b.block2!=null && b.block2.getPoint().y<i || 
                                    b.isSuspended() && b.block3!=null && b.block3.getPoint().y<i || 
                                    b.isSuspended() && b.block4!=null && b.block4.getPoint().y<i){
                                    //System.out.println("JESTE!!!");
                                    //b.setSuspended();
                                    
                                    if(b.block1!=null){
                                        
                                        
                                            
                                        
                                        //if(pointList.indexOf(b.block1.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block1.getPoint()), new Point(b.block1.getPoint().x,b.block1.getPoint().y+30));
                             
                                        //}
                                        b.block1.getPoint().y+=30;
                                    }
                                    if(b.block2!=null){
                                        
                                        
                                        //if(pointList.indexOf(b.block2.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block2.getPoint()), new Point(b.block2.getPoint().x,b.block2.getPoint().y+30));
                                        //}
                                        b.block2.getPoint().y+=30;
                                    }
                                    if(b.block3!=null){
                                        
                                        
                                        //if(pointList.indexOf(b.block3.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block3.getPoint()), new Point(b.block3.getPoint().x,b.block3.getPoint().y+30));
                                        //}
                                        b.block3.getPoint().y+=30;
                                    }
                                    if(b.block4!=null){
                                        
                                        
                                        //if(pointList.indexOf(b.block4.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block4.getPoint()), new Point(b.block4.getPoint().x,b.block4.getPoint().y+30));
                                        //}
                                        
                                        b.block4.getPoint().y+=30;
                                        
                                    }
                                    
                                    
                                    
                                    
                                            
                            }
                            
                        }*/
                        
                    }
                    
                    
                    
                    
                
            
                }
                if(layerCount!=0){
                for(Block b : blockList){
                            if(!b.isAlive() && b.block1!=null && b.block1.getPoint().y<border || 
                                    !b.isAlive() && b.block2!=null && b.block2.getPoint().y<border  || 
                                    !b.isAlive() && b.block3!=null && b.block3.getPoint().y<border  || 
                                    !b.isAlive() && b.block4!=null && b.block4.getPoint().y<border ){
                                    //System.out.println("JESTE!!!");
                                    //b.setSuspended();
                                    
                                    if(b.block1!=null ){
                                        
                                        if(layerCount==1&& b.block1.getPoint().y<570){
                                            if(pointList.indexOf(b.block1.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block1.getPoint()), 
                                                    new Point(b.block1.getPoint().x,b.block1.getPoint().y+30));
                                        }
                                        b.block1.getPoint().y+=30;
                                            
                                        }else if(layerCount==2&& b.block1.getPoint().y<540){
                                            if(pointList.indexOf(b.block1.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block1.getPoint()), new Point(b.block1.getPoint().x,b.block1.getPoint().y+60));
                                        }
                                        b.block1.getPoint().y+=60;
                                        }else if(layerCount==3&& b.block1.getPoint().y<510){
                                            if(pointList.indexOf(b.block1.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block1.getPoint()), new Point(b.block1.getPoint().x,b.block1.getPoint().y+90));
                                        }
                                        b.block1.getPoint().y+=90;
                                        }else if(layerCount==4&& b.block1.getPoint().y<470){
                                            if(pointList.indexOf(b.block1.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block1.getPoint()), new Point(b.block1.getPoint().x,b.block1.getPoint().y+120));
                                        }
                                        b.block1.getPoint().y+=120;
                                        }
                                        
                                            
                                        
                                        
                                    }
                                    if(b.block2!=null){
                                        
                                        
                                        if(layerCount==1 && b.block2.getPoint().y<570){
                                            if(pointList.indexOf(b.block2.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block2.getPoint()), new Point(b.block2.getPoint().x,b.block2.getPoint().y+30));
                                        }
                                        b.block2.getPoint().y+=30;
                                            
                                        }else if(layerCount==2 && b.block2.getPoint().y<540){
                                            if(pointList.indexOf(b.block2.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block2.getPoint()), new Point(b.block2.getPoint().x,b.block2.getPoint().y+60));
                                        }
                                        b.block2.getPoint().y+=60;
                                        }else if(layerCount==3 && b.block2.getPoint().y<510){
                                            if(pointList.indexOf(b.block2.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block2.getPoint()), new Point(b.block2.getPoint().x,b.block2.getPoint().y+90));
                                        }
                                        b.block2.getPoint().y+=90;
                                        }else if(layerCount==4 && b.block2.getPoint().y<470){
                                            if(pointList.indexOf(b.block2.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block2.getPoint()), new Point(b.block2.getPoint().x,b.block2.getPoint().y+120));
                                        }
                                        b.block2.getPoint().y+=120;
                                        }
                                    }
                                    if(b.block3!=null){
                                        
                                        
                                        if(layerCount==1 && b.block3.getPoint().y<570){
                                            if(pointList.indexOf(b.block3.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block3.getPoint()), new Point(b.block3.getPoint().x,b.block3.getPoint().y+30));
                                        }
                                        b.block3.getPoint().y+=30;
                                            
                                        }else if(layerCount==2 && b.block3.getPoint().y<540){
                                            if(pointList.indexOf(b.block3.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block3.getPoint()), new Point(b.block3.getPoint().x,b.block3.getPoint().y+60));
                                        }
                                        b.block3.getPoint().y+=60;
                                        }else if(layerCount==3 && b.block3.getPoint().y<510){
                                            if(pointList.indexOf(b.block3.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block3.getPoint()), new Point(b.block3.getPoint().x,b.block3.getPoint().y+90));
                                        }
                                        b.block3.getPoint().y+=90;
                                        }else if(layerCount==4 && b.block3.getPoint().y<470){
                                            if(pointList.indexOf(b.block3.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block3.getPoint()), new Point(b.block3.getPoint().x,b.block3.getPoint().y+120));
                                        }
                                        b.block3.getPoint().y+=120;
                                        }
                                    }
                                    if(b.block4!=null){
                                        
                                        
                                       if(layerCount==1 && b.block4.getPoint().y<570){
                                            if(pointList.indexOf(b.block4.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block4.getPoint()), new Point(b.block4.getPoint().x,b.block4.getPoint().y+30));
                                        }
                                        b.block4.getPoint().y+=30;
                                            
                                        }else if(layerCount==2 && b.block4.getPoint().y<540){
                                            if(pointList.indexOf(b.block4.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block4.getPoint()), new Point(b.block4.getPoint().x,b.block4.getPoint().y+60));
                                        }
                                        b.block4.getPoint().y+=60;
                                        }else if(layerCount==3 && b.block4.getPoint().y<510){
                                            if(pointList.indexOf(b.block4.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block4.getPoint()), new Point(b.block4.getPoint().x,b.block4.getPoint().y+90));
                                        }
                                        b.block4.getPoint().y+=90;
                                        }else if(layerCount==4 && b.block4.getPoint().y<470){
                                            if(pointList.indexOf(b.block4.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block4.getPoint()), new Point(b.block4.getPoint().x,b.block4.getPoint().y+120));
                                        }
                                        b.block4.getPoint().y+=120;
                                        }
                                        
                                        
                                        
                                    }
                                    
                                    
                                    
                                    
                                            
                            }
                            
                        }layerCount=0;
                    }
            }
        };
        Timer timer = new Timer(10, actionListener);
        timer.start();
        
        initComponents();
        
        
        boardCenter = boardW/2;
        blockList.add( Block.randBlock());
        currentBlock = blockList.get(blockList.size()-1);
        
    }
    
    
    
    @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                
                for(Block b : blockList){
                    if(b!=null){
                        b.draw(g2d,this);
                    }
                    
                }
                //int blockCount=0;
                for(Point p : pointList){
                    
                    //blockCount++;
                    
                    //g2d.drawOval(p.x, p.y, 30, 30);
                    
                    //g2d.drawString(String.valueOf(blockCoun), p.x+15, p.y+15);
                    
                }
                for(Point p : removePointList){
                    //g2d.drawRect(p.x, p.y, 30, 30);
                    //g2d.drawLine(p.x, p.y, p.x+30, p.y+30);
                }
                
               
	}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_T){
                blockList.get(0).suspend();
                currentBlock.setSuspended(true);
        }
        if(evt.getKeyCode()==KeyEvent.VK_R){
                blockList.get(0).resume();
                currentBlock.setSuspended(false);

        }
        if(evt.getKeyCode()==KeyEvent.VK_X){
            if(currentBlock.isAlive() && !currentBlock.isSuspended()){
                currentBlock.rotate(evt);
            }
            
        }else if(evt.getKeyCode()==KeyEvent.VK_RIGHT || evt.getKeyCode()==KeyEvent.VK_LEFT || evt.getKeyCode()==KeyEvent.VK_DOWN){
            if(currentBlock.isAlive() && !currentBlock.isSuspended()){
                currentBlock.move(evt);
            }
            
        }
        
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
