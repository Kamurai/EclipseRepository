package com.fdmgroup.appleGram;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AppleFactoryTests {
	private int productId;
	private int mockProductId;
	private String productName;
	private BigDecimal productPrice;
	private String productImgURL;
	private String mockProductName;
	private BigDecimal mockProductPrice;
	private String mockProductImgURL;
	private AppleFactory appleFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		productId = 0;
		productName = "Granny Smith";
		productPrice = new BigDecimal("1");
		productImgURL = "https://pixnio.com/free-images/flora-plants/fruits/apple-pictures/bright-green-granny-smith-apple.jpg";
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test_ifAppleFactorycreateAppleMethodReturnsAnAppleThatIsNotNull() {
		appleFactory = new AppleFactory();
		Apple testApple = appleFactory.createProduct(productId, productName, productPrice, productImgURL);
		assertNotNull(testApple);
	}
	@Test
	public void test_ifAppleFactorycreateAppleMethodReturnsAnAppleThatIsSameName() {
		appleFactory = new AppleFactory();
		Apple testApple = appleFactory.createProduct(productId, productName, productPrice, productImgURL);
		assertEquals(testApple.getName(),productName);
	}
	@Test
	public void test_ifAppleFactorycreateAppleMethodReturnsAnAppleThatIsSamePrice() {
		appleFactory = new AppleFactory();
		Apple testApple = appleFactory.createProduct(productId, productName, productPrice, productImgURL);
		assertEquals(testApple.getPrice(),productPrice);
	}
	@Test
	public void test_ifAppleFactorycreateAppleMethodReturnsAnAppleThatIsSameURL() {
		appleFactory = new AppleFactory();
		Apple testApple = appleFactory.createProduct(productId, productName, productPrice, productImgURL);
		assertEquals(testApple.getPicurl(),productImgURL);
	}

}
