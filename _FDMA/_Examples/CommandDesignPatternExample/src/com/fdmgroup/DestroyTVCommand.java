package com.fdmgroup;

public class DestroyTVCommand implements Command {

	//reference to the Television class
		Television tv;
		
		public DestroyTVCommand(Television tv)
		{
			this.tv = tv;
		}
		
		public void execute() 
		{
			tv.destroyTV();
		}

		@Override
		public void executeNumeric(int NumericInput) {
			// TODO Auto-generated method stub
			
		}

}
