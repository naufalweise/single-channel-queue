package reports;

import models.Customer;

import java.util.List;

public class Report {
    private List<Customer> customerList;

    public Report(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void printSimTable() {
        System.out.println("Arrival Time\tTime Service Begin\tService Time Duration\nTime Service Ends");
        for (Customer c:
             this.customerList) {
            System.out.printf("%d\t%d\t%d\t%d\n", c.getArrivalTime(), c.getBeginServiceTime(), c.getServiceDuration(), c.getEndServiceTime());
        }
    }

    public void printStats() {

    }
}
