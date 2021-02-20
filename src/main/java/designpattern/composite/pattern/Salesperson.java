package designpattern.composite.pattern;

public class Salesperson implements Payee {
    private String name;
    private Manager manager;

    Salesperson(String name) {
        this.name = name;
    }

    Salesperson(String name, Manager manager) {
        this(name);
        this.manager = manager;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void payExpense(int amount) {
        System.out.println(this.name + " is paid " + amount + " USD");
    }
}
