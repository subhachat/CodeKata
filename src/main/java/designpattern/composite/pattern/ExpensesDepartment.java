package designpattern.composite.pattern;

public class ExpensesDepartment {

    public static void main(String... args) {
        Manager rina = new Manager("Rina");
        Salesperson charlie = new Salesperson("Charlie");
        charlie.setManager(rina);
        Salesperson bob = new Salesperson("Bob", rina);
        SalesTeam team1 = new SalesTeam();
        team1.addPayee(rina);
        team1.addPayee(charlie);
        team1.addPayee(bob);

        //Payment time
        payExpense(rina, 300);
        payExpense(charlie, 100);
        payExpense(bob, 150);
        payExpense(team1, 150);//pay each a bonus :-)
    }

    public static void payExpense(Payee payee, int amount) {
        payee.payExpense(amount);
    }
}
