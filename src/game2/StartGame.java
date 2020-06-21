package game2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StartGame {
    int numPoints; // number of points
    int gameTimer; // game timer
    int numThread; // number of thread
    ArrayList<Integer> numEdge = new ArrayList<>();
    List<Set<Edge>> groupEdge = new ArrayList<>();
    List<Future<EdgeList>> numEdgeList = new ArrayList<>();

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

        for (int i = 1; i <= numThread; i++) {
            Future<EdgeList> numEdge = executor.submit(new Player("P" + i, pointSet));
            System.out.println("Player " + i + " joins the game.");
            numEdgeList.add(numEdge);
        }

        for (Future<EdgeList> future : numEdgeList) {
            try {
                int edges = (Integer)future.get().getEdge();
                numEdge.add(edges);
                groupEdge.add((Set<Edge>)future.get().getSet());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    public ArrayList<Integer> getResult() {
        joinGame();
        return numEdge;
    }
    
    public List<Set<Edge>> getEdge(){
        return this.groupEdge;
    }
}