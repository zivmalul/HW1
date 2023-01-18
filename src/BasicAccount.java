public class BasicAccount implements IAccount {
    int accountNumber;
    double balance;
    double singleWithdrawalLimit;

    public BasicAccount(int accountNumber, double singleWithdrawalLimit) {
        this.accountNumber = accountNumber;
        this.singleWithdrawalLimit = singleWithdrawalLimit;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if (amount > singleWithdrawalLimit) {
            amount = singleWithdrawalLimit;
        }
        if (amount > balance) {
            amount = balance;
        }
        balance -= amount;
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}
