# Spningboot JPA - Coupon Service application

A simple "Product Service application" using Spningboot JPA with REST service.

### Credit:
```
- https://www.udemy.com/course/java-interview-help/learn/lecture/26087200#overview
- By Bharath Thippireddy
```

## Pre-requisite:
```
1) Any IDE such as Intellij to build and test the application
2) Mysql server and mysql workbench - to create database tables
3) Postman to test the application
```


## Git Hub Repo (Coupon Service application): 
#### (Coupon Service application is being used by Product Service application)
``` 
https://github.com/gmdjaveed/springboot-jpa-couponservice.git
```

## Git Hub Repo (Product Service application):
#### (Product Service application make use of Coupon Service application)
``` 
https://github.com/gmdjaveed/springboot-jpa-productservice.git
```

## Checkout the applications from Github repository
```
1) Checkout both the above applications
   a) git clone https://github.com/gmdjaveed/springboot-jpa-couponservice.git
   b) git clone https://github.com/gmdjaveed/springboot-jpa-productservice.git
```

## Create the Mysql database and tables
```
  Note: You can update the database user/password in application.properties file for each of the application.
  1) Open Mysql workbench
  2) Use the scripts under \dbscripts folder to create the database and corresponding tables.
```

## Testing the applications
```
1) First start the Couponservice application:
   a) Ex: From Intellij: Right click on "CouponserviceApplication.java" and run.

2) Next start the Productservice application:
   a) Ex: From Intellij: Right click on "ProductserviceApplication.java" and run.

3) Coupon Service:
   a) Use the Create Coupon service URL in Postman with "POST" method
   URL : http://localhost:9091/couponservice/api/coupons
   Raw Body:
      {
         "code": "SUPERSALE",
         "discount": 20.000,
         "expDate": "12/12/2025"
      }    
       
   b) Use the Get Coupon service URL in Postman with "GET" method
   URL : http://localhost:9091/couponservice/api/coupons/SUPERSALE
   
4) Product Service:
   a) Use the Create Product service URL in Postman with "POST" method
   URL : http://localhost:9092/productservice/api/products
   Raw Body:
      {
          "name": "Samsung-S24",
          "description": "Samsung Galaxy S24",
          "price": 100,
          "couponCode": "SUPERSALE"
      } 
       
   b) Use the Get Product service URL in Postman with "GET" method
   URL : http://localhost:9092/productservice/api/products/Samsung-S24                 
```

## Optionally Testing the applications through SpringBootTest runner
```
 1) You can optionally test the application locally by running each test independently by right clicking the below classes:
   - First Create/Save methods
   - Then Get/Find methods
  
   a) ../test/CouponserviceApplicationTests
      i)testSaveCoupon()
      ii)testFindByCoupon()
      
   b) ../test/ProductserviceApplicationTests
      i)testSaveProduct()
      ii)testFindByName()           
```