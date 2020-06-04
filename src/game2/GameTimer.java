/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author User
 */
public class GameTimer{
    private int m;
    private Timer timer;
    private boolean isTimeUp = false;

    public GameTimer(int m){
        timer = new Timer();
        timer.schedule(new GameTimeTask(), m*1000);
    }
    
    public GameTimer(){
    }
    
    public boolean getIsTimeUp(){ 
        return this.isTimeUp;
    }
    
    class GameTimeTask extends TimerTask{
        @Override
        public void run() {
            isTimeUp = true;
            System.out.println("Time's up!"+new Date());
            timer.cancel();
        }
    }
    
}


