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

    @GetMapping("/all")
    public List<Product> getAll(@RequestParam(required = false) String type,@RequestParam(required = false) String sort) {
        if(type!=null && sort != null){
            return productService.getAll(type, sort );
        }
        else {
            return productService.getAll();
        }
    }

    @GetMapping("/search")
    public Product getAllById(@RequestParam String id) {
        return productService.search(id);
    }
    @GetMapping("/getProductByName")
    public Product getProductByName(@RequestParam String name){
        return productService.getProductByName(name);
    }
    @GetMapping("/display")
    public List<Product> display(@RequestParam String str) {
        return productService.display(str);
    }

    @GetMapping("/priceIn")
    public List<Product> priceIn(@RequestParam String str) {
        return productService.priceIn(str);
    }

    @PostMapping("/addProduct")
    public Boolean addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/updateProduct/{id}")
    public Boolean updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct")
    public Boolean deleteProduct(@PathVariable("id") String id) {
        return productService.deleteProduct(id);
    }

    // interceptor
    //filter
    //servlet
    //restController

    //
@GetMapping("/test-ex")
    public Integer test (@RequestParam Integer input){
        return input;
}
}

