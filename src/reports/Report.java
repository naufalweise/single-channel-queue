package reports;

import models.Customer;
import sys.Sys;

import java.util.List;

public class Report {
    private List<Customer> customerList;

    public Report(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void printSimTable() {
//        System.out.println("Arrival\t Service Begin \tService\tService End");
        var header = new String[]{"Arrival", "Service", "Service", "Service"};
        var header2 = new String[]{"", "Begin", "Duration", "End"};
        System.out.printf("%10s\t".repeat(header.length) + "\n", header);
        System.out.printf("%10s\t".repeat(header.length) + "\n", header2);
        for (Customer c:
             this.customerList) {
            System.out.printf("%10d\t".repeat(header.length) + "\n", c.getArrivalTime(), c.getBeginServiceTime(), c.getServiceDuration(), c.getEndServiceTime());
        }
    }

    public void printStats() {
        var totalWaitDuration = 0.0;
        var totalServiceTime = 0.0;
        for (Customer c:
                this.customerList) {
            var waitDuration = c.getBeginServiceTime() - c.getArrivalTime();
            totalWaitDuration += waitDuration;
            totalServiceTime += c.getServiceDuration();
        }
        System.out.printf("Average Wait Duration: %.2f%n", totalWaitDuration / customerList.size() );
        System.out.printf("Average Service Duration: %.2f%n", totalServiceTime / customerList.size() );
        System.out.printf("Total Service Duration: %.2f%n", totalServiceTime);

        var simDuration = this.customerList.get(this.customerList.size() - 1).getEndServiceTime()-this.customerList.get(0).getArrivalTime();
        var idleTime = simDuration - totalServiceTime;
        System.out.printf("Total Idle Duration: %.2f%n", idleTime);
    }
}
