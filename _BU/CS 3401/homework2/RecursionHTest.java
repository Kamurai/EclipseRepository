//Masom Hamadeh
//CS3401 HW#2


package homework2;
import tester.*;

public class RecursionHTest{
	public static void main(String[] args){
		Tester.run(new RecursionHTest());
	}

	public void testRecursion(Tester t){
		try{
		//We have no constructors, getters, or setters so we will skip all the tests for them
		
			//Test#1: fractionalSeries method POSITIVE TEST
			t.checkExpect(RecursionH.fractionalSeries(5), ((1.00/5)+(1.00/4)+(1.00/3)+(1.00/2)+(1.00/1)));
			
			try{
			//Test#2: fractionalSeries method NEGATIVE TEST
				RecursionH.fractionalSeries(0);
				t.fail("fractionalSeries method did NOT throw IllegalArgumentException");
			}
			catch (IllegalArgumentException e){
				t.success(); //fractionalSeries method correctly threw of Exception
			}
			
			//Test#3 and #4: gcd method POSITIVE TEST
			t.checkExpect(RecursionH.gcd(56,42), 14);
			t.checkExpect(RecursionH.gcd(10,5), 5);
			
			//Test#5: gcd method NEGATIVE TEST
			try{
				RecursionH.gcd(5,0);
				t.fail("gcd method did NOT throw the ArithmeticException");
			}
			
			catch (ArithmeticException e){
				t.success(); //gcd method correctly threw the ArithmeticException
			}
			
			//Test#6,7,8: largest method POSITIVE TESTs
			double[] a1={10,20,30,40,50};
			t.checkExpect(RecursionH.largest(a1), 50.0);
			
			double[] a2={50,20,30,40,10};
			t.checkExpect(RecursionH.largest(a2), 50.0);
			
			double[] a3={10,9,8,7,6};
			t.checkExpect(RecursionH.largest(a3), 10.0);
			
			//Test#9: largest method NEGATIVE TEST
			double[] a4={};
			
			try{
				RecursionH.largest(a4);
				t.fail("largest method did NOT throw IllegalArgumentException");
			}
			catch (IllegalArgumentException e){
				t.success(); //largest method correclty threw the IllegalArgumetnException
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
			t.fail();
		}
	}
}
