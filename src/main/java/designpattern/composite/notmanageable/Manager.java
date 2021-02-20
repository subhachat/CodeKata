package designpattern.composite.notmanageable;

public class Manager {
    private String name;

    Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void payExpenses(int amount) {
        System.out.println(this.name + " is paid " + amount + " USD");
    }
}
