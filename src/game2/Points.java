/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.text.DecimalFormat;
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
       Random rand = new Random();
       x = rand.nextFloat()*MAX_X;
       y = rand.nextFloat()*MAX_Y;
       verifyPoint(x,y);
     /*x = 2; y = 4;
       verifyPoint(x,y);
       x = 3; y = 4;
       verifyPoint(x, y);
       x = 1; y = 5;
       verifyPoint(x, y);
       x = 1; y = 7;
       verifyPoint(x,y);
        x = 1; y = 7;
       verifyPoint(x,y);*/
    }
    
    public void verifyPoint(float x, float y){
        //verify within the Grid or not
     /*   if(x > MAX_X){System.out.println("X Out of Grid");}
        else if(y > MAX_Y){System.out.println("Y Out of Grid");}
        else{pointSet.add(new Coordinate(x,y));}*/
       pointSet.add(new Coordinate(x,y));
        System.out.println("VerifyPoint: "+pointSet);
    }
    
    public void displaySet(){
        Iterator<Coordinate> itr = pointSet.iterator();
        while(itr.hasNext()){
           System.out.println(itr.next());
        }
    }
}
