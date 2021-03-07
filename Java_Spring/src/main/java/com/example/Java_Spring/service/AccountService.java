package com.example.Java_Spring.service;

import com.example.Java_Spring.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Java_Spring.respository.AccountRespository;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRespository accountRespository;

    public List<Account> getAll() {
        try {
            return accountRespository.getAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Account getAccountById(String id) {
        try {
            return accountRespository.getAccountById(id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Account> email(String str) {
        try {
            return accountRespository.email(str);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Account> display(String str) {
        try {
            return accountRespository.display(str);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Account> roleStaff(String str) {
        try {
            return accountRespository.roleStaff(str);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Boolean addAccount(Account account) {
        try {
//            if (accountRespository.getAccountById(account.getAccountID()) != null) {
//                return false;
//            } else {
            return accountRespository.addAccount(account);
//            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean updateAccount(Account account) {
        try {
            return accountRespository.updateAccount(account);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean deleteAccount(String id) {
        try {
            return accountRespository.deleteAccount(id);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Account getAccountByEmailAndPassword(String email, String password) {
        return accountRespository.getAccountByEmailAndPassword(email, password);
    }
}
