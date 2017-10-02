package com.fdmgroup;

public class FixTVCommand implements Command {

	//reference to the Television class
		Television tv;
		
		public FixTVCommand(Television tv)
		{
			this.tv = tv;
		}
		
		public void execute() 
		{
			tv.fixTV();
		}

		@Override
		public void executeNumeric(int NumericInput) {
			// TODO Auto-generated method stub
			
		}

}
