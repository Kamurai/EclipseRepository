package com.fdmgroup.patterns.command.demo1;

public class SubtractCommand implements MathCommand {

	@Override
	public long calculate(long op1, long op2) 
	{	
		System.out.println("Subtracting "+op2+" from "+op1);
		for (int i=0; i<op2; i++)
			op1--;
		return op1;
	}

}
