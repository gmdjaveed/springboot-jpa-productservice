package com.jg.demo.jpa;

import com.jg.demo.jpa.model.Product;
import com.jg.demo.jpa.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductserviceApplicationTests {

    @Autowired
    ProductRepo repo;

    @Test
    void testSaveProduct(){
        Product product = new Product();
        product.setCouponCode("SUPERSALE");
        product.setPrice(new BigDecimal(100));
        product.setName("Samsung-S24");
        product.setDescription("Samsung Galaxy S24");
        repo.save(product);
        System.out.println("testSaveCoupon Saved Coupon:" + product);
    }

    @Test
    void testFindByName(){
        Product product = repo.findByName("Samsung-S24");
        assertEquals (100, product.getPrice().intValue());
        System.out.println("testfindByName Found product:" + product);
    }

}
