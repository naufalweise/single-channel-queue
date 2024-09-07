package models;

import java.util.Random;

public class ArrivalTimeGenerator {
    private final int probability = 0;
    private final int randomBound = 1000;
    private Random random;
    private int lastTime; // last generated arrival time
    // time between arrival
    private int nextInterval() {
        //int randomNumber = random.nextInt(randomBound);
        //if (randomNumber < )
        return 5;
    }
    // next arrival time
    public int next() {
        lastTime = lastTime + nextInterval();
        return lastTime;
    }
}
