package game2;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.ArrayList;

import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ResultGUI {
    private static GridPane grid;
    
    public static void display(ArrayList<Integer> result) {
        grid = new GridPane();
        grid.setPadding(new Insets(100, 100, 100, 100));
        grid.setVgap(18);
        grid.setHgap(15);
        
        Label label = new Label();
        label.setText("Game Result: ");
        label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(label, 0, 0);
        
//        TextArea output = new TextArea();
//        output.setPrefRowCount(result.size());
//        output.setPrefColumnCount(100);
//        output.setWrapText(true);
//        output.setPrefWidth(150);
//        GridPane.setConstraints(output, 0, 2);
//
//        String message = "";
//
//        for (int i = 0; i < result.size(); i++) {
//            message = "P" + (i + 1) + " has created " + result.get(i) + " edges.\n";
//            //output.setText(message);
//            output.appendText(message+"\n");
//        }
        int loop = 1;
        for (int i = 0; i < result.size(); i++) {
            grid.add(new Label("P" + (i + 1) + " has created " + result.get(i) + " edges.\n"), 0, loop);
           loop++;
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