/**
* Application - Manage Employee 
* (Read existing Employee and Write new Employee via custom REST API in Camunda)
* EmployeeControllerTest - for Testing Custom REST functionality
*
* @author Ravi Balsuni - https://github.com/ravibalsuni/
*/

package com.github.springboot.rest.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import com.github.springboot.rest.controller.ProductController;
import com.github.springboot.rest.dao.ProductDAO;
import com.github.springboot.rest.model.Product;
import com.github.springboot.rest.model.Products;
 
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ProductControllerTest{
  
  private static final Logger logger = LoggerFactory.getLogger(ProductControllerTest.class);   
	
  @InjectMocks
  ProductController productController;
     
  @Mock
  ProductDAO productDAO;
       
  @Test
  public void testgetProducts(){
      
    Product product1 = new Product(1, "Plate", "support.plate@gmail.com","Product Added");
    Product product2 = new Product(2, "Glass", "support.glass@gmail.com","Product Added");
    Products products = new Products();
    products.setProductList(Arrays.asList(product1, product2));
 
    when(productDAO.getAllProducts()).thenReturn(products);
       
    Products result = productController.getProducts();
    logger.info(result.getProductList().toString());
 
    
    logger.info(Integer.toString((result.getProductList().size())));
    assertThat(result.getProductList().size()).isEqualTo(2);      
    
    logger.info(result.getProductList().get(0).toString());
    assertThat(result.getProductList().get(0).getName()).isEqualTo(product1.getName());
    
    logger.info(result.getProductList().get(1).toString());
    assertThat(result.getProductList().get(1).getName()).isEqualTo(product2.getName());
    
  }
    
  @Test
  public void testAddProductsURL(){
   
    MockHttpServletRequest request = new MockHttpServletRequest();
	InputStream inputStream = null;
	
	try {
		Properties prop = new Properties();
		String propFileName = "environment.properties";

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		String host = prop.getProperty("host");
		String port = prop.getProperty("port");
		String testUri = prop.getProperty("testUriForAddProduct");
		String serviceUrl = prop.getProperty("serviceUrlForAddProduct");
		
        request.setServerName(host+":"+port);
        request.setRequestURI(testUri);
    
        String url = request.getRequestURL().toString();
        assertThat(url).isEqualTo(serviceUrl);
    }
	catch (Exception e) {
		 logger.info(e.getMessage());	
	}
	finally {
		try {
			inputStream.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
  }
  
}
