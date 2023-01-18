public class PremiumAccount implements IAccount {
    int AccountNumber;
    double Balance;

    public PremiumAccount(int accountNumber){
        this.AccountNumber = accountNumber;

    }

    @Override
    public void Deposit(double amount) {
        Balance += amount;

    }

    @Override
    public double Withdraw(double amount) {
        Balance += amount;
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
