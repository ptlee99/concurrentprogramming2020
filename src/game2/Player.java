/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.Collections;
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
    private String threadName;            //the name of the player
    private Set<Coordinate> pointSet;     //points created
    private Set<Coordinate> playerPoints = Collections.synchronizedSet(new HashSet<>()); //points taken by the player
    private Object pt; //point that is taken

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
        
        Points point = new Points(); //get created points (set)
        System.out.println(pointSet);
        
        boolean pointTaken = false;
        
        //randomly picks 1 point from the set in Points object
        int size = pointSet.size();
        int p1 = new Random().nextInt(size);  
        int i = 0;
        
        Iterator setItr = pointSet.iterator();
        while(setItr.hasNext()){
            Object item = new Object();
            item = setItr.next();
            if(i == p1){
                pt = item;
                setItr.remove(); //removes point from available points set
                playerPoints.add((Coordinate) pt); //add point to the player
                System.out.println("playerPoints = " + playerPoints);
                pointTaken = true;
                
            }
            i++;
        }
        
       
        System.out.println("Point "  + pt + " taken by " + threadName);
        System.out.println(pointSet);
        lock.unlock();
        
        return pointTaken;
        
    }
    
    public void displayResults(){
        System.out.println(threadName + " has collected these points: " + playerPoints);
    }
    
    @Override
    public void run() {
        GameTimer gt = new GameTimer();
        while(gt.getIsTimeUp() == false){
            pickPoint();
        }
        displayResults();
    }
}
