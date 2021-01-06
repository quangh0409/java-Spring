package com.example.Java_Spring.respository;

import com.example.Java_Spring.helper.AccountMapper;
import com.example.Java_Spring.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRespository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Account> getAll() {
        String sql = "SELECT * FROM Account ;";
        List<Account> list = jdbcTemplate.query(sql, new AccountMapper());
        return list;
    }

    public Account getAccountById(String id) {
        String sql = "SELECT * FROM Account WHERE accountID = ? ;";
        Account account = (Account) jdbcTemplate.query(sql, new AccountMapper(), new Object[]{id});
        return account;
    }

    public Boolean addAccount(Account account) {
        String sql = "INSERT INTO Account VALUES(?,?,?,?,?,?);";
        Map<String, Object> params = new HashMap<>();
        params.put("?",account.getAccountID());
        params.put("?",account.getEmail());
        params.put("?",account.getDisplay());
        params.put("?",account.getPassword());
        params.put("?",account.getRole());
        params.put("?",account.getAvatar());
        jdbcTemplate.update(sql,new AccountMapper(),params);
        return true;
    }
    public Boolean updateAccount(Account account){
        String sql = "UPDATE Account SET accountID=? , email= ? , display = ? , password = ? , role = ? , avatar = ? ;";
        Map<String, Object> params = new HashMap<>();
        params.put("?",account.getAccountID());
        params.put("?",account.getEmail());
        params.put("?",account.getDisplay());
        params.put("?",account.getPassword());
        params.put("?",account.getRole());
        params.put("?",account.getAvatar());
        jdbcTemplate.update(sql,new AccountMapper(),params);
        return true;
    }
    public Boolean deleteAccount(String id){
        String sql = "DELETE FROM Account WHERE id = "+id+" ;";
        jdbcTemplate.update(sql,new AccountMapper(),new Object[]{id});
        return  true;
    }

}
