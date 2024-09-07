package models;

import sys.Clock;

public class Customer {
    private Clock clock;
    private int number;
    private int arrivalTime;
    private int beginServiceTime;
    private int endServiceTime;

    public Customer(Clock clock, int number, int arrivalTime) {
        this.clock = clock;
        this.arrivalTime = arrivalTime;
    }

    public void beginService() {
        this.beginServiceTime = this.clock.getTime();
    }

    public void endService() {
        this.endServiceTime = this.clock.getTime();
    }

    public int getServiceDuration() {
        return this.endServiceTime - this.beginServiceTime;
    }

    public int getNumber() {
        return this.number;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getBeginServiceTime() {
        return beginServiceTime;
    }

    public int getEndServiceTime() {
        return endServiceTime;
    }
}
