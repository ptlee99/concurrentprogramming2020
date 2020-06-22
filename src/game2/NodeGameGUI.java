/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;
import java.util.ArrayList;

//gui import
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class NodeGameGUI extends Application {

    Stage window;
    Scene scene;
    ArrayList<Integer> numEdge = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("NodeGame");

        startGUI start = new startGUI();

        // put the grid into the scene
        Scene scene1 = new Scene(start.getGrid(), 500, 427);

        // put the scene into the window
        window.setScene(scene1);
        scene1.getStylesheets().add(NodeGameGUI.class.getResource("Game.css").toExternalForm());
        
        // show the window
        window.show();

        
    }

}
