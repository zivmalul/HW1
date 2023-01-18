public class StandardAccount implements IAccount {
    int AccountNumber;
    double CreditLimit;
    double Balance;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.AccountNumber = accountNumber;
        this.CreditLimit = creditLimit;
        this.Balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        Balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double availableWithdrawal = Balance + CreditLimit;
        if (amount > availableWithdrawal) {
            amount = availableWithdrawal;
        }
        Balance -= amount;
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return Balance;
    }

    @Override
    public int GetAccountNumber() {
        return AccountNumber;
    }
}