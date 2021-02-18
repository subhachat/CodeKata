package poc.threads.sync;

public class Users {

    static final BankAccount harry = BankAccount.Builder.newInstance()
            .setId(1001)
            .setName("Harry")
            .setBalance(1000)
            .setOverdraftLimit(100)
            .build();

    public static void main(String... args) {
        /*BankAccount meghan = BankAccount.Builder.newInstance()
                .setId(1002)
                .setName("Meghan")
                .setBalance(1200)
                .setOverdraftLimit(80)
                .build();
        ATM.withdraw(harry, 100);
        harry.topup(500);
        ATM.withdraw(meghan, 1800);
        ATM.withdraw(meghan, 1250);
        harry.topup(50);*/

        System.out.println("----Run Parallel withdrawal from Harry's account----");
        Thread user1 = new Thread(() -> {
            ATM.withdraw(harry, 950);
        }
        );
        user1.setName("user1");
        Thread user2 = new Thread(() -> {
            ATM.withdraw(harry, 950);
        }
        );
        user2.setName("user2");
        System.out.println(user1.getName() + " :: " + "Before :: Balance = "
                + harry.getCashBalance() + " & overdraft = " + harry.getOverdraft());

        user1.start();
        System.out.println(user2.getName() + " :: " + "Before :: Balance = "
                + harry.getCashBalance() + " & overdraft = " + harry.getOverdraft());
        user2.start();
    }
}
