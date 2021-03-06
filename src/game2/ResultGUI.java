/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javafx.geometry.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author User
 */
public class ResultGUI {

    private static GridPane grid;

    public static void display(ArrayList<Integer> result, List<Set<Edge>> playerEdge) {
        grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(18);
        grid.setHgap(15);

        Text scenetitle = new Text("Game Result:");
        scenetitle.setId("result-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(scenetitle, 0, 0);

        // Show how many edge player got
        int loop = 1;
        for (int i = 0; i < result.size(); i++) {
            grid.add(new Label("P" + (i + 1) + " has created " + result.get(i) + " edges.\n"), 0
                    , loop);
            loop++;
        }
        // draw line
        Group group = new Group();
        for (int i = 0; i < playerEdge.size(); i++) {
            Set<Edge> listEdge = playerEdge.get(i);
            /*
            Random generate color for each player
             */
            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);

            /*
            Get every edge start point and end point
            Draw a line for each edge
            Add into the Group
             */
            for (Object setItem : listEdge) { 
                Edge setEdge = (Edge) setItem;
                DropShadow shadow = new DropShadow();
                shadow.setColor(Color.WHITE);
                Line line = new Line();
                line.setStrokeWidth(2);
                line.setStroke(Color.rgb(r, g, b));
                line.setStartX(setEdge.getPoint1().getX());
                line.setStartY(setEdge.getPoint1().getY());
                line.setEndX(setEdge.getPoint2().getX());
                line.setEndY(setEdge.getPoint2().getY());
                group.getChildren().add(line);
            }

        }
        grid.add(group, 0, loop);

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Node Game Result");

        Button btn = new Button("End Game");
        GridPane.setConstraints(btn, 1, loop+1);
        btn.setOnAction(e -> window.close());

        grid.getChildren().addAll(scenetitle, btn);
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(ResultGUI.class.getResource("Result.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
    }
}
