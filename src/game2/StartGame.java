package game2;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartGame {
    int numPoints; //number of points
    int gameTimer; //game timer
    int numThread; //number of thread

    public StartGame(int n, int m, int t) {
        this.numPoints = n;
        this.gameTimer = m;
        this.numThread = t;
    }

    public Set<Coordinate> createPoints() {
        //generate random points
        Points p = new Points();
        for (int i = 0; i < numPoints; i++) {
            p.createPoint();
        }

        //get created points
        return p.getSet();
    }

    public ArrayList<Integer> joinGame() {
        //players join the game
        ExecutorService executor = Executors.newFixedThreadPool(numThread);
        Set<Coordinate> pointSet = this.createPoints();
        ArrayList<Integer> numEdge = new ArrayList<>();

        for (int i = 1; i <= numThread; i++) {
            Player players = new Player("P" + i, pointSet);
            players.createThread();
            executor.execute(players);
            System.out.println("Player " + i + " joins the game.");
            numEdge.add(players.getNumEdge());
        }
        executor.shutdown();
        return numEdge;
    }

    public ArrayList<Integer> getResult() {
        return joinGame();
    }
}