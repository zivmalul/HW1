import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IAccount> Account = new ArrayList<>();
        Account.add(new StandardAccount(1, 5000));
        Account.add(new BasicAccount(2, 2000));
        Account.add(new PremiumAccount(3));
        Account.add(new StandardAccount(4, 1000));
        Account.add(new BasicAccount(5, 5500));
        Account.add(new StandardAccount(6, 1100));
        Account.add(new PremiumAccount(7));
        Account.add(new BasicAccount(8, 5300));
        Account.add(new BasicAccount(9, 3800));
        Account.add(new PremiumAccount(10));

        for (IAccount account : Account) {
           System.out.println("For, " + account.GetAccountNumber() + "Credit limit: up to, " + account.GetCurrentBalance());
           System.out.println("For, " + account.GetAccountNumber() + "Withdrawal limit: up to, " + account.Withdraw(500));


        }

    }
}