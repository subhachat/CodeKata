package poc.threads.sync;

public class BankAccount {
    private long accountId;
    private String ownerName;
    private int cashBalance;
    private int overdraft;
    private int overdraftLimit;

    private BankAccount(Builder builder) {
        this.accountId = builder.accountId;
        this.ownerName = builder.ownerName;
        this.cashBalance = builder.cashBalance;
        this.overdraft = builder.overdraft;
        this.overdraftLimit = builder.overdraftLimit;
    }

    void setOverdraftLimit(int limit) {
        this.overdraftLimit = limit;
    }

    void topup(int amount) {
        if (this.cashBalance == 0 && this.overdraft > 0) {
            this.overdraft -= amount;
            if (this.overdraft < 0) { //cash surplus
                this.cashBalance -= this.overdraft;
                this.overdraft = 0;
            }
        } else if (overdraft == 0) {
            cashBalance += amount;
        }
    }

    int getCashBalance() {
        return cashBalance;
    }

    int getOverdraft() {
        return overdraft;
    }

    void debit(int amount) {
        if (amount <= cashBalance) {
            cashBalance -= amount;
        } else if (amount - cashBalance > overdraftLimit) {
            System.out.println(Thread.currentThread().getName() + " :: " + "Insufficient Balance. Try less!");
            return;
        } else {
            overdraft = overdraftLimit - (amount - cashBalance);
            cashBalance = 0;
        }
        System.out.println(Thread.currentThread().getName() + " :: " + amount + " debited!");
    }

    public static class Builder {
        private long accountId;
        private String ownerName;
        private int cashBalance;
        private int overdraft;
        private int overdraftLimit;

        private Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder setId(long accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setName(String name) {
            this.ownerName = name;
            return this;
        }

        public Builder setBalance(int amount) {
            this.cashBalance = amount;
            return this;
        }

        public Builder setOverdraftLimit(int amount) {
            this.overdraftLimit = amount;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }

    }
}
