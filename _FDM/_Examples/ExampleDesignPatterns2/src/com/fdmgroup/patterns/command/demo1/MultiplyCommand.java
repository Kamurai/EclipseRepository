package com.fdmgroup.patterns.command.demo1;

public class MultiplyCommand implements MathCommand {

	@Override
	public long calculate(long op1, long op2) 
	{	
		System.out.println("Multiplying "+op1+" by "+op2);
		return (op1/1)*(op2/1);
	}

}
