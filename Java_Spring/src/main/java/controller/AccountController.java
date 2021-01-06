package controller;

import entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/getAll")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/search")
    public Account getAccountById(@RequestParam String id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/addAccount")
    public Boolean addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @PutMapping("/updateAccount/{id}")
    public Boolean updateAccount(@PathVariable("id") String id ,@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/deleteAccount")
    public Boolean deleteAccount(@PathVariable("id") String id) {
        return accountService.deleteAccount(id);
    }
}
