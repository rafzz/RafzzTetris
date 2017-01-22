
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    
    
    
    public static int getBoardCenter() { return boardCenter; }
    
    private static final int boardW=300;  //musi byc 10 na 20 300/600
    private static final int boardH=600;
    private static final int widthBlockCount=boardW/Block.mainSize;
    private static  int boardCenter = boardW/2;
    
    
    private static final int gameSpeed =10; //20

    public static int getBoardW() { return boardW; }
    public static int getBoardH() { return boardH; }
    public static int getWidthBlockCount() { return widthBlockCount; }
    
    
    
    
    //private int licz=0;
    private List<Block> blockList= new ArrayList<Block>();
    private List<Point> pointList = new ArrayList<Point>();
    private static Block currentBlock; 

    public static Block getCurrentBlock() {
        return currentBlock;
    }

    public static void setCurrentBlock(Block currentBlock) {
        Board.currentBlock = currentBlock;
    }
    
    private int border;
    
    private List<Point> removePointList = new ArrayList<Point>();
    
    int count=0;
    static int  layerCount=0;

    public static void setLayerCount(int layerCount) { Board.layerCount = layerCount; }
    public static int getLayerCount() { return layerCount; }

    
    
    public Board() {
        this.setFocusable(true);
        //this.setSize(Board.getBoardW(), Board.getBoardH());
        //this.setLayout(new FlowLayout());
        
        //this.setPreferredSize(new Dimension(Board.getBoardW(), Board.getBoardH()));
        this.setVisible(true);
        
        
        
        
        
        
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                repaint();
                
                
                GameMechanic.addBlockToBottom( currentBlock,  blockList,  pointList);
                /*
                //while(true){
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

                    
                        currentBlock.stop();

                }
                //break;
                //}
                */
                
                
                
                GameMechanic.addBlockToStack( currentBlock,  blockList,  pointList);
                
                
                GameMechanic.removeLayer( count,  layerCount, blockList,  pointList,  removePointList);
                
                
                
                GameMechanic.moveLayer(layerCount, blockList, pointList, removePointList);
                
                
                GameMechanic.verticalBorders(currentBlock);
   
              
            }
            
        };
        Timer timer = new Timer(gameSpeed, actionListener);
        timer.start();
        
        initComponents();
        
        
        boardCenter = boardW/2;
        blockList.add( Block.randBlock());
        //blockList.add( new Sblock());
        
        //nextBlock=Block.randBlock();
        GameMechanic.setNextBlock(Block.randBlock());
        GameMechanic.getNextBlock().suspend();
                        
        Prewiev.block=GameMechanic.getNextBlock();
        
        currentBlock = blockList.get(blockList.size()-1);
        blockList.get(blockList.size()-1).suspend();
        currentBlock.setSuspended(true);
        
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
                
                //GameMechanic.getPr().repaint();
                
                
                
                
	}
    
    
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
                blockList.get(blockList.size()-1).suspend();
                currentBlock.setSuspended(true);
        }
        if(evt.getKeyCode()==KeyEvent.VK_R){
                blockList.get(blockList.size()-1).resume();
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
