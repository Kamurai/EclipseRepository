package cardGameGenerator;
//Kemerait, Christopher
//CSIS 2305
//Playing Card Assignment



import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class CardTemplate
{
  
  	//Establish variables

	//Upper row of card
	private String Name;
	private String Cost;
	private String Recall;
	
	//Artwork
	//private image Artwork;
	
	//Middle row of card
	private String Type;
	private String Affiliation;
	
	//Text (large amount of text)
	private String Text;
	
	//Bottom row of card
	private String XFactor;
	private String Attack;
	private String Defense;
	
	
	

		
		public CardTemplate(String[] CardInfo)
		{
			Name = CardInfo[0];
			Cost = CardInfo[1];
			Recall = CardInfo[2];
			
			Type = CardInfo[3];
			Affiliation = CardInfo[4];
			
			Text = CardInfo[5];
			
			XFactor = CardInfo[6];
			Attack = CardInfo[7];
			Defense = CardInfo[8];
			
			
		}
		
		public void SetInfo(String[] CardInfo)
		{
			Name = CardInfo[0];
			Cost = CardInfo[1];
			Recall = CardInfo[2];
			
			Type = CardInfo[3];
			Affiliation = CardInfo[4];
			
			Text = CardInfo[5];
			
			XFactor = CardInfo[6];
			Attack = CardInfo[7];
			Defense = CardInfo[8];
		}
		

		
		public String GetName()
		{
			return Name;
		}
		
		public String GetCost()
		{
			return Cost;
		}
		
		public String GetRecall()
		{
			return Recall;
		}
		
		public String GetType()
		{
			return Type;
		}
		
		public String GetAffiliation()
		{
			return Affiliation;
		}
		
		public String GetText()
		{
			return Text;
		}
		
		public String GetXFactor()
		{
			return XFactor;
		}
		
		public String GetAttack()
		{
			return Attack;
		}
		
		public String GetDefense()
		{
			return Defense;
		}
}
