/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author User
 */
public class Game2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n; //number of points
        int m; //game timer
        int t; //number of thread
        
        //Game start
        System.out.println("Hi! Ready to start the game?");
        System.out.println("");
        //input from user, n, m, t
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of points : ");
        n = scanner.nextInt();
        System.out.println("Enter the number of players: ");
        t = scanner.nextInt();
        System.out.println("How long you want the game to be? (seconds) ");
        m = scanner.nextInt();
        
        //generate random points
        Points p = new Points();
        for(int i=0; i<n; i++){
        p.createPoint();
        }
        
        //create Player
    }
    
}
