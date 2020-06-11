/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game2;

import static java.lang.Integer.parseInt;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//gui import
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javax.swing.JFrame;

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

        //Name Input
        TextField timerInput = new TextField();
        timerInput.setPromptText("Seconds");
        GridPane.setConstraints(timerInput, 1, 3);

        //A button to create a new window
        Button button = new Button("Start Game!");
        GridPane.setConstraints(button, 1, 4);

        //push all the label and button into the grid created so it can show at the window
        grid.getChildren().addAll(scenetitle, pointLabel, pointInput, playerLabel, playerInput, timerLabel, timerInput, button);

        //put the grid into the scene
        Scene scene = new Scene(grid, 500, 427);

        //put the scene into the window
        window.setScene(scene);
        scene.getStylesheets().add(Game2.class.getResource("Game.css").toExternalForm());

        //show the window
        window.show();

        //start game after press the button and create new window
        button.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                
                int n; //number of points
                int m; //game timer
                int t; //number of thread

                n = parseInt(pointInput.getText());
                m = parseInt(timerInput.getText());
                t = parseInt(playerInput.getText());

                /*                //Game start
       System.out.println("Hi! Ready for the game?");
        System.out.println("");
        //Game start
        System.out.println("Hi! Ready for the game?");
        System.out.println("");
        //input from user, n, m, t
        Scanner scanner = new Scanner(System.in);

        //check if n > t
        do {
            System.out.println("Enter the number of points : ");
            n = scanner.nextInt();
            System.out.println("Enter the number of players: ");
            t = scanner.nextInt();
            if (n < t) {
                System.out.println("Number of points should be greater than the number of players.");
            }
        } while (n < t);

        System.out.println("How long you want the game to be? (seconds) ");
        m = scanner.nextInt();
                 */
                //start timer
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
            }
        });
    }

}
