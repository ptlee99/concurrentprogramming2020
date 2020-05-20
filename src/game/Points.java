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

/**
 *
 * @author Admin
 */
public class Points {
    //points are Resource
    
    //Variables
    private float x; //coordinate X
    private float y; //coordinate Y
    private final Set<Float> pointSet; //a set of points
    
    // Synchronized Set
    // Set<String> numSet = Collections.synchronizedSet(new HashSet<String>());
    
    public Points(Set<Float> pointSet){
        this.pointSet = pointSet;
    }
    
    //to create n points
    public void createPoint(int n){
        //create a set to store points
        Set<Float> pointSet = Collections.synchronizedSet(new HashSet<Float>());
        
        //get Max_X and Max_Y
        Grid grid = new Grid();
        float MAX_X = grid.getMAX_X();
        float MAX_Y = grid.getMAX_Y(); 
        
        //create random points
        int currentNum = 0;
        boolean xloopAgain = false;
        boolean yloopAgain = false;
        
        for(int i=0; i<n; i++){ //number of loop
            //for x
            do{
                x = (float) (Math.random()*(MAX_X-0+1)+0); //formula: Math.random()*(max-min+1)+min;

                //verify the points
                //if true, store in Set
                //if false, loopAgain
                if(verifyPoint(x)){
                    xloopAgain = false;
                }else{
                    xloopAgain = true;
                }
            }while(xloopAgain == true); //end of while loop for X
            
            //for y
            do{
                y = (float) (Math.random()*(MAX_Y-0+1)+0); //formula: Math.random()*(max-min+1)+min;

                //verify the points
                //if true, store in Set
                //if false, loopAgain
                if(verifyPoint(x)){
                    yloopAgain = false;
                }else{
                    yloopAgain = true;
                }
            }while(yloopAgain == true); //end of while loop for X
        }
    }
    
    //to verify created points
    public boolean verifyPoint(float point){
        //within the grid
        
        
        //Not need check duplicate or not because HashSet doesn't allow duplicate entries.
        return true;
    }

}
