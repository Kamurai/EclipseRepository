package com.fdmgroup.appleGram;

import java.math.BigDecimal;

public class AppleFactory implements ProductFactory {


	public Apple createProduct(int productId, String productName, BigDecimal productPrice, String productImgURL) {
		Apple product = new Apple(productId, productName, productPrice, productImgURL);
		return product;
	}

}
