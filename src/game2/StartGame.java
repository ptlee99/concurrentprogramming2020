package game2;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.Set;
=======
import java.util.Random;
import java.util.Set;

>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
<<<<<<< HEAD
=======
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8

public class StartGame {
    int numPoints; // number of points
    int gameTimer; // game timer
    int numThread; // number of thread
    ArrayList<Integer> numEdge = new ArrayList<>();
<<<<<<< HEAD
    List<Set<Edge>> groupEdge = new ArrayList<>();
    List<Future<EdgeList>> numEdgeList = new ArrayList<>();
=======
    Group group = new Group();
    GridPane grid = new GridPane();
    Lock lock = new ReentrantLock();
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8

    public StartGame(int n, int m, int t) {
        this.numPoints = n;
        this.gameTimer = m;
        this.numThread = t;
    }

    public Set<Coordinate> createPoints() {
        // generate random points
        Points p = new Points();
        for (int i = 0; i < numPoints; i++) {
            p.createPoint();
        }

        // get created points
        return p.getSet();
    }

    public void joinGame() {
        // players join the game
        ExecutorService executor = Executors.newFixedThreadPool(numThread);
        Set<Coordinate> pointSet = this.createPoints();
<<<<<<< HEAD

        for (int i = 1; i <= numThread; i++) {
=======
        List<Future<EdgeList>> numEdgeList = new ArrayList<>();

        for (int i = 1; i <= numThread; i++) {
            //Future<Integer> numEdge = executor.submit(new Player("P" + i, pointSet));
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
            Future<EdgeList> numEdge = executor.submit(new Player("P" + i, pointSet));
            System.out.println("Player " + i + " joins the game.");
            numEdgeList.add(numEdge);
        }

        for (Future<EdgeList> future : numEdgeList) {
            try {
                int edges = (Integer)future.get().getEdge();
                numEdge.add(edges);
<<<<<<< HEAD
                groupEdge.add((Set<Edge>)future.get().getSet());
=======
                //draw edge
                draw((Set<Edge>)future.get().getSet());
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
<<<<<<< HEAD
=======
        
        /*
        Create a scene to keep Group with lines
        Add scene into Stage
        Show an application window
        */
        Scene scene = new Scene(group, 1000, 1000);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Start Drawing...");
        stage.setScene(scene);
        stage.show();
        
>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
        executor.shutdown();
    }

    public ArrayList<Integer> getResult() {
        joinGame();
        return numEdge;
    }
    
<<<<<<< HEAD
    public List<Set<Edge>> getEdge(){
        return this.groupEdge;
    }
=======
    public void draw(Set<Edge> s){
        lock.lock();
        
        /*
        Random generate color for each player
        */
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        
        /*
        Get every edge start point and end point
        Draw a line for each edge
        Add into the Group
        */
        for(Object setItem : s){
            Edge setEdge = (Edge)setItem;
            Line line = new Line();
            line.setStroke(Color.rgb(r, g, b));
            line.setStartX(setEdge.getPoint1().getX());
            line.setStartY(setEdge.getPoint1().getY());
            line.setEndX(setEdge.getPoint2().getX());
            line.setEndY(setEdge.getPoint2().getY());
            group.getChildren().add(line);
        }
        lock.unlock();
    }

>>>>>>> 2d24d59cee2f5f4126d8e56fac1456eebc2e0fe8
}