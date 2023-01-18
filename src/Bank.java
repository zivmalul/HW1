import java.util.ArrayList;
import java.util.List;


public class Bank {
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

        class MyBank implements IBank {

            private List<IAccount> accounts;

            public MyBank() {
                this.accounts = new ArrayList<>();
            }

            @Override
            public void OpenAccount(IAccount account) {
                accounts.add(account);
            }

            @Override
            public void CloseAccount(int accountNumber) {
                IAccount accountToRemove = null;
                for (IAccount account : accounts) {
                    if (account.GetAccountNumber() == accountNumber) {
                        accountToRemove = account;
                        if (account.GetCurrentBalance() < 0) {
                            System.out.println("Account is not closed due to debt");
                            return;
                        }
                        break;
                    }
                }
                if (accountToRemove != null) {
                    accounts.remove(accountToRemove);
                }
            }

            @Override
            public List<IAccount> GetAllAccounts() {
                return accounts;
            }

            @Override
            public List<IAccount> GetAllAccountInDebt() {
                List<IAccount> inDebtAccounts = new ArrayList<>();
                for (IAccount account : accounts) {
                    if (account.GetCurrentBalance() < 0) {
                        inDebtAccounts.add(account);
                    }
                }
                return inDebtAccounts;
            }

            @Override
            public List<IAccount> GetAllAccountWithBalance(double balanceAbove) {
                List<IAccount> accountsWithBalance = new ArrayList<>();
                for (IAccount account : accounts) {
                    if (account.GetCurrentBalance() > balanceAbove) {
                        accountsWithBalance.add(account);
                    }
                }
                return accountsWithBalance;

            }
        }

    }
}

