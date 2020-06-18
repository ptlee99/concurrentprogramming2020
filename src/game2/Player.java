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
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author User
 */
public class Player implements Callable<Integer> {

    private String threadName; // the name of the player
    private Set<Coordinate> pointSet; // points created
    private Set<Coordinate> playerPoints = Collections.synchronizedSet(new HashSet<>()); // points taken by the player
    private static Set<Coordinate> pointsTaken = Collections.synchronizedSet(new HashSet<>()); // points taken by all
                                                                                               // players
    private Set<Edge> edgeSets = Collections.synchronizedSet(new HashSet<>()); // edges created by a player
    private Object pt; // point that is taken
    private int attempt = 0; // number of attempts

    private final Lock lock = new ReentrantLock();

    public Player(String threadName, Set<Coordinate> pointSet) {
        this.threadName = threadName;
        this.pointSet = pointSet;
    }

    // create the players
    public void createThread() {
        Thread thread = new Thread(threadName);
        thread.start();
    }

    public void pickPoint() {
        lock.lock();
        try {

            // randomly picks 1 point from the set in Points object
            int size = pointSet.size();
            int p1 = new Random().nextInt(size); // get the index
            int i = 0;

            Iterator<Coordinate> setItr = pointSet.iterator();
            while (setItr.hasNext()) {
                Object item = new Object();
                item = setItr.next();
                if (i == p1) {
                    pt = item;
                    if (pointsTaken.add((Coordinate) pt)) {
                        playerPoints.add((Coordinate) pt); // add point to the player
                        System.out.println("Point " + pt + " taken by " + threadName);
                    } else {
                        attempt++;
                        // System.out.println("Attempt : " + attempt);
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
        System.out.println(threadName + " has created these edges: " + edgeSets);
        System.out.println(threadName + " has created " + edgeSets.size() + " edges.");
        // LineWindow line = new LineWindow(playerPoints);

    }

    public void createEdge() {
        Set<Coordinate> edgePoints = Collections.synchronizedSet(new HashSet<>());
        playerPoints.forEach(e -> edgePoints.add(e));
        lock.lock();
        try {
            Coordinate p1; // first point
            Coordinate p2; // second point

            Iterator<Coordinate> pointSet = edgePoints.iterator();
            while (pointSet.hasNext()) {
                p1 = pointSet.next();
                pointSet.remove();
                if (pointSet.hasNext()) {
                    p2 = pointSet.next();
                    pointSet.remove();
                    edgeSets.add(new Edge(p1, p2));
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public int getNumEdge() {
        return edgeSets.size();
    }

    @Override
    public Integer call() throws Exception {
        GameTimer gt = new GameTimer();
        while (attempt < 20 && !Thread.interrupted()) {
            if (gt.getIsTimeUp() == false) {
                // System.out.println("SAVE ME");
                // System.out.println("Attempt from run : " + attempt + " by " +
                // Thread.currentThread().getName());
                pickPoint();
            }

        }
        createEdge();
        Thread.currentThread().interrupt();
        displayResults();
        return this.getNumEdge();
    }
}