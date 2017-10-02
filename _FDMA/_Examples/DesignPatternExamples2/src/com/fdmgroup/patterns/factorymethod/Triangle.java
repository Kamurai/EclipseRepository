package com.fdmgroup.patterns.factorymethod;

public class Triangle implements Shape {
	
	public void draw() {
		System.out.println("      /\\      ");
		System.out.println("     /  \\");
		System.out.println("    /    \\");
		System.out.println("   /      \\");
		System.out.println("  /        \\");
		System.out.println("  ----------");
	}

}
