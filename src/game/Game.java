/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.the.points;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
/**
 *
 * @author Admin
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int t;
        
        Set<Float> player = Collections.synchronizedSet(new HashSet<Float>());
        
        Random rand = new Random();
        t = rand.nextInt(20) + 1; // max number of threads is 20
        
        //players join the game
        for(int i=1; i<=t; i++){
            Player players = new Player("P" + i, player);
            players.createThread(); 
            System.out.println("Player " + i + " joins the game.");
            //players.displayResults();
        }
        
        //display results of players
        
    }
    
}
