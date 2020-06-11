/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class LineWindow extends JComponent {

    List<Coordinate> listConverted;
    private Set<Coordinate> pointTakenByPlayer;
    
    LineWindow(Set<Coordinate> pointTakenByPlayer) {
        this.pointTakenByPlayer = pointTakenByPlayer;
        this.listConverted = new ArrayList<>(pointTakenByPlayer);

    }
    
    public void drawLines(Graphics g) {
        int size = listConverted.size();
        if(size % 2 != 0){
            size = size -1;
        }
        if (size >= 2) {
            for (int x = 0; x < size; x += 2) {
                String node1 = listConverted.get(x).toString();
                String node2 = listConverted.get(x + 1).toString();
                String[] filter1 = node1.split(",");
                String[] filter2 = node2.split(",");
                Float x1 = Float.parseFloat(filter1[0].replaceAll("[\\[\\](){}]", ""));
                Float y1 = Float.parseFloat(filter1[1].replaceAll("[\\[\\](){}]", ""));
                Float x2 = Float.parseFloat(filter2[0].replaceAll("[\\[\\](){}]", ""));
                Float y2 = Float.parseFloat(filter2[1].replaceAll("[\\[\\](){}]", ""));
                Graphics2D g2d = (Graphics2D) g;
                g2d.draw(new Line2D.Float(x1, y1, x2, y2));
            }
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
    
    
   
}
