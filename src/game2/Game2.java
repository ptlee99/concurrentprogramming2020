/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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
        int endOfLoop = 2;
        Points p = new Points();
        
        for(int i=0; i<endOfLoop; i++){
        p.createPoint();
        }
    /*   Set<Coordinate> pointSet  = Collections.synchronizedSet(new HashSet<>());
       pointSet.add(new Coordinate(1,2));
       pointSet.add(new Coordinate(2,3));
       pointSet.add(new Coordinate(2,1));
       pointSet.add(new Coordinate(0,4));
       
    
       Iterator<Coordinate> itr = pointSet.iterator();
        while(itr.hasNext()){
            System.out.println("In HashSet: "+itr.next());
        }
        
        System.out.println(pointSet);
*/
        System.out.println(p);
    }
    
}
