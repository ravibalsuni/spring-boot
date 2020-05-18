/**
* Application - Manage Product (Read existing Product and Write new Product via REST API)
* ProductDAO is used in ProductController
*
* @author Ravi Balsuni - https://github.com/ravibalsuni/
*/

package com.github.springboot.rest.dao;
 
import org.springframework.stereotype.Repository;

import com.github.springboot.rest.model.Product;
import com.github.springboot.rest.model.Products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@Repository
public class ProductDAO{
    private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);   

    private static Products list = new Products();
     
    static{
    	list.getProductList().add(new Product(1, "glass", "support.glass@gmail.com","Product Added"));
        list.getProductList().add(new Product(2, "plate", "support.plate@gmail.com", "Product Added"));
        list.getProductList().add(new Product(3, "spoon", "support.spoon@gmail.com", "Product Added"));
        logger.info("Product List initialized!!");
    }
     
    public Products getAllProducts(){
    	logger.info("Products List - "+list.getProductList());
        return list;
    }
     
    public void addProduct(Product product) {
        list.getProductList().add(product);
        logger.info("Product Added - Products List is - "+list.getProductList());
    }
}