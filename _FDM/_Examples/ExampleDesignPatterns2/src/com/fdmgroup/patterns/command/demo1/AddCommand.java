package com.fdmgroup.patterns.command.demo1;

public class AddCommand implements MathCommand {

	@Override
	public long calculate(long op1, long op2) 
	{
		System.out.println("Adding "+op1+" to "+op2);
		return op1+op2;
	}

}
