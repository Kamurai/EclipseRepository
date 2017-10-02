package assignment9;

public class Triangle extends GeometricShape
{

	private double base;

	private double height;

	public Triangle(double base, double height)
	{
		super("triangle");
		this.base = base;
		this.height = height;
	}

	public double area()
	{
		return 0.5 * base * height;
	}

	public String toString()
	{
		return super.toString() + " with base " + base + " and height " + height;
	}
}
