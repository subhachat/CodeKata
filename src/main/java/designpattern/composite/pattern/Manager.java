package designpattern.composite.pattern;

public class Manager implements Payee {
    private String name;

    Manager(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void payExpense(int amount) {
        System.out.println(this.name + " is paid " + amount + " USD");
    }
}
