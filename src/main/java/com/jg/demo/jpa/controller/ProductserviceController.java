package com.jg.demo.jpa.controller;

import com.jg.demo.jpa.dto.Coupon;
import com.jg.demo.jpa.model.Product;
import com.jg.demo.jpa.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ProductserviceController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    RestTemplate restTemplate;

    @Value("${coupon.service.url}")
    String couponServiceUrl;

    @PostMapping(value = "/products")
    public Product createProduct(@RequestBody Product product){

        String fullCouponServiceUrl = couponServiceUrl + product.getCouponCode();
        Coupon coupon  = restTemplate.getForObject(fullCouponServiceUrl, Coupon.class);

        System.out.println("Coupon service URL:" + fullCouponServiceUrl + ", Coupon:" + coupon);

        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        System.out.println(" Before save -> Product:" + product);

        return productRepo.save(product);
    }

    @GetMapping(value = "/products/{name}")
    public Product getProduct(@PathVariable ("name") String name){
        return productRepo.findByName(name);
    }
}
