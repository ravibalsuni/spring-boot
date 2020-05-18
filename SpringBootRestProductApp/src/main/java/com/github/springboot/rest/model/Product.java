/**
* Application - Manage Product (Read existing Product and Write new Product via REST API)
* Product is used as Pojo or Bean class
*
* @author Ravi Balsuni - https://github.com/ravibalsuni/
*/

package com.github.springboot.rest.model;
 
public class Product {
 
	private Integer id;
	private String name;
	private String supportEmail;
	private String status;
	    
    public Product() {
 
    }
 
    public Product(Integer id, String name, String supportEmail, String status) {
        super();
        this.id = id;
        this.name = name;
        this.supportEmail = supportEmail;
        this.status=status;
    }

  //Getters and setters
    
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupportEmail() {
		return supportEmail;
	}

	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", supportEmail=" + supportEmail + "]";
	}

	
}