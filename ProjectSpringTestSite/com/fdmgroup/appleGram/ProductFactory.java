package com.fdmgroup.appleGram;

import java.math.BigDecimal;

public interface ProductFactory {
	public Product createProduct(int productId, String productName , BigDecimal productPrice , String productImgURL);

}
