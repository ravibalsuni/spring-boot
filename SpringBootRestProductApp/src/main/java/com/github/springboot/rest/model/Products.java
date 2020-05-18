/**
* Application - Manage Product (Read existing Product and Write new Product via REST API)
* Products initializes list of products
*
* @author Ravi Balsuni - https://github.com/ravibalsuni/
*/

package com.github.springboot.rest.model;
 
import java.util.ArrayList;
import java.util.List;
 
public class Products 
{
    private List<Product> productList;
     
    public List<Product> getProductList(){
        if(productList == null) {
        	productList = new ArrayList<Product>();
        }
        return productList;
    }
  
    public void setProductList(List<Product> productList){
        this.productList = productList;
    }
}