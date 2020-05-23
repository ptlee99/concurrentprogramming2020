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

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
