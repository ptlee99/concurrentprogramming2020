package game2;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ResultGUI {
    public static void display(int result) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Node Game Result");
        Label label = new Label();
        label.setText("Number of edges produced: ");

        Button btn = new Button("End Game");
        btn.setOnAction(e -> window.close());

        StackPane layout = new StackPane();

        layout.getChildren().addAll(label, btn);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}