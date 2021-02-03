package com.example.Java_Spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDetail {
private String receiptID;
private String productID;
private int count;
}
