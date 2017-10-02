package com.fdmgroup.otherpackage;

import com.fdmgroup.sourcepackage.SourceClass;

public class ChildClassOutOfPackage extends SourceClass {
		
	public static void main(String[] args)
	{

		ChildClassOutOfPackage child = new ChildClassOutOfPackage();
		
		child.publicMethod();			// public call on ChildClassOutOfPackage
		child.protectedMethod();		// protected call on ChildClassOutOfPackage
		//child.defaultMethod();		// package-private call does not work
		//child.privateMethod();		// private call does not work			
		
		/** Note: The protected call only works through inheritance! 
		
		ChildClassOutOfPackage INHERITS protected members of SourceClass.
		
		When using a ChildClassOutOfPackage reference (above), they will be visible.
		When using a SourceClass reference (below), they will not be visible.
		
		**/
		
		SourceClass source = new SourceClass();

		source.publicMethod();			// public call on SourceClass
		//source.protectedMethod();		// protected call on SourceClass does not work!
		//source.defaultMethod();		// package-private call on SourceClass does not work
		//source.privateMethod();		// private call on SourceClass does not work

		SourceClass sourceRefToChild = new ChildClassOutOfPackage();

		sourceRefToChild.publicMethod();		
		//sourceRefToChild.protectedMethod();	
		//sourceRefToChild.defaultMethod();	
		//sourceRefToChild.privateMethod();		

		
	}
}
