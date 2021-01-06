package service;

import entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import respository.AccountRespository;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRespository accountRespository;
    public List<Account> getAll(){
        try{
            return accountRespository.getAll();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public Account getAccountById(String id){
        try{
            return  accountRespository.getAccountById(id);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public Boolean addAccount(Account account){
        try {
            return  accountRespository.addAccount(account);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Boolean updateAccount(Account account){
        try{
            return accountRespository.updateAccount(account);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Boolean deleteAccount(String id){
        try{
            return accountRespository.deleteAccount(id);
        }catch (Exception e){
            System.out.println(e);
            return  false;
        }
    }
}
