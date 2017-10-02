package com.fdmgroup.sourcepackage;

public class ChildClassInSamePackage extends SourceClass {
	
	public static void main(String[] args)
	{
		SourceClass source = new SourceClass();
		
		source.publicMethod();			// public call on SourceClass
		source.protectedMethod();		// protected call on SourceClass
		source.defaultMethod();			// package-private call on SourceClass
		//source.privateMethod();		// private call on SourceClass will never work
		
	}
}
