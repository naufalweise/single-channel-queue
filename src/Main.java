import reports.Report;
import sys.Sys;

public class Main {
    public static void main(String[] args) {
        var sys = new Sys();
        sys.runSimulator();
        var report = new Report(sys.getCustomerList());
        report.printSimTable();
        report.printStats();
    }
}
