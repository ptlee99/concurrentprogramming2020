/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.Set;

/**
 * This class used to store the return object from Future
 * under class Player
 * @author User
 */
public class EdgeList<Integer, Set> {
    public final Integer numEdge;
    public final Set edge;
        
    public EdgeList(Integer num, Set e){
        this.edge = e;
        this.numEdge = num;  
    }
    
    public Integer getEdge(){
        return this.numEdge;
    }
    
    public Set getSet(){
        return this.edge;
    }
}
