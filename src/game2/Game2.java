/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author User
 */
public class Game2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n=10; //number of points
        int m; //game timer
        int t; //number of thread
        /**
        //Game start
        System.out.println("Hi! Ready for the game?");
        System.out.println("");
        //input from user, n, m, t
        Scanner scanner = new Scanner(System.in);
        
        //check if n > t
        do{
            System.out.println("Enter the number of points : ");
            n = scanner.nextInt();
            System.out.println("Enter the number of players: ");
            t = scanner.nextInt();
            if(n<t){
                System.out.println("Number of points should be greater than the number of players.");
            }
        }
        while(n<t);
        
        System.out.println("How long you want the game to be? (seconds) ");
        m = scanner.nextInt();
        
        //start timer
        GameTimer gt = new GameTimer(10);
        System.out.println("Game Start!"+new Date());**/
        
        //generate random points
        Points p = new Points();
        for(int i=0; i<n; i++){
        p.createPoint();
        }
        
        //get created points
        Set<Coordinate> pointSet = new HashSet<>();
        pointSet = p.getSet();
        
        //players join the game
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        for(int i = 1; i <= 2; i++){ //replace 5 with t
            Player players = new Player("P" + i, pointSet);
            players.createThread(); 
            executor.execute(players);
            System.out.println("Player " + i + " joins the game.");
        }
        executor.shutdown();
    }
    
}
