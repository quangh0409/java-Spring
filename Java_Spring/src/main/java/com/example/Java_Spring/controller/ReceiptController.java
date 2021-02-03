package com.example.Java_Spring.controller;

import com.example.Java_Spring.entity.Receipt;
import com.example.Java_Spring.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Receipt")
public class ReceiptController {
    @Autowired
    ReceiptService receiptDetailService;
    @GetMapping("/getAll")
    public List<Receipt> getAll(){
        return receiptDetailService.GetAll();
    }
    @PostMapping("/create")
    public Boolean Create(@RequestBody Receipt receipt){
        return receiptDetailService.Create(receipt);
    }

}
