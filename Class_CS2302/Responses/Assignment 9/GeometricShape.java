public abstract class GeometricShape
{

	private String name;

	public GeometricShape(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public abstract double area();
	
	public String toString ()
	{
		return name;
	}

}
