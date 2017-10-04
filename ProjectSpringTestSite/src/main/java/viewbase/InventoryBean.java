package viewbase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import database.AppleDAO;
import entity.Product;

public class InventoryBean
{
	private List<?> productList;
	private AppleDAO appleDAO = new AppleDAO();
	
	public InventoryBean()
	{
		productList = new ArrayList<Product>();
		refresh();
	}

	public List<?> getProductList() {
		return productList;
	}

	public void setProductList(List<?> productList) {
		this.productList = productList;
	}

	private void refresh() 
	{
		productList = appleDAO.getProducts();
		
	}
	
}
