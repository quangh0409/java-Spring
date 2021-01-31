package com.example.Java_Spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    private String receiptID;
    private String accountID;
    private int total_money;
    private String status;

}
