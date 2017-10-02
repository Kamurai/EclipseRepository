package com.fdmgroup.demos;

import java.util.ArrayList;
import java.util.List;




// Shows an upper bound
class AnimalSpecialist<T extends Animal> {

	List<T>	waitingList	= new ArrayList<T>();

	public void examine() {

		for (T patient : waitingList) {
			patient.breathe();
			patient.makeNoise();
			patient.eat();
		}
	}
}



public class BoundsDemo {


	public static void main(String[] args) {
		
		AnimalSpecialist<Cat> catDoctor = new AnimalSpecialist<Cat>();
		catDoctor.waitingList.add(new Cat());
		
		
		
	}

}





