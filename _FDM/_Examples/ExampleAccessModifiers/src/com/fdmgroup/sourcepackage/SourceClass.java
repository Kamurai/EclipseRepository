package com.fdmgroup.sourcepackage;

public class SourceClass {

	public void publicMethod()
	{
		System.out.println("Call from the public method");
	}

	protected void protectedMethod()
	{
		System.out.println("Call from the protected method");
	}

	void defaultMethod()
	{
		System.out.println("Call from the <default> (package-private) method");
	}
	
	private void privateMethod()
	{
		System.out.println("Call from the private method");
	}

	public static void main(String[] args)
	{
		System.out.println("Call from public method in SourceClass.");
		
		SourceClass source = new SourceClass();
		
		source.publicMethod();
		source.protectedMethod();
		source.defaultMethod();
		source.privateMethod();
	}
}
