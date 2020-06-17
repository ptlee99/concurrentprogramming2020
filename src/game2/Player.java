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

<<<<<<< Updated upstream
    private final String threadName;            //the name of the player
    private final Set<Coordinate> pointSet;     //points created
    private final Set<Coordinate> playerPoints = Collections.synchronizedSet(new HashSet<>()); //points taken by the player
    private static final Set<Coordinate> pointsTaken = Collections.synchronizedSet(new HashSet<>()); //points taken by all players
    private Object pt1; //point 1 that is taken
    private Object pt2; //point 2 that is taken
    private int attempt = 0; //number of attempts
=======
    private final String threadName; // the name of the player
    private final Set<Coordinate> pointSet; // points created
    private final Set<Coordinate> playerPoints = Collections.synchronizedSet(new HashSet<>()); // points taken by the
                                                                                               // player
    private static Set<Coordinate> pointsTaken = Collections.synchronizedSet(new HashSet<>()); // points taken by all
                                                                                               // players
    private Object pt; // point that is taken
    private int attempt = 0; // number of attempts
>>>>>>> Stashed changes

    private final Lock lock = new ReentrantLock();

    public Player(final String threadName, final Set<Coordinate> pointSet) {
        this.threadName = threadName;
        this.pointSet = pointSet;
    }

    // create the players
    public void createThread() {
        final Thread thread = new Thread(threadName);
        thread.start();
    }

    public void pickPoint() {
        lock.lock();
        try {

<<<<<<< Updated upstream
            //randomly picks 1 point from the set in Points object
            int size = pointSet.size(); //get the index
            int p1 = new Random().nextInt(size);
            int p2 = new Random().nextInt(size);
            int i = 0, j = 0;
=======
            // randomly picks 1 point from the set in Points object
            final int size = pointSet.size(); // get the index
            final int p1 = new Random().nextInt(size);
            int i = 0;
>>>>>>> Stashed changes

            Iterator<Coordinate> setItr = pointSet.iterator();
            while (setItr.hasNext()) {
                Object item = new Object();
                item = setItr.next();
                if (i == p1) {
<<<<<<< Updated upstream
                    pt1 = item;
                    if (pointsTaken.add((Coordinate) pt1)) {
                        playerPoints.add((Coordinate) pt1); //add point to the player
                        System.out.println("Point " + pt1 + " taken by " + threadName);
                        while (setItr.hasNext()) {
                            Object item2 = new Object();
                            item2 = setItr.next();
                            if (j == p2) {
                                pt2 = item2;
                                if (pointsTaken.add((Coordinate) pt2)) {
                                    playerPoints.add((Coordinate) pt2); // add point to the player
                                    System.out.println("Point " + pt2 + " taken by " + threadName);
                                } else {
                                    attempt++;
                                    //System.out.println("Attempt : " + attempt);
                                }
                            }
                            j++;
                        }
=======
                    pt = item;
                    if (pointsTaken.add((Coordinate) pt)) {
                        playerPoints.add((Coordinate) pt); // add point to the player
                        System.out.println("Point " + pt + " taken by " + threadName);
>>>>>>> Stashed changes
                    } else {
                        attempt++;
                        //System.out.println("Attempt : " + attempt);
                    }
                }
                i++;
            }
        } finally {
            lock.unlock();
        }
    }

    public void displayResults() {
        System.out.println(threadName + " has collected these points: " + playerPoints);
    }

    @Override
    public void run() {
        final GameTimer gt = new GameTimer();
        while (attempt < 20 && !Thread.interrupted()) {
            if (gt.getIsTimeUp() == false) {
                //System.out.println("SAVE ME");
<<<<<<< Updated upstream
                // System.out.println("Attempt from run : " + attempt + " by " + Thread.currentThread().getName());
=======
                //System.out.println("Attempt from run : " + attempt + " by " + Thread.currentThread().getName());
>>>>>>> Stashed changes
                pickPoint();
            }

        }
        Thread.currentThread().interrupt();
        displayResults();
    }
}
