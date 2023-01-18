import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {

        private List<IAccount> accounts;

        public Bank() {
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

