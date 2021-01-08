package com.example.Java_Spring.respository;

import com.example.Java_Spring.helper.AccountMapper;
import com.example.Java_Spring.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRespository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Account> getAll() {
        String sql = "SELECT * FROM Account ;";
        List<Account> list = jdbcTemplate.query(sql, new AccountMapper());
        return list;
    }

    public Account getAccountById(String id) {
        String sql = "SELECT * FROM Account WHERE accountID =? ;";
        Account account = (Account) jdbcTemplate.queryForObject(sql, new AccountMapper(), new Object[]{id});
        return account;
    }
    public List<Account> email(){
    String sql = " SELECT * FROM Account WHERE deleted = 0 ORDER BY email DESC ;" ;
    List<Account> list = jdbcTemplate.query(sql,new AccountMapper());
    return list;
    }

    public Boolean addAccount(Account account) {
        // user NameParameterJdbcTemplate
//        String sql = "INSERT INTO Account (accountID,email,display,password,role,avatar) VALUES(:accountID,:email,:display,:password,:role,:avatar);";
//        Map<String, Object> params = new HashMap<>();
//        params.put("accountID",account.getAccountID());
//        params.put("email",account.getEmail());
//        params.put("display",account.getDisplay());
//        params.put("password",account.getPassword());
//        params.put("role",account.getRole());
//        params.put("avatar",account.getAvatar());
//        namedParameterJdbcTemplate.update(sql,params);
        // JdbcTemppalte
        String sql = "INSERT INTO Account (accountID,email,display,password,role,avatar) VALUES (?,?,?,?,?,?);";

        Object values[] = new Object[6];
        values[0] = account.getAccountID();
        values[1] = account.getEmail();
        values[2] = account.getDisplay();
        values[3] = account.getPassword();
        values[4] = account.getRole();
        values[5] = account.getAvatar();
        jdbcTemplate.update(sql, values);
        return true;
    }

    public Boolean updateAccount(Account account) {

        String sql = "UPDATE Account SET (email,display,password,role,avatar) VALUES(:email,:display,:password,:role,:avatar) WHERE accountID = :accountID and deleted = 0 ;";
        Map<String, Object> params = new HashMap();

        params.put("email", account.getEmail());
        params.put("display", account.getDisplay());
        params.put("password", account.getPassword());
        params.put("role", account.getRole());
        params.put("avatar", account.getAvatar());
        params.put("accountID", account.getAccountID());
        namedParameterJdbcTemplate.update(sql, params);


        return true;
    }

    public Boolean deleteAccount(String id) {
        String sql = "DELETE FROM Account WHERE accountID =? ;";
        jdbcTemplate.update(sql, new Object[]{id});
        return true;
    }

}
