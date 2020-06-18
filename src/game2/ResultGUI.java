package game2;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.ArrayList;

import javafx.geometry.*;

public class ResultGUI {
    public static void display(ArrayList<Integer> result) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Node Game Result");
        Label label = new Label();
        label.setText("Number of edges produced: ");
        TextArea output = new TextArea();
        output.setPrefRowCount(result.size());
        output.setPrefColumnCount(100);
        output.setWrapText(true);
        output.setPrefWidth(150);

        String message = "";

        for (int i = 0; i < result.size(); i++) {
            message = "P" + (i + 1) + " has created " + result.get(i) + " edges.\n";
            output.setText(message);
        }

        Button btn = new Button("End Game");
        btn.setOnAction(e -> window.close());

        StackPane layout = new StackPane();

        layout.getChildren().addAll(label, output, btn);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}