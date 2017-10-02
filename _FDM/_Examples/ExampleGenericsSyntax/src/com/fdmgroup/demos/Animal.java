package com.fdmgroup.demos;

public abstract class Animal {

	void makeNoise() {	}

	void breathe() {  }

	void eat() {  }
}

class Dog extends Animal {}

class Cat extends Animal {}

class GuineaPig extends Animal {}
