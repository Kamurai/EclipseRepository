package com.fdmgroup.demos;


public class VarArgsExample {

	public static void go(int x){
		System.out.println("int method");
	}
	
	public static void go(Object x){
		System.out.println("Object method");
	}
		
	public static void go(String x){
		System.out.println("Single String method");
	}

	public static void go(String ... x){
		System.out.println("Var-arg String method");
	}

	 public static void go(String y, String ... x){  
		 System.out.println("String, Var-arg String method");
	 }
	 
	 public static void go(int x , String ... y){
		 System.out.println("int, Var-arg String method");
	 }

	 
	 //public static void go(String ... x, int y){ }
	
	
	public static void main(String[] args){

		go(5);
		
//		go("hi");
		
//		go("hi","hello");
		
//		go();
	}
	
}