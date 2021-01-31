package com.example.Java_Spring.respository;

import com.example.Java_Spring.entity.Product;
import com.example.Java_Spring.entity.Receipt;
import com.example.Java_Spring.helper.ReceiptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReceiptRespository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Receipt> getAll(){
        String sql = "SELECT * FROM Receipt WHERE deleted = 0;";
        List<Receipt> list = jdbcTemplate.query(sql,new ReceiptMapper());
        return list;
    }
//    public Receipt Create(List<Product> list){
//        String sql = "INSERT INTO ";
//    }
}
