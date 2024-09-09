package models;

import java.util.Random;

public class ArrivalTimeGenerator {
    private final Random random;
    private int lastTime; // last generated arrival time
    // time between arrival
    private int nextInterval() {
        int randomBound = 1000;
        int randomNumber = random.nextInt(randomBound);
        if (1 <= randomNumber && randomNumber <= 125) return 1;
        if (126 <= randomNumber && randomNumber <= 250) return 2;
        if (251 <= randomNumber && randomNumber <= 375) return 3;
        if (376 <= randomNumber && randomNumber <= 500) return 4;
        if (501 <= randomNumber && randomNumber <= 625) return 5;
        if (626 <= randomNumber && randomNumber <= 750) return 6;
        if (751 <= randomNumber && randomNumber <= 800) return 7;
        return 8;
    }
    // next arrival time
    public int next() {
        lastTime = lastTime + nextInterval();
        return lastTime;
    }

    public ArrivalTimeGenerator(Random random) {
        this.random = random;
    }
}
