package poc.threads.sync;

import java.util.Objects;

public class ATM {

    public static void withdraw(BankAccount account, int amount) {
        Objects.requireNonNull(account);
        if (amount > 0) {
            account.debit(amount);
        }
        System.out.println(Thread.currentThread().getName() + " :: " + "After :: Balance = "
                + account.getCashBalance() + " & overdraft = " + account.getOverdraft());
    }
}
