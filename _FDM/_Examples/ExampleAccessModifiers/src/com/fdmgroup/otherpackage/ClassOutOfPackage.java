package com.fdmgroup.otherpackage;

import com.fdmgroup.sourcepackage.SourceClass;

public class ClassOutOfPackage {

	public static void main(String[] args)
	{
		SourceClass source = new SourceClass();

		source.publicMethod();			// public call on SourceClass
		//source.protectedMethod();		// protected call on SourceClass does not work
		//source.defaultMethod();		// package-private call on SourceClass does not work
		//source.privateMethod();		// private call on SourceClass does not work
	
	}
}
