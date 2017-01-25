
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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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

    private static  int boardW=300;  //musi byc 10 na 20 300/600
    
    private static  int boardH=600;
    
    private static final int widthBlockCount=boardW/Block.mainSize;
    
    private static  int boardCenter = boardW/2;
    
    private static final int refreshSpeed =10; //20

    public static int getBoardW() { return boardW; }
    
    public static int getBoardH() { return boardH; }
    
    public static int getBoardCenter() { return boardCenter; }
    
    public static int getWidthBlockCount() { return widthBlockCount; }
    
    private Timer timer;
    
    public void restart(){
        
        this.setFocusable(true);
        this.setVisible(true);
        blockList.clear();
        pointList.clear();
        boardCenter = boardW/2;
        blockList.add( Block.randBlock());
        GameMechanic.setNextBlock(Block.randBlock());
        GameMechanic.getNextBlock().suspend();               
        Prewiev.block=GameMechanic.getNextBlock();
        currentBlock = blockList.get(blockList.size()-1);
        blockList.get(blockList.size()-1).suspend();
        currentBlock.setSuspended(true);
        removePointList.clear();
        removeCount=0;
        layerCount=0;
        GameMechanic.setScore(0);
        timer = new Timer(refreshSpeed, actionListener);
        timer.start();
        
    }
    
    public void stop(){
        restart();
        Window.getPauseLabel().setText("<html>GAME OVER!<br>Your score: "+Window.getScoreLabel().getText()+"</html>");
        
    }
    
    private List<Block> blockList= new ArrayList<Block>();
    
    private List<Point> pointList = new ArrayList<Point>();
    
    private static Block currentBlock; 

    public static Block getCurrentBlock() { return currentBlock; }

    public static void setCurrentBlock(Block currentBlock) { Board.currentBlock = currentBlock; }
    
    private List<Point> removePointList = new ArrayList<Point>();
    
    private int removeCount=0;
    
    private static int  layerCount=0;

    public static void setLayerCount(int layerCount) { Board.layerCount = layerCount; }
    
    public static int getLayerCount() { return layerCount; }

    private ActionListener actionListener;
    
    
   
    
    
    public Board() {
       
        this.setFocusable(true);
        this.setVisible(true);

        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                
                repaint();
                
                Window.getBoard1().requestFocus(true);
                
                if(GameMechanic.gameOver(pointList)){ stop(); }
                
                GameMechanic.addBlockToBottom( currentBlock,  blockList,  pointList);

                GameMechanic.addBlockToStack( currentBlock,  blockList,  pointList);

                GameMechanic.removeLayer(removeCount,  layerCount, blockList,  pointList,  removePointList);

                GameMechanic.moveLayer(layerCount, blockList, pointList, removePointList);

                GameMechanic.verticalBorders(currentBlock);
   
              
            }
            
        };
        
        timer = new Timer(refreshSpeed, actionListener);
        timer.start();
        initComponents();
        boardCenter = boardW/2;
        blockList.add( Block.randBlock());
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
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
                blockList.get(blockList.size()-1).resume();
                currentBlock.setSuspended(false);
                Window.getPauseLabel().setText("");
        }
                
        if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){

            if(currentBlock.isSuspended()){
                blockList.get(blockList.size()-1).resume();
                currentBlock.setSuspended(false);
                Window.getPauseLabel().setText("");
                
            }else{
                blockList.get(blockList.size()-1).suspend();
                currentBlock.setSuspended(true);
                Window.getPauseLabel().setText("Pause!");

                
            }
            
            
        }
                
                

        
        if(evt.getKeyCode()==KeyEvent.VK_Q){
            restart();

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
