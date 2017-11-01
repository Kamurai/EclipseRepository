package com.fdmgroup.appleGram;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPLES")
public class Apple extends Product 
{
	public Apple() {
		
		
		}

	public Apple(int productId, String productName, BigDecimal productPrice, String productImgURL) {
		super(productId, productName, productPrice, productImgURL);
		
		}

	
}
