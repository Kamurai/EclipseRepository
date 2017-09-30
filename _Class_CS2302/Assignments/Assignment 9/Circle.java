public class Circle extends GeometricShape
{

	private double radius;

	public Circle(double radius)
	{
		super("circle");
		this.radius = radius;
	}

	public double area()
	{
		return 3.14 * radius * radius;
	}

	public String toString()
	{
		return super.toString() + " with radius " + radius;
	}
}
