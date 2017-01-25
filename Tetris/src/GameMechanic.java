

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafzz
 */
public class GameMechanic {
    
    private static int score=0;
    
    public static int getScore() { return score; }

    public static void setScore(int score) { GameMechanic.score = score; }
    
    private static Block nextBlock;

    public static Block getNextBlock() { return nextBlock; }

    public static void setNextBlock(Block nextBlock) { GameMechanic.nextBlock = nextBlock; }
    

    public static void verticalBorders(Block currentBlock){
        if(currentBlock.block1!=null && currentBlock.block1.getPoint().x>Board.getBoardW()-Block.mainSize || 
                    currentBlock.block2!=null && currentBlock.block2.getPoint().x>Board.getBoardW()-Block.mainSize || 
                    currentBlock.block3!=null && currentBlock.block3.getPoint().x>Board.getBoardW()-Block.mainSize ||
                    currentBlock.block4!=null && currentBlock.block4.getPoint().x>Board.getBoardW()-Block.mainSize){
                
                currentBlock.block1.getPoint().x=currentBlock.block1.getPoint().x-Block.mainSize;
                currentBlock.block2.getPoint().x=currentBlock.block2.getPoint().x-Block.mainSize;
                currentBlock.block3.getPoint().x=currentBlock.block3.getPoint().x-Block.mainSize;
                currentBlock.block4.getPoint().x=currentBlock.block4.getPoint().x-Block.mainSize;
                }
                if(currentBlock.block1!=null && currentBlock.block1.getPoint().x<0|| 
                    currentBlock.block2!=null && currentBlock.block2.getPoint().x<0 || 
                    currentBlock.block3!=null && currentBlock.block3.getPoint().x<0 ||
                    currentBlock.block4!=null && currentBlock.block4.getPoint().x<0){
                
                currentBlock.block1.getPoint().x=currentBlock.block1.getPoint().x+Block.mainSize;
                currentBlock.block2.getPoint().x=currentBlock.block2.getPoint().x+Block.mainSize;
                currentBlock.block3.getPoint().x=currentBlock.block3.getPoint().x+Block.mainSize;
                currentBlock.block4.getPoint().x=currentBlock.block4.getPoint().x+Block.mainSize;
                }
    }
    
    public static void  moveLayer(int layerCount, List<Block> blockList, List<Point> pointList, List<Point> removePointList){
        
        if(layerCount==1){
           score+=10; 
        }else if(layerCount==2){
           score+=20; 
        }else if(layerCount==3){
           score+=30; 
        }else if(layerCount==4){
           score+=50; 
        }
        Window.getScoreLabel().setText(String.valueOf(score));
        
        if(Integer.parseInt(Window.getRecordLabel().getText())<Integer.parseInt(Window.getScoreLabel().getText())){
            Window.getRecordLabel().setText(Window.getScoreLabel().getText());
        }
        
        if(Board.getLayerCount()!=0){
                for(Block b : blockList){
                            if(!b.isAlive() && b.block1!=null && b.block1.getPoint().y<removePointList.get(0).y || 
                                    !b.isAlive() && b.block2!=null && b.block2.getPoint().y<removePointList.get(0).y   || 
                                    !b.isAlive() && b.block3!=null && b.block3.getPoint().y<removePointList.get(0).y   || 
                                    !b.isAlive() && b.block4!=null && b.block4.getPoint().y<removePointList.get(0).y  ){

                                    
                                    if(b.block1!=null ){
                                        
                                        if(layerCount==1&& b.block1.getPoint().y<Board.getBoardH()-Block.mainSize){
                                            if(pointList.indexOf(b.block1.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block1.getPoint()), 
                                                    new Point(b.block1.getPoint().x,b.block1.getPoint().y+Block.mainSize));
                                        }
                                        b.block1.getPoint().y+=Block.mainSize;
                                            
                                        }else if(layerCount==2&& b.block1.getPoint().y<Board.getBoardH()-Block.mainSize*2){
                                            if(pointList.indexOf(b.block1.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block1.getPoint()), new Point(b.block1.getPoint().x,b.block1.getPoint().y+Block.mainSize*2));
                                        }
                                        b.block1.getPoint().y+=Block.mainSize*2;
                                        
                                        }else if(layerCount==3&& b.block1.getPoint().y<Board.getBoardH()-Block.mainSize*3){
                                            if(pointList.indexOf(b.block1.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block1.getPoint()), new Point(b.block1.getPoint().x,b.block1.getPoint().y+Block.mainSize*3));
                                        }
                                        b.block1.getPoint().y+=Block.mainSize*3;
                                        }else if(layerCount==4&& b.block1.getPoint().y<Board.getBoardH()-Block.mainSize*4){
                                            if(pointList.indexOf(b.block1.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block1.getPoint()), new Point(b.block1.getPoint().x,b.block1.getPoint().y+Block.mainSize*4));
                                        }
                                        b.block1.getPoint().y+=Block.mainSize*4;
                                        }
                                        
                                            
                                        
                                        
                                    }
                                    if(b.block2!=null){
                                        
                                        
                                        if(layerCount==1 && b.block2.getPoint().y<Board.getBoardH()-Block.mainSize){
                                            if(pointList.indexOf(b.block2.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block2.getPoint()), new Point(b.block2.getPoint().x,b.block2.getPoint().y+Block.mainSize));
                                        }
                                        b.block2.getPoint().y+=Block.mainSize;
                                            
                                        }else if(layerCount==2 && b.block2.getPoint().y<Board.getBoardH()-Block.mainSize*2){
                                            if(pointList.indexOf(b.block2.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block2.getPoint()), new Point(b.block2.getPoint().x,b.block2.getPoint().y+Block.mainSize*2));
                                        }
                                        b.block2.getPoint().y+=Block.mainSize*2;
                                        }else if(layerCount==3 && b.block2.getPoint().y<Board.getBoardH()-Block.mainSize*3){
                                            if(pointList.indexOf(b.block2.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block2.getPoint()), new Point(b.block2.getPoint().x,b.block2.getPoint().y+Block.mainSize*3));
                                        }
                                        b.block2.getPoint().y+=Block.mainSize*3;
                                        }else if(layerCount==4 && b.block2.getPoint().y<Board.getBoardH()-Block.mainSize*4){
                                            if(pointList.indexOf(b.block2.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block2.getPoint()), new Point(b.block2.getPoint().x,b.block2.getPoint().y+Block.mainSize*4));
                                        }
                                        b.block2.getPoint().y+=Block.mainSize*4;
                                        }
                                    }
                                    if(b.block3!=null){
                                        
                                        
                                        if(layerCount==1 && b.block3.getPoint().y<Board.getBoardH()-Block.mainSize){
                                            if(pointList.indexOf(b.block3.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block3.getPoint()), new Point(b.block3.getPoint().x,b.block3.getPoint().y+Block.mainSize));
                                        }
                                        b.block3.getPoint().y+=Block.mainSize;
                                            
                                        }else if(layerCount==2 && b.block3.getPoint().y<Board.getBoardH()-Block.mainSize*2){
                                            if(pointList.indexOf(b.block3.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block3.getPoint()), new Point(b.block3.getPoint().x,b.block3.getPoint().y+Block.mainSize*2));
                                        }
                                        b.block3.getPoint().y+=Block.mainSize*2;
                                        }else if(layerCount==3 && b.block3.getPoint().y<Board.getBoardH()-Block.mainSize*3){
                                            if(pointList.indexOf(b.block3.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block3.getPoint()), new Point(b.block3.getPoint().x,b.block3.getPoint().y+Block.mainSize*3));
                                        }
                                        b.block3.getPoint().y+=Block.mainSize*3;
                                        }else if(layerCount==4 && b.block3.getPoint().y<Board.getBoardH()-Block.mainSize*4){
                                            if(pointList.indexOf(b.block3.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block3.getPoint()), new Point(b.block3.getPoint().x,b.block3.getPoint().y+Block.mainSize*4));
                                        }
                                        b.block3.getPoint().y+=Block.mainSize*4;
                                        }
                                    }
                                    if(b.block4!=null){
                                        
                                        
                                       if(layerCount==1 && b.block4.getPoint().y<Board.getBoardH()-Block.mainSize){
                                            if(pointList.indexOf(b.block4.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block4.getPoint()), new Point(b.block4.getPoint().x,b.block4.getPoint().y+Block.mainSize));
                                        }
                                        b.block4.getPoint().y+=Block.mainSize;
                                            
                                        }else if(layerCount==2 && b.block4.getPoint().y<Board.getBoardH()-Block.mainSize*2){
                                            if(pointList.indexOf(b.block4.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block4.getPoint()), new Point(b.block4.getPoint().x,b.block4.getPoint().y+Block.mainSize*2));
                                        }
                                        b.block4.getPoint().y+=Block.mainSize*2;
                                        }else if(layerCount==3 && b.block4.getPoint().y<Board.getBoardH()-Block.mainSize*3){
                                            if(pointList.indexOf(b.block4.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block4.getPoint()), new Point(b.block4.getPoint().x,b.block4.getPoint().y+Block.mainSize*3));
                                        }
                                        b.block4.getPoint().y+=Block.mainSize*3;
                                        }else if(layerCount==4 && b.block4.getPoint().y<Board.getBoardH()-Block.mainSize*4){
                                            if(pointList.indexOf(b.block4.getPoint())!=-1){
                                            pointList.set(pointList.indexOf(b.block4.getPoint()), new Point(b.block4.getPoint().x,b.block4.getPoint().y+Block.mainSize*4));
                                        }
                                        b.block4.getPoint().y+=Block.mainSize*4;
                                        }
                                    }         
                            }
                        
                    }Board.setLayerCount(0);
        }
        
    }
    
    public static boolean gameOver(List<Point> pointList){
        if(!pointList.isEmpty() && pointList.get(pointList.size()-1).y==Block.mainSize){
                    return true;
                    
        }
        return false;
    }
    
    public static void  removeLayer(int count, int layerCount,List<Block> blockList, List<Point> pointList, List<Point> removePointList){
        for(int i=0;i<Board.getBoardH();i+=Block.mainSize){

                    count=0;
                    for(Block b : blockList){
                        if(b.block1!=null && b.block1.getPoint().y==i && !b.isAlive()){
                            count++;

                        }
                        if(b.block2!=null && b.block2.getPoint().y==i && !b.isAlive()){
                            count++;

                        }
                        if(b.block3!=null && b.block3.getPoint().y==i && !b.isAlive()){
                            count++;

                        }
                        if(b.block4!=null && b.block4.getPoint().y==i && !b.isAlive()){
                            count++;

                        }
                    
                    }
                    
                    
                    if(count==Board.getWidthBlockCount() ){
                        
                        Board.setLayerCount(Board.getLayerCount()+1);
                        removePointList.clear();

                        for(Block b : blockList){
                            if(b.block1!=null && b.block1.getPoint().y==i && !b.isAlive()){
                                

                                removePointList.add(b.block1.getPoint());
                                
                                

                                b.block1=null;
                            }
                            if(b.block2!=null && b.block2.getPoint().y==i && !b.isAlive()){
                                

                                removePointList.add(b.block2.getPoint());
                                
                                b.block2=null;
                            }
                            if(b.block3!=null && b.block3.getPoint().y==i && !b.isAlive()){
                                

                                removePointList.add(b.block3.getPoint());
                                b.block3=null;
                            }
                            if(b.block4!=null && b.block4.getPoint().y==i && !b.isAlive()){
                                

                                removePointList.add(b.block4.getPoint());
                                b.block4=null;

                            }


                        }
                        pointList.removeAll(removePointList);
  
                    }

                }
    }
    
    public static void  addBlockToStack(Block currentBlock, List<Block> blockList, List<Point> pointList){
        
                     
        for( Point p : pointList){
                    
                    currentBlock = blockList.get(blockList.size()-1);

                    if(!currentBlock.isAlive()){
                        
                        blockList.add(nextBlock);
                        nextBlock.resume();
                        nextBlock=null;
 
                    }else if(currentBlock.isAlive() && nextBlock==null){
                        nextBlock=Block.randBlock();
                        nextBlock.suspend();

                        Prewiev.block=nextBlock;

                    }

                    if( currentBlock.block1!=null && p.y==currentBlock.block1.getPoint().y+30 && p.x==currentBlock.block1.getPoint().x || 
                            currentBlock.block2!=null && p.y==currentBlock.block2.getPoint().y+30 && p.x==currentBlock.block2.getPoint().x || 
                            currentBlock.block3!=null && p.y==currentBlock.block3.getPoint().y+30 && p.x==currentBlock.block3.getPoint().x || 
                            currentBlock.block4!=null && p.y==currentBlock.block4.getPoint().y+30 && p.x==currentBlock.block4.getPoint().x){

                        
                        
                        
                            if(currentBlock.block1!=null && !pointList.contains(new Point(currentBlock.block1.getPoint().x,currentBlock.block1.getPoint().y))){
                                pointList.add(new Point(currentBlock.block1.getPoint().x,currentBlock.block1.getPoint().y));
                            }
                        

                        
                        
                            if(currentBlock.block2!=null && !pointList.contains(new Point(currentBlock.block2.getPoint().x,currentBlock.block2.getPoint().y))){
                                pointList.add(new Point(currentBlock.block2.getPoint().x,currentBlock.block2.getPoint().y));
                            }
                        

                        
                        
                            if(currentBlock.block3!=null && !pointList.contains(new Point(currentBlock.block3.getPoint().x,currentBlock.block3.getPoint().y))){
                                pointList.add(new Point(currentBlock.block3.getPoint().x,currentBlock.block3.getPoint().y));
                            }

                            if(currentBlock.block4!=null && !pointList.contains(new Point(currentBlock.block4.getPoint().x,currentBlock.block4.getPoint().y))){
                                pointList.add(new Point(currentBlock.block4.getPoint().x,currentBlock.block4.getPoint().y));
                            }

                        currentBlock.stop();

                        break;

                    }
                }
    }
    
    public static void addBlockToBottom(Block currentBlock, List<Block> blockList, List<Point> pointList){

                    Board.setCurrentBlock(blockList.get(blockList.size()-1));
                                                                                        //570
                    if(currentBlock.block1!=null && currentBlock.block1.getPoint().y==Board.getBoardH()-Block.mainSize ||
                       currentBlock.block2!=null && currentBlock.block2.getPoint().y==Board.getBoardH()-Block.mainSize ||
                       currentBlock.block3!=null && currentBlock.block3.getPoint().y==Board.getBoardH()-Block.mainSize ||
                       currentBlock.block4!=null && currentBlock.block4.getPoint().y==Board.getBoardH()-Block.mainSize ){

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
                        
                        }

                    
                        currentBlock.stop();

                }

    }
}
