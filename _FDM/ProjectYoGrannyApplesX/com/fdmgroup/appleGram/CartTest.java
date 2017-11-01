package com.fdmgroup.appleGram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CartTest {
	
	ConfigurableApplicationContext ctx;
	Cart testCart;
	Product testProduct;
	Product testProduct2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		testCart = ctx.getBean("mainCart" , Cart.class);
		testProduct= ctx.getBean("apple" , Apple.class);
		testProduct2= ctx.getBean("granny" , Apple.class);
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCartNotNull() {
		
		assertNotNull(testCart);
		
	}
	
	@Test
	public void testAddProductAddedNewProduct(){
		
		testCart.addProduct(testProduct , 1);
		assertTrue(testCart.getProductMap().containsKey(testProduct));
	}
	
	@Test
	public void TestRemoveProductRemovedAProduct(){
		testCart.addProduct(testProduct, 2);
		testCart.removeProduct(testProduct);
		assertFalse(testCart.getProductMap().containsKey(testProduct));
	}
	
	@Test
	public void TestUpdateQuantityChangedQuantity(){
		testCart.addProduct(testProduct, 1);
		testCart.updateProduct(testProduct, 3);
		assertEquals((Integer)testCart.getProductMap().get(testProduct) , (Integer)3);
	}
	
	
	@Test
	public void TestCartTotalWithOneProduct()
	{
		testCart.addProduct(testProduct, 1);
		
		
		System.out.println(testProduct.getPrice());
		System.out.println(testCart.calculateTotal());
		
		assertEquals(testProduct.getPrice(), testCart.calculateTotal());
		
	}
	
	@Test
	public void TestCartTotalWithTwoProducts()
	{
		testCart.addProduct(testProduct2, 8);
		testCart.addProduct(testProduct, 4);
		
		System.out.println(testProduct.getPrice());
		System.out.println(testProduct2.getPrice());
		System.out.println(testCart.calculateTotal());
		
		
		assertEquals( new BigDecimal("15.00"), testCart.calculateTotal());
		
	}
	
}
