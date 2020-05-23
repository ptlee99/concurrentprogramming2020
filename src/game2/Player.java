/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author User
 */
public class Player implements Runnable {
    private String threadName;       //the name of the player
    private Set<Float> pointSet;

    private final Lock lock = new ReentrantLock();
    
    public Player(String threadName, Set<Float> pointSet) {
        this.threadName = threadName;
        this.pointSet = pointSet;
    }

    //create the players
    public void createThread(){
        Thread thread = new Thread(threadName);
        thread.start();
    }
    
    
    public boolean pickPoint(){
        
        //get Max_X and Max_Y
        Grid grid = new Grid();
        float MAX_X = grid.getMAX_X();
        float MAX_Y = grid.getMAX_Y(); 
        //Points point = new Points(); get created points (set)
        
        boolean pointTaken = false;
        
        //randomly picks 2 points from the set in Points object
        /**float x1 = (float) Math.random();
        float y1 = (float) Math.random();**/
        
        
        
        //points.add(x,y);
        return pointTaken;
        
    }
    
    public void displayResults(){
        System.out.println(threadName + " - " + pointSet);
    }
    
    @Override
    public void run() {
        
        //players continue to play if less than m seconds and 20 attempts
    }
}
