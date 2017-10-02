package example;
import tester.*;

 
public class Test 
{
	public static void main(String[] args) 
	{
		Tester.run(new Test());
	}

	// /////////////////////////////////////////////////////////////////
	// Create test methods here
	// /////////////////////////////////////////////////////////////////
	public void testBook(Tester t) {
		try {
			// Constructor & getter Positive Tests
			Book a1 = new Book("Dr No","Ian Fleming", true,500);
			t.checkExpect(a1.getTitle(), "Dr No");
			t.checkExpect(a1.getAuthor(), "Ian Fleming");
			t.checkExpect(a1.isHardcover(),true);
			t.checkExpect(a1.getPages(), 500);

			// Constructor Negative Test
			// Should throw exception for pages=0
			try {
				Book a2 = new Book("Dr No","Ian Fleming", true,0);
				t.fail("Constructor did not throw exception");
			}
			catch (IllegalArgumentException e) {
				// Constructor correctly threw exception
				t.success();
			}
			
			// Getter Negative Tests (if any)
			
			// Setter methods Positive tests
			a1.setTitle("Goldfinger");
			t.checkExpect(a1, new Book("Goldfinger","Ian Fleming", true, 500));
			
			a1.setAuthor("John LeCarre");
			t.checkExpect(a1, new Book("Goldfinger","John LeCarre", true, 500));
		
			a1.setHardcover(false);
			t.checkExpect(a1, new Book("Goldfinger","John LeCarre", false, 500));
		
			a1.setPages(1000);
			t.checkExpect(a1, new Book("Goldfinger","John LeCarre", false, 1000));
		
			// Setter methods Negative Tests (if any)
			// Should throw exception for pages = 0
			try {
				a1.setPages(0);
				t.fail("setPages method did not throw exception");
			}
			catch (IllegalArgumentException e) {
				// setPages method correctly threw exception
				t.success();
			}	
			
			// cost method Positive test
			t.checkExpect(a1.cost(), a1.getPages() * (1/2));

			// No Negative tests for cost method
			
			
		} // Come here for any unexpected Exceptions
		catch (Exception e) {
			e.printStackTrace();
			t.fail();
		}
	}
}
