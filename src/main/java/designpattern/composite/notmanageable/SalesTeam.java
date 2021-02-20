package designpattern.composite.notmanageable;

import java.util.ArrayList;
import java.util.List;

public class SalesTeam {
    List<Manager> managers = new ArrayList<>();
    List<Salesperson> salesPersons = new ArrayList<>();

    SalesTeam() {
    }

    SalesTeam(List<Manager> managers, List<Salesperson> salesPersons) {
        this.managers = managers;
        this.salesPersons = salesPersons;
    }

    public void addManager(Manager manager) {
        managers.add(manager);
    }

    public void addSalesPerson(Salesperson salesPerson) {
        salesPersons.add(salesPerson);
    }

    public void payExpenses(int amount) {
        managers.parallelStream().forEach(user -> System.out.println(user.getName() + " is paid " + amount + " USD"));
        salesPersons.parallelStream().forEach(user -> System.out.println(user.getName() + " is paid " + amount + " USD"));
    }
}
