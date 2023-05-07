import exceptions.WrongAccountException;
import exceptions.WrongCurrencyException;
import exceptions.WrongOperationException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication();
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("accountId000", 50, "USD"));
        accountList.add(new Account("accountId003", 250, "HRV"));
        accountList.add(new Account("accountId001", 50, "EUR"));
        accountList.add(new Account("accountId001", 50, "USD"));
        accountList.add(new Account("accountId001", 50, "USD"));
        for (Account account:accountList) {
            tryProcess(bankApplication, account);
        }
    }


    public static void tryProcess (BankApplication bankApplication, Account account){
    try {
        bankApplication.process(account.getId(), account.getBalance(), account.getCurrency());
    }
    catch (WrongAccountException wrongAccount){
        System.out.println("Такого акаунту не існує");
    }
    catch (WrongCurrencyException wrongCurrency){
        System.out.println("Акаунт має рахунок в іншій валюті");
    }
    catch (WrongOperationException wrongOperation) {
        System.out.println("Акаунт не має достатньо коштів");
    }
    catch (Exception exception) {
        System.out.println("Сталася помилка при процесінгу, спробуйте ще раз");
    }
    finally {
        System.out.println("Дякуємо, що скористалися нашим сервісом");
        System.out.println();
    }
    }
}
