package designpattern.composite.notmanageable;

public class ExpensesDepartment {

    public static void main(String... args) {
        Manager rina = new Manager("Rina");
        Salesperson charlie = new Salesperson("Charlie");
        charlie.setManager(rina);
        Salesperson bob = new Salesperson("Bob", rina);
        SalesTeam team1 = new SalesTeam();
        team1.addManager(rina);
        team1.addSalesPerson(charlie);
        team1.addSalesPerson(bob);

        //Payment time
        payExpenseToManager(rina, 300);
        payExpenseToSalesperson(charlie, 100);
        payExpenseToSalesperson(bob, 100);

        payExpenseToSalesTeam(team1, 250);//pay each a bonus :-)
    }

    public static void payExpenseToSalesperson(Salesperson salesperson, int amount) {
        salesperson.payExpenses(amount);
    }

    public static void payExpenseToManager(Manager manager, int amount) {
        manager.payExpenses(amount);
    }

    public static void payExpenseToSalesTeam(SalesTeam team, int amount) {
        team.payExpenses(amount);
    }
}
