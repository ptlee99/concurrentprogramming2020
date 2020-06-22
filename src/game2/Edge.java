/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

/**
 *
 * @author User
 */
public class Edge {
    private Coordinate point1;
    private Coordinate point2;

    public Edge(Coordinate p1, Coordinate p2) {
        this.point1 = p1;
        this.point2 = p2;
    }

    public Coordinate getPoint1() {
        return this.point1;
    }

    public Coordinate getPoint2() {
        return this.point2;
    }

    @Override
    public String toString() {
        return "[" + this.point1 + ", " + this.point2 + "]";
    }
}
