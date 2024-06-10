package com.game.hoppenhelm;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {

        System.out.println(" finish time ");
        System.exit(0);

    }
}
