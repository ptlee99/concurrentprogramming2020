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

/**
 * Purpose:
 * ** Driver to create points
 * 
 * @author Lee Peh Ting
 */
public class Points {
    private float x;
    private float y;
    private final float MAX_X = 10;
    private final float MAX_Y = 10;
    
    private final Set<Coordinate> pointSet  = Collections.synchronizedSet(new HashSet<>());
    
    public void createPoint(){
       // x = (float)(Math.random()*(MAX_X+1));
       // y = (float)(Math.random()*(MAX_Y+1));
       /*
       By using Random Class, the boundary is set. 
       Thus, the X and Y will not out of Grid.
       */
       Random rand = new Random();
       x = rand.nextFloat()*MAX_X;
       x = (float)(Math.round(x*100.0)/100.0);
       y = rand.nextFloat()*MAX_Y;
       y = (float)(Math.round(y*100.0)/100.0);
       
       //Verify the overlap of the created point
       verifyPoint(x,y);
    }
    
    public void verifyPoint(float x, float y){
       /*
       Set will not allows the duplicate data. 
       Method equals() called in Coordinate Class.
       No overlapping occur if add() return true, vice verse
       Return true for add() means the data inserted into the Set
       */
       if(pointSet.add(new Coordinate(x,y)))
        System.out.println("Point ("+x+", "+y+") created.");
       else
        System.out.println("Point ("+x+", "+y+") failed to create.");   
    }
    
    public void displaySet(){
        Iterator<Coordinate> itr = pointSet.iterator();
        while(itr.hasNext()){
           System.out.println(itr.next());
        }
    }
    
    public Set<Coordinate> getSet(){
        return this.pointSet;
    }
}
