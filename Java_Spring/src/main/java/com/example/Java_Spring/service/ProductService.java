package com.example.Java_Spring.service;

import com.example.Java_Spring.entity.Product;
import com.example.Java_Spring.respository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRespository productRespository;

    public List<Product> getAll() {
        try {
            return productRespository.getAll();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Product> getAll(String type, String sort) {
        try {
            return productRespository.getAll(type,sort);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Product search(String id) {
        try {
            return productRespository.getProductById(id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Product> display(String str) {
        try {
            return productRespository.display(str);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Product> priceIn(String str) {
        try {
            return productRespository.priceIn(str);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Boolean addProduct(Product product) {
        try {
            return productRespository.addProduct(product);
        } catch (Exception e) {
            System.out.println(e);
            return false;

        }
    }

    public Boolean updateProduct(Product product) {
        try {
            return productRespository.updateProduct(product);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean deleteProduct(String id) {
        try {
            return productRespository.deleteProduct(id);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
