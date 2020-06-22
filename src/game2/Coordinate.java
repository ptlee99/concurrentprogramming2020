/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.Objects;

/**
 * Purpose
 * ** Data type for coordinate (x,y)
 * ** Collections to put inside HashSet
 * ** Overwrite methods
 * 
 * 
 * @author Lee Peh Ting
 */
public class Coordinate {
    private float x;
    private float y;
    
    public Coordinate(){}
    
    public Coordinate(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public float getX(){
    return x;}
    
    public float getY(){
    return y;}
    
    public void setX(float x){
    this.x = x;}
    
    public void setY(float y){
    this.y = y;}
    
    /*
    Check the value of X and Y
    if exists, point overlapped
    */
    @Override
    public boolean equals(Object o){
        if(o == null || !(o instanceof Coordinate)) {System.out.println("False"); return false;}
        Coordinate coordinates = (Coordinate) o;
        if(coordinates.getX()==this.getX() && coordinates.getY()==this.getY()) {System.out.println("True"); return true;}
    return false;}

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
    
    /*
    HashCode used to verify the index address of the item in the Set
    If the X exists in the Set, the function equals() will be called to verify the Y
    If Y exists, the Point is overlapped
    */
    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
