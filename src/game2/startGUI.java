/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.util.ArrayList;
import static java.lang.Integer.parseInt;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.geometry.*;
/**
 *
 * @author User
 */
public class startGUI {
  Button button;
    ArrayList<Integer> numEdge = new ArrayList<>();
    GridPane grid;

    public startGUI() {
        grid = new GridPane();
        grid.setPadding(new Insets(100, 100, 100, 100));
        grid.setVgap(8);
        grid.setHgap(15);

        Text scenetitle = new Text("Welcome!");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(scenetitle, 0, 0);

        // Number of point Label
        Label pointLabel = new Label("Number of points:");
        GridPane.setConstraints(pointLabel, 0, 2);

        // Name Input
        TextField pointInput = new TextField();
        pointInput.setMinWidth(160.0);
        pointInput.setPromptText("Ex: 50");
        GridPane.setConstraints(pointInput, 1, 2);

        // validation
        Label pointValidate = new Label();
        GridPane.setConstraints(pointValidate, 1, 3);
        pointValidate.setId("validation-text");
        // Number of player Label
        Label playerLabel = new Label("Number of Player:");
        GridPane.setConstraints(playerLabel, 0, 4);

        // Name Input
        TextField playerInput = new TextField();
        playerInput.setPromptText("Ex: 3");
        GridPane.setConstraints(playerInput, 1, 4);

        // validation
        Label playerValidate = new Label();
        GridPane.setConstraints(playerValidate, 1, 5);
        playerValidate.setId("validation-text");

        // Timer Label
        Label timerLabel = new Label("Duration");
        GridPane.setConstraints(timerLabel, 0, 6);

        // Name Input
        TextField timerInput = new TextField();
        timerInput.setPromptText("Seconds");
        GridPane.setConstraints(timerInput, 1, 6);

        // validation
        Label timerValidate = new Label();
        GridPane.setConstraints(timerValidate, 1, 7);
        timerValidate.setId("validation-text");

        // A button to create a new window
        Button button = new Button("Start Game!");
        GridPane.setConstraints(button, 1, 8);

        // push all the label and button into the grid created so it can show at the
        // window
        grid.getChildren().addAll(
                scenetitle,
                pointLabel, pointInput, pointValidate,
                playerLabel, playerInput, playerValidate,
                timerLabel, timerInput, timerValidate,
                button);

        // start game after press the button and create new window
        button.setOnAction(e -> {

            boolean isPoint = FormValidation.textFieldNotEmptyisInteger(pointInput, pointValidate);
            boolean isPlayer = FormValidation.textFieldNotEmptyisInteger(playerInput, playerValidate);
            boolean isTimer = FormValidation.textFieldNotEmptyisInteger(timerInput, timerValidate);

            if (isPoint && isPlayer && isTimer) {

                boolean isPlayerPoint= FormValidation.pointPlayerNum(pointInput, playerInput, pointValidate);
                boolean isPlayerReachMax= FormValidation.playerNumber(playerInput, playerValidate);
                
                if(isPlayerPoint && isPlayerReachMax){
                    int n = parseInt(pointInput.getText()); // number of points
                int m = parseInt(timerInput.getText()); // game timer
                int t = parseInt(playerInput.getText()); // number of thread

                GameTimer gt = new GameTimer(m);
                System.out.println("Game Start!" + new Date());

                StartGame start = new StartGame(n, m, t);
                numEdge = start.getResult();
                List<Set<Edge>> groupEdge = start.getEdge();
                System.out.println(numEdge);

                grid.getScene().getWindow().hide();
                ResultGUI.display(numEdge, groupEdge);
                }

                
            }
            // start timer

        });
    }

    public ArrayList<Integer> getNumEdge() {
        return numEdge;
    }

    public Parent getGrid() {
        return grid;
    }
  
}
