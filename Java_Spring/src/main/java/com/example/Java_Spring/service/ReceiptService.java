package com.example.Java_Spring.service;

import com.example.Java_Spring.entity.Receipt;
import com.example.Java_Spring.respository.ReceiptDetailRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {
    @Autowired
    ReceiptDetailRespository receiptDetailRespository;
    public List<Receipt> GetAll(){
        try {
            return receiptDetailRespository.getAll();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public Boolean Create(Receipt receipt){
        try {
            return receiptDetailRespository.Create(receipt);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
