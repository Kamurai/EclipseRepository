public class TestShapes
{

	public static void main(String[] args)
	{
		Figures fig = new Figures();
		fig.addShape(new Triangle (10, 5));
		fig.addShape(new Rectangle (12,10));
		fig.addShape(new Rectangle (2, 1));
		fig.addShape(new Circle (5) );
		System.out.println ("contents: " + fig);
		System.out.println ("sum of areas is " + fig.sumOfAreas());
	}

}

/**********************************************
100/100 Please see my comments in your code.
**********************************************/