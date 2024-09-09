package models;

import java.util.Random;

public class ServiceTimeGenerator {
    private final Random random;
    // next service duration
    public int next() {
        var randomNumber = random.nextInt(100);
        if (1 <= randomNumber && randomNumber <= 10) return 1;
        if (11 <= randomNumber && randomNumber <= 30) return 2;
        if (31 <= randomNumber && randomNumber <= 60) return 3;
        if (61 <= randomNumber && randomNumber <= 85) return 4;
        if (86 <= randomNumber && randomNumber <= 95) return 5;
        return 6;
    }

    public ServiceTimeGenerator(Random random) {
        this.random = random;
    }
}
