/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import static java.lang.Integer.parseInt;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//gui import
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author User
 */
public class Game2 extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("NodeGame");
       
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(100, 100, 100, 100));
        grid.setVgap(18);
        grid.setHgap(15);
        
        Text scenetitle = new Text("Welcome!");
        scenetitle.setId("welcome-text");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setConstraints(scenetitle, 0, 0);

        //Number of point Label
        Label pointLabel = new Label("Number of points:");
        GridPane.setConstraints(pointLabel, 0, 1);

        //Name Input
        TextField pointInput = new TextField();
        pointInput.setPromptText("Ex: 50");
        GridPane.setConstraints(pointInput, 1, 1);

        //Number of player Label
        Label playerLabel = new Label("Number of Player:");
        GridPane.setConstraints(playerLabel, 0, 2);

        //Name Input
        TextField playerInput = new TextField();
        playerInput.setPromptText("Ex: 3");
        GridPane.setConstraints(playerInput, 1, 2);

        //Timer Label
        Label timerLabel = new Label("Duration");
        GridPane.setConstraints(timerLabel, 0, 3);

        //Time Input
        TextField timerInput = new TextField();
        timerInput.setPromptText("Seconds");
        GridPane.setConstraints(timerInput, 1, 3);

        Button button = new Button("Start Game!");
        GridPane.setConstraints(button, 1, 4);

        grid.getChildren().addAll(scenetitle, pointLabel, pointInput, playerLabel, playerInput, timerLabel, timerInput, button);
        Scene scene = new Scene(grid, 500, 427);
        window.setScene(scene);
        scene.getStylesheets().add
        (Game2.class.getResource("Game.css").toExternalForm());
        window.show();

        //start game after press the button
        button.setOnAction(e -> {
            int n; //number of points
            int m; //game timer
            int t; //number of thread
            
            n = parseInt(pointInput.getText());
            m = parseInt(timerInput.getText());
            t = parseInt(playerInput.getText());
<<<<<<< Updated upstream

            //start timer
=======
            
>>>>>>> Stashed changes
            GameTimer gt = new GameTimer(m);
            System.out.println("Game Start!" + new Date());

            //generate random points
            Points p = new Points();
            for (int i = 0; i < n; i++) {
                p.createPoint();
            }

            //get created points
            Set<Coordinate> pointSet = new HashSet<>();
            pointSet = p.getSet();

            //players join the game
            ExecutorService executor = Executors.newFixedThreadPool(t);

            for (int i = 1; i <= t; i++) {
                Player players = new Player("P" + i, pointSet);
                players.createThread();
                executor.execute(players);
                System.out.println("Player " + i + " joins the game.");
            }
            executor.shutdown();
<<<<<<< Updated upstream
            
            
=======

            if (gt.getIsTimeUp()) {
                window.close();
            }
>>>>>>> Stashed changes
        });
    }

}
