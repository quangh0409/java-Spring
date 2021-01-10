package com.example.Java_Spring.controller;

import com.example.Java_Spring.entity.Product;
import com.example.Java_Spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/getAll")
    public List<Product> getAll(){
        return  productService.getAll();
    }
    @GetMapping("/search")
    public Product getAllById(@RequestParam String id){
        return productService.search(id);
    }
    @GetMapping("/display")
    public List<Product> display(@RequestParam String str){
        return productService.display(str);
    }
    @GetMapping("/priceIn")
    public List<Product> priceIn(@RequestParam String str){
        return productService.priceIn(str);
    }
    @GetMapping("/addProduct")
    public Boolean addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("/updateProduct/{id}")
    public Boolean updateProduct(@PathVariable("id") String id,@RequestBody Product product){
        return productService.updateProduct( product);
    }
    @GetMapping("/deleteProduct")
    public Boolean deleteProduct(@PathVariable("id") String id){
        return productService.deleteProduct(id);
    }

}
