package sys;

import events.Event;
import events.EventType;
import models.ArrivalTimeGenerator;
import models.Customer;
import models.ServiceTimeGenerator;

import java.util.*;

public class Sys {
    private Customer customerInServiceChannel;
    private final Queue<Customer> queue = new ArrayDeque<>();
    private final Queue<Event> eventsQueue = new PriorityQueue<>();
    private final Clock clock = new Clock();
    private final ArrivalTimeGenerator arrivalTimeGen = new ArrivalTimeGenerator();
    private final ServiceTimeGenerator serviceTimeGenerator = new ServiceTimeGenerator();

    private final List<Customer> customerList = new ArrayList<>();

    private void init() {
        for (int i = 0; i < 20; i++) {
            var arrivalTime = arrivalTimeGen.next();
            var customer = new Customer(clock, i+1, arrivalTime);
            customerList.add(customer);
            eventsQueue.add(new Event(EventType.ARRIVED, customer, arrivalTime));
        }
    }

    private void advanceToNextState() {
        var event = eventsQueue.remove();
        clock.setTime(event.getTime());
        if (event.getType() == EventType.ARRIVED) {
            if (this.queue.isEmpty()) {
                if (this.customerInServiceChannel == null) beginService(event.getCustomer());
                else this.queue.add(event.getCustomer());
            }
            else {
                this.queue.add(event.getCustomer());
            }
        }
        if (event.getType() == EventType.DEPARTED) {
            event.getCustomer().endService();
            this.customerInServiceChannel = null;
        }

        if (this.customerInServiceChannel == null && !this.queue.isEmpty()) {
            beginService(this.queue.remove());
        }
    }
    private void beginService(Customer customer) {
        this.customerInServiceChannel = customer;
        customer.beginService();
        var serviceDuration = serviceTimeGenerator.next();
        this.eventsQueue.add(new Event(EventType.DEPARTED, customer, this.clock.getTime() + serviceDuration));
    }

    public void runSimulator() {
        this.init();
        while (!this.eventsQueue.isEmpty()) {
            this.advanceToNextState();
        }
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
