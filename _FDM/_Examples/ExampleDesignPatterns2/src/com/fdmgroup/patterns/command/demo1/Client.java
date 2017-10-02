package com.fdmgroup.patterns.command.demo1;

import java.util.Random;

public class Client {

	public static void main(String[] args) {
		
		Random random = new Random();

		int op1 = 33;
		int op2 = 78;
		long answer = 0;

		MathCommand[] mathCommands = new MathCommand[3];
		mathCommands[0] = new AddCommand();
		mathCommands[1] = new SubtractCommand();
		mathCommands[2] = new MultiplyCommand();

		int nextAction = random.nextInt(3);

		answer = mathCommands[nextAction].calculate(op1, op2);
		System.out.println("Answer = " + answer);

	}

}
