package com.example.Java_Spring.respository;

import com.example.Java_Spring.entity.Account;
import com.example.Java_Spring.entity.Product;
import com.example.Java_Spring.helper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRespository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAll() {
        String sql = "SELECT * FROM Product WHERE deleted = 0 ;";
        List<Product> list = jdbcTemplate.query(sql, new ProductMapper());
        return list;
    }

    public Product getProductById(String id) {
        String sql = "SELECT * FROM Product WHERE productID = ? and deleted = 0 ;";
        Product product = (Product) jdbcTemplate.queryForObject(sql, new ProductMapper(), new Object[]{id});
        return product;
    }

    public Boolean addProduct(Product product) {
        String sql = "INSERT INTO Product (productID,display,priceIn,priceOut,priceSale,amount,shipday,description,images) VALUES (?,?,?,?,?,?,?,?,?) WHERE deleted = 0;";
        Object params[] = new Object[9];
        params[0] = product.getProductID();
        params[1] = product.getDisplay();
        params[2] = product.getPriceIn();
        params[3] = product.getPriceOut();
        params[4] = product.getPriceSale();
        params[5] = product.getAmount();
        params[6] = product.getShipday();
        params[7] = product.getDescription();
        params[8] = product.getImages();
        jdbcTemplate.update(sql, params);
        return true;

    }

    public Boolean updateProduct(Product product) {
        String sql = "UPDATE Product SET " +
                " display =?," +
                "priceIn =?," +
                "priceOut =?," +
                " priceSale =?," +
                " amount =?," +
                "shipday =?," +
                "description =?," +
                "images =? " +
                "WHERE productID =? and deleted = 0;";
        Object params[] = new Object[9];
        params[0] = product.getDisplay();
        params[1] = product.getPriceIn();
        params[2] = product.getPriceOut();
        params[3] = product.getPriceSale();
        params[4] = product.getAmount();
        params[5] = product.getShipday();
        params[6] = product.getDescription();
        params[7] = product.getImages();
        params[8] = product.getProductID();
        jdbcTemplate.update(sql, params);
        return true;
    }
//    public Boolean deleteProduct(String id){
//        String sql = "SELECT "
//    }
}
