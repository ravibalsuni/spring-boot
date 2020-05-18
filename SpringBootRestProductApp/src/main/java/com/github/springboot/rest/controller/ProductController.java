/**
* Application - Manage Product (Read existing Product and Write new Product via REST API)
* ProductController is used as a wrapper to get products and add product.
*
*This is where get and post methods hit, once they are invoked via any REST client.
*
* @author Ravi Balsuni - https://github.com/ravibalsuni/
*/

package com.github.springboot.rest.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.springboot.rest.dao.ProductDAO;
import com.github.springboot.rest.model.Product;
import com.github.springboot.rest.model.Products;
 
@RestController
@RequestMapping(path = "/SpringBootRestApp/product")
public class ProductController{
   
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);   

	@Autowired
    private ProductDAO productDao;
     
	//get method call starts below
    @GetMapping(path="/getProducts", produces = "application/json")
    public Products getProducts(){
    	logger.info("/getProducts URI invoked");
        return productDao.getAllProducts();
    }
     
    //post method call starts below
    @PostMapping(path= "/addProduct", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> addProducts(@RequestBody Product product){
        logger.info("/addProduct URI invoked with parameter - "+product);
    	Integer id = productDao.getAllProducts().getProductList().size() + 1;
        Product p = new Product(id, product.getName(), product.getSupportEmail(),"Product Added");
        
        logger.info("new product id set to -"+id);
        productDao.addProduct(p); 
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }
}