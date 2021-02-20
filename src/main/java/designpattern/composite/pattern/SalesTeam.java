package designpattern.composite.pattern;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class SalesTeam implements Payee {
    List<Payee> payees = new ArrayList<>();

    SalesTeam() {
    }

    SalesTeam(List<Payee> payees) {
        this.payees = payees;
    }

    @Override
    public String getName() {
        return "TEAM";
    }

    public void addPayee(Payee payee) {
        payees.add(payee);
    }

    @Override
    public void payExpense(int amount) {
        payees.parallelStream().forEach(user -> out.println(user.getName() + " is paid " + amount + " USD"));
    }
}
