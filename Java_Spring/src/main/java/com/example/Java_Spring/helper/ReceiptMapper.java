package com.example.Java_Spring.helper;

import com.example.Java_Spring.entity.Receipt;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptMapper implements RowMapper {

    @Override
    public Receipt mapRow(ResultSet resultSet, int i) throws SQLException {
        Receipt receipt = new Receipt();
        receipt.setReceiptID(resultSet.getString("receipt"));
        receipt.setAccountID(resultSet.getString("accountID"));
        receipt.setTotal_money(resultSet.getInt("total_money"));
        receipt.setStatus(resultSet.getString("status"));
        return receipt;
    }
}
