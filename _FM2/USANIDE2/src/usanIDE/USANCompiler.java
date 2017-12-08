package usanIDE;

import java.util.ArrayList;

import usanIDE.Managers.*;

public class USANCompiler 
{
	String filename;
	
	//Objects by scope
		//Objects for Application management
			SectionManager Omega1;
			AssignmentManager Omega2;
		//Objects for Section management
			//"[HISTORY]" section manager
				HistoryManager Delta1;
			//"[APPLICATION]" section manager
				ApplicationManager Delta2;
			//"[CALL_VARIABLES]" section manager
				CallVariableManager2 Delta3;
			//"[APPLICATION_VARIABLES]" section manager
				ApplicationVariableManager Delta4;
			//"CODE" section manager: signified by [ASSIGN startApplication]
				CodeManager Delta5;
				
			//"[PROMPTS English]" section manager
			//"[PROMPTS English 1]" section manager
			//"[PROMPTS Spanish]" section manager
			//"[PROMPTS French]" section manager
				PromptsManager Gamma1;
			//"[DIGIT_PROMPTS English]" section manager
			//"[DIGIT_PROMPTS English 1]" section manager
			//"[DIGIT_PROMPTS Spanish]" section manager
			//? DIGIT_PROMPTS French
				Digit_PromptsManager Gamma2;
			//"[GENERAL]" section manager
				GeneralManager Gamma3;
				
			//Probably unassigned:
			//"[REFERENCED_APPLICATIONS]" section manager
				Referenced_ApplicationsManager Theta1 = new Referenced_ApplicationsManager();
			//"[EXTENSION_DB]" section manager
				Extension_DBManager Theta2 = new Extension_DBManager();
			//"[DNIS_OUTDIAL_DB]" section manager
				DNIS_Outdial_DBManager Theta3 = new DNIS_Outdial_DBManager();
			//"[SPEECH_VOCABULARY]" section manager
				Speech_VocabularyManager Theta4;
			//"[ANI_OUTDIAL_DB]" section manager
				ANI_Outdial_DBManager Theta5;
			//"[DNIS_ANI_OUTDIAL_DB]" section manager
				DNIS_ANI_Outdial_DBManager Theta6;
			//"[HOST_CONFIGURATION]" section manager
				Host_ConfigurationManager Theta7;
			//"[ANI_MESSAGE_DB]" section manager
				ANI_Message_DBManager Theta8;
			//"[DNIS_MESSAGE_DB]" section manager
				DNIS_Message_DBManager Theta9;
			//"[DNIS_ANI_MESSAGE_DB]" section manager
				DNIS_ANI_Message_DBManager Theta10;
			//"[END]" marker
		//Objects for Module management
			ModuleManager Alpha;
		//Objects for Cell management
			CellManager Beta;
		
	
	public USANCompiler()
	{
		this.filename = "default.htkb";
		
		Alpha = new ModuleManager();
		Beta = new CellManager();
		
		Omega1 = new SectionManager();
		Omega2 = new AssignmentManager();
		Delta1 = new HistoryManager();
		Delta2 = new ApplicationManager();
		Delta3 = new CallVariableManager2();
		Delta4 = new ApplicationVariableManager();
		Delta5 = new CodeManager();
		Gamma1 = new PromptsManager();
		Gamma2 = new Digit_PromptsManager();
		Gamma3 = new GeneralManager();
		Theta1 = new Referenced_ApplicationsManager();
		Theta2 = new Extension_DBManager();
		Theta3 = new DNIS_Outdial_DBManager();
		Theta4 = new Speech_VocabularyManager();
		Theta5 = new ANI_Outdial_DBManager();
		Theta6 = new DNIS_ANI_Outdial_DBManager();
		Theta7 = new Host_ConfigurationManager();
		Theta8 = new ANI_Message_DBManager();
		Theta9 = new DNIS_Message_DBManager();
		Theta10 = new DNIS_ANI_Message_DBManager();
	}
	
	public void setFilename(String input)
	{
		
		this.filename = input;
		
		Delta2.setFilename(filename);
	}
	
	public ArrayList<ArrayList<String>> compileInOrder(String content)
	{
		int tracker = 0;
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		//Structure:
			//Line
			//Start Position found
			//End Position
			//Description of Error
			//Priority
				//1:	OMG NO!
				//2:	Fix this
				//3:	Hey, what're you doing?
		
		//SectionManager
		output = mergeList(Omega1.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//AssignmentManager
		output = mergeList(Omega2.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//History Manager
		output = mergeList(Delta1.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Application Manager
		output = mergeList(Delta2.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Call Variable Manager
		output = mergeList(Delta3.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Application Variable Manager
		output = mergeList(Delta4.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Code Manager
		//output = mergeList(Delta5.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Prompts Manager
		output = mergeList(Gamma1.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Digit Prompts Manager
		output = mergeList(Gamma2.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//General Manager
		output = mergeList(Gamma3.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Referenced_ApplicationsManager
		output = mergeList(Theta1.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Extension_DBManager
		output = mergeList(Theta2.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//DNIS_Outdial_DBManager
		output = mergeList(Theta3.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Speech_VocabularyManager
		output = mergeList(Theta4.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//ANI_Outdial_DBManager
		output = mergeList(Theta5.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//DNIS_ANI_Outdial_DBManager
		output = mergeList(Theta6.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//Host_ConfigurationManager
		output = mergeList(Theta7.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//ANI_Message_DBManager
		output = mergeList(Theta8.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//DNIS_Message_DBManager
		output = mergeList(Theta9.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		//DNIS_ANI_Message_DBManager
		output = mergeList(Theta10.CheckIt(content), output);
		tracker = checkEscape(tracker, output);
		if(tracker == (-1))
		{
			return output;
		}
		
		output = SortIt(output);
		
		return output;		
	}
	
	private ArrayList<ArrayList<String>> SortIt(ArrayList<ArrayList<String>> input)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		
		String InputDescription = "";
		int InputLine = 0;
		int InputIndex = 0;
		
		String OutputDescription = "";
		int OutputLine = 0;
		int OutputIndex = 0;
		
		//move first error from input to output
		output.add(input.get(0));
		
		for(int x = 1; x < input.size(); x++)
		{
			InputDescription = input.get(x).get(3);
			InputLine = Integer.parseInt(input.get(x).get(2));
			InputIndex = Integer.parseInt(input.get(x).get(0));
			
			innerloop:
			for(int y = 0; y < output.size(); y++)
			{
				OutputDescription = input.get(y).get(3);
				OutputLine = Integer.parseInt(output.get(y).get(2));
				OutputIndex = Integer.parseInt(output.get(y).get(0));
				
				//if errors are on the same line
				if(InputLine == OutputLine )
				{
					//if the input error index is the same as the output error index (?)
					if(InputIndex == OutputIndex)
					{
						//just add at current index
						output.add(y, input.get(x));
						break innerloop;
					}
					//if the input error index is after the output error index
					else if(InputIndex > OutputIndex )
					{
						if( (y+1) < (output.size()) )
						{
							//if the input error is on the same line as the next output error but before the next error
							if(InputIndex <= Integer.parseInt(output.get(y+1).get(0)) )
							{
								//add in between this output index and the next
								output.add((y+1), input.get(x));
								break innerloop;
							}
							else
							{
								continue;
							}
						}
						//on last index of output
						else
						{
							//add to end
							output.add(input.get(x));
							break innerloop;
						}
					}
					//if the input error index is before the output error index
					else
					{
						//add at current index
						output.add(y, input.get(x));
						break innerloop;
					}
				}
				//if the input error is a line after the output line
				else if(InputLine > OutputLine )
				{
					if( (y+1) < (output.size()) )
					{
						//if the input error is on the same line as the next output error but before the next error
						if(InputIndex <= Integer.parseInt(output.get(y+1).get(0)) )
						{
							//add in between this output index and the next
							output.add((y+1), input.get(x));
							break innerloop;
						}
						else
						{
							continue;
						}
					}
					//on last index of output
					else
					{
						//add to end
						output.add(input.get(x));
						break innerloop;
					}
				}
				//if the input error is a line before the current output line
				else
				{
					if(y == 1)
					{
						output.add(0, input.get(x));
						break innerloop;
					}
				}
			}
		}
		
		
		return output;
	}
	
	private int checkEscape(int num, ArrayList<ArrayList<String>> input)
	{
		int tracker = num;
		
		while( tracker < input.size())
		{
			if(input.get(tracker).get(4).compareTo("1") == 0)
			{
				//remove all errors before the "1"
				for(int x=0; x < tracker; x++)
				{
					input.remove(0);
				}
				tracker = 0;
				
				//remove all after the first element (where the "1" now is located)
				while(input.size() > 1)
				{
					input.remove((input.size()-1));
				}
				return (-1);
			}
			
			tracker++;
		}
		
		//tracker = 0;		
		return tracker;
	}
	
	private ArrayList<ArrayList<String>> mergeList(ArrayList<ArrayList<String>> input, ArrayList<ArrayList<String>> target)
	{
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>(target);
		
		for(int x = 0; x < input.size(); x++)
		{
			output.add(input.get(x));
		}
		
		return output;
	}
	
	
}
