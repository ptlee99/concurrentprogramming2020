/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.List;
import java.util.Set;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class lineGUI {

    private static GridPane grid;

    public static void display(List<Set<Edge>> playerEdge) {
        grid = new GridPane();
        grid.setPadding(new Insets(100, 100, 100, 100));
        grid.setVgap(18);
        grid.setHgap(15);

        Label label = new Label();
        label.setText("Game Result: ");
        label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(label, 0, 0);

        int loop = 1;
        for (int i = 0; i < playerEdge.size(); i++) {
            Set<Edge> listEdge = playerEdge.get(i);
            for (Object setItem : listEdge) {
                Edge setEdge = (Edge) setItem;
                grid.add(new Label("P" + (i + 1) + " has created " + setEdge.getPoint1() + " edges.\n"), 0, loop);
                loop++;
            }
            
        }

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Node Game Result");

        Button btn = new Button("End Game");
        GridPane.setConstraints(btn, 0, loop);
        btn.setOnAction(e -> window.close());

        grid.getChildren().addAll(label, btn);
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(NodeGameGUI.class.getResource("Game.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
    }
}
