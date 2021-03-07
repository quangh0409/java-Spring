package com.example.Java_Spring.dto;

import com.example.Java_Spring.entity.Account;
import com.example.Java_Spring.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductDto {
    List<Product> products;
    Account account;
}
