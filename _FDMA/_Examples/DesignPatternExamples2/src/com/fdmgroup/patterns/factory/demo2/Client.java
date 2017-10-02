package com.fdmgroup.patterns.factory.demo2;

import java.util.Scanner;

public class Client {
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a shape to draw (triangle, square): ");
		
		String answer = scanner.nextLine();
		
		Shape shape = ShapeFactory.create(answer);
		shape.draw();
	}

}
