/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author User
 */
public class Player implements Runnable {
    private String threadName;       //the name of the player
    private Set<Coordinate> pointSet; 
    //create a set of player taken points
    private Object startPoint;
    private Object endPoint;

    private final Lock lock = new ReentrantLock();
    
    public Player(String threadName, Set<Coordinate> pointSet) {
        this.threadName = threadName;
        this.pointSet = pointSet;
        
    }

    //create the players
    public void createThread(){
        Thread thread = new Thread(threadName);
        thread.start();
    }
    
    
    public boolean pickPoint(){
        lock.lock();
        //get Max_X and Max_Y
        Grid grid = new Grid();
        float MAX_X = grid.getMAX_X();
        float MAX_Y = grid.getMAX_Y(); 
        
        Points point = new Points(); //get created points (set)
        System.out.println(pointSet);
        
        boolean pointTaken = false;
        
        //randomly picks 2 points from the set in Points object
        int size = pointSet.size();
        int p1 = new Random().nextInt(size); 
        //int p2 = new Random().nextInt(size); 
        int i = 0;
        //int j = 0;
        
        for(Object obj : pointSet){
            if (i == p1){
                startPoint = obj;
                try{
                    boolean isRemove = pointSet.remove(obj);
                    System.out.println(isRemove);
                }
                catch(Exception e){e.printStackTrace();}
                
            }
        i++;
        }
       
        /**for(Object obj : pointSet){
            if (j == p2){
                endPoint = obj;
                
            }
        j++;
        }**/
        System.out.println("Start point: "  + startPoint);
        //System.out.println("End point: "  + endPoint);
        lock.unlock();
        //points.add(x,y);
        return pointTaken;
        
    }
    
    public void displayResults(){
        System.out.println(threadName + " - " + pointSet);
    }
    
    @Override
    public void run() {
        pickPoint();
       // displayResults();
    }
}
