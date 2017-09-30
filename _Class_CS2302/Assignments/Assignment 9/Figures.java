import java.util.ArrayList;

public class Figures
{

	private ArrayList<GeometricShape> shapes;

	public Figures()
	{
		shapes = new ArrayList<GeometricShape>();
	}

	public void addShape(GeometricShape shape)
	{
		shapes.add(shape);
	}

	public double sumOfAreas()
	{
		double sum = 0;
		for (int i = 0; i < shapes.size(); i++)
			sum += shapes.get(i).area();
		return sum;
	}

	public String toString()
	{
		return shapes.toString();
	}
}
