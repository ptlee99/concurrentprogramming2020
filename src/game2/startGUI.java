package game2;

import java.util.ArrayList;
import static java.lang.Integer.parseInt;
import java.util.Date;
<<<<<<< HEAD
import java.util.List;
import java.util.Set;
=======
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.geometry.*;
<<<<<<< HEAD

public class startGUI {

=======
import javafx.scene.paint.Color;

public class startGUI {
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
    Button button;
    ArrayList<Integer> numEdge = new ArrayList<>();
    GridPane grid;

    public startGUI() {
        grid = new GridPane();
        grid.setPadding(new Insets(100, 100, 100, 100));
<<<<<<< HEAD
        grid.setVgap(8);
=======
        grid.setVgap(18);
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
        grid.setHgap(15);

        Text scenetitle = new Text("Welcome!");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(scenetitle, 0, 0);

        // Number of point Label
        Label pointLabel = new Label("Number of points:");
<<<<<<< HEAD
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
=======
        GridPane.setConstraints(pointLabel, 0, 1);

        // Name Input
        TextField pointInput = new TextField();
        pointInput.setPromptText("Ex: 50");
        GridPane.setConstraints(pointInput, 1, 1);

        // Number of player Label
        Label playerLabel = new Label("Number of Player:");
        GridPane.setConstraints(playerLabel, 0, 2);
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8

        // Name Input
        TextField playerInput = new TextField();
        playerInput.setPromptText("Ex: 3");
<<<<<<< HEAD
        GridPane.setConstraints(playerInput, 1, 4);

        // validation
        Label playerValidate = new Label();
        GridPane.setConstraints(playerValidate, 1, 5);
        playerValidate.setId("validation-text");

        // Timer Label
        Label timerLabel = new Label("Duration");
        GridPane.setConstraints(timerLabel, 0, 6);
=======
        GridPane.setConstraints(playerInput, 1, 2);

        // Timer Label
        Label timerLabel = new Label("Duration");
        GridPane.setConstraints(timerLabel, 0, 3);
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8

        // Name Input
        TextField timerInput = new TextField();
        timerInput.setPromptText("Seconds");
<<<<<<< HEAD
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
=======
        GridPane.setConstraints(timerInput, 1, 3);

        // A button to create a new window
        Button button = new Button("Start Game!");
        GridPane.setConstraints(button, 1, 4);

        // push all the label and button into the grid created so it can show at the
        // window
        grid.getChildren().addAll(scenetitle, pointLabel, pointInput, playerLabel, playerInput, timerLabel, timerInput,
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
                button);

        // start game after press the button and create new window
        button.setOnAction(e -> {

<<<<<<< HEAD
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

=======
            int n = parseInt(pointInput.getText()); // number of points
            int m = parseInt(timerInput.getText()); // game timer
            int t = parseInt(playerInput.getText()); // number of thread
            
            //If n << t
            if(t>n){
                System.out.println("t>n");
               Label error = new Label("Please ensure that the Number of Player should not greater than the Number of Points.");
               error.setTextFill(Color.RED);
               error.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
               error.setPrefWidth(600);
               error.setWrapText(true);
               grid.add(error, 0, 5, 3, 6);
            }else{
            // start timer
            GameTimer gt = new GameTimer(m);
            System.out.println("Game Start!" + new Date());

            StartGame start = new StartGame(n, m, t);
            numEdge = start.getResult();
            System.out.println(numEdge);

            grid.getScene().getWindow().hide();
            
            //display result
            ResultGUI.display(numEdge);
            }
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
        });
    }

    public ArrayList<Integer> getNumEdge() {
        return numEdge;
    }

    public Parent getGrid() {
        return grid;
    }

<<<<<<< HEAD
}
=======

}
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
