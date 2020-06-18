package game2;

import java.util.ArrayList;
import static java.lang.Integer.parseInt;
import java.util.Date;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.geometry.*;

public class startGUI {
    Button button;
    ArrayList<Integer> numEdge = new ArrayList<>();
    GridPane grid;

    public startGUI() {
        grid = new GridPane();
        grid.setPadding(new Insets(100, 100, 100, 100));
        grid.setVgap(18);
        grid.setHgap(15);

        Text scenetitle = new Text("Welcome!");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(scenetitle, 0, 0);

        // Number of point Label
        Label pointLabel = new Label("Number of points:");
        GridPane.setConstraints(pointLabel, 0, 1);

        // Name Input
        TextField pointInput = new TextField();
        pointInput.setPromptText("Ex: 50");
        GridPane.setConstraints(pointInput, 1, 1);

        // Number of player Label
        Label playerLabel = new Label("Number of Player:");
        GridPane.setConstraints(playerLabel, 0, 2);

        // Name Input
        TextField playerInput = new TextField();
        playerInput.setPromptText("Ex: 3");
        GridPane.setConstraints(playerInput, 1, 2);

        // Timer Label
        Label timerLabel = new Label("Duration");
        GridPane.setConstraints(timerLabel, 0, 3);

        // Name Input
        TextField timerInput = new TextField();
        timerInput.setPromptText("Seconds");
        GridPane.setConstraints(timerInput, 1, 3);

        // A button to create a new window
        Button button = new Button("Start Game!");
        GridPane.setConstraints(button, 1, 4);

        // push all the label and button into the grid created so it can show at the
        // window
        grid.getChildren().addAll(scenetitle, pointLabel, pointInput, playerLabel, playerInput, timerLabel, timerInput,
                button);

        // start game after press the button and create new window
        button.setOnAction(e -> {

            int n = parseInt(pointInput.getText()); // number of points
            int m = parseInt(timerInput.getText()); // game timer
            int t = parseInt(playerInput.getText()); // number of thread

            // start timer
            GameTimer gt = new GameTimer(m);
            System.out.println("Game Start!" + new Date());

            StartGame start = new StartGame(n, m, t);
            numEdge = start.getResult();
            System.out.println(numEdge);

            grid.getScene().getWindow().hide();
            ResultGUI.display(numEdge);
        });
    }

    public ArrayList<Integer> getNumEdge() {
        return numEdge;
    }

    public Parent getGrid() {
        return grid;
    }


}