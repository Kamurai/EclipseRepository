public class Rectangle extends GeometricShape
{

	private double length;
	private double width;

	public Rectangle(double length, double width)
	{
		super("rectangle");
		this.length = length;
		this.width = width;
	}

	public double area()
	{
		return length * width;
	}
	
	public String toString()
	{
		return super.toString() + " with length " + length + " and width " + width;
	}
}
