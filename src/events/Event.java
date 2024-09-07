package events;

import models.Customer;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Event implements Comparable<Event> {
    private EventType type;
    private Customer customer;
    private int time;

    public Event(EventType type, Customer customer, int time) {
        this.type = type;
        this.customer = customer;
        this.time = time;
    }


    public EventType getType() {
        return type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Event o) {
        var res = this.getTime() - o.getTime();
        if (res == 0) {
            res = this.getType().compareTo(o.getType());
        }
        return res;
    }
}
