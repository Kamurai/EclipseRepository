//Kemerait, Christopher
//Database Project: Bloodbowl Option
//Database Panel

package bblm;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;


public class DatabasePanel extends JPanel
{
	String Result = "";
	String TableName = "";
	String Edit[] =
	{
		new String(""),
		new String(""),
		new String("")
	}; 
	
	int EastCount = 3;
	int WestCount = 3;
	int SouthCount = 8;
	int NorthCount = 3;
	
	int Cap = 0;
	int Trip = 0;
	
	
	//Establish Subsquent Panels
		JPanel NorthPanel = new JPanel();
		JPanel SouthPanel = new JPanel();
		JPanel EastPanel = new JPanel();
		JPanel WestPanel = new JPanel();
		JPanel CenterPanel = new JPanel();

	//Establish Test Labels

		JLabel EastLabelList[] =
		{
			new JLabel("Specify Team"),
			new JLabel("Edit Team Name"),
			new JLabel("Edit Primary Team Color"),
			new JLabel("Edit Secondary Team Color"),
			new JLabel("Specify Manager"),
			new JLabel("Edit Manager E-Mail"),
			new JLabel("Specify Player"),
			new JLabel("Edit Player Name"),
			new JLabel("Edit Player's Team"),
			new JLabel("Edit Player's Manager")
		};
		
		JButton EastButtonList[] =
		{
			new JButton("Edit Team"),
			new JButton("Edit Manager"),
			new JButton("Edit Player")		
		};

		JTextField EastInputList[] =
		{
			//Specify Team
			new JTextField (10),
			//Team Name
			new JTextField (10),
			//Team Color 1
			new JTextField (10),
			//Team Color 2
			new JTextField (10),
			//Specify Manager
			new JTextField (10),
			//Manager Email
			new JTextField (10),
			//Specify Player
			new JTextField (10),
			//Player Name
			new JTextField (10),
			//Player's Team Name
			new JTextField (10),
			//Player's Manager Name
			new JTextField (10),
			
		};
      
		
				
		JLabel SouthLabelList[] =
		{
			new JLabel("Report Players by Team"),
			new JLabel("Report Players by Manager"),
			new JLabel("Report Players by Player"),
			new JLabel("Report Players by Position")
		};
		
		JButton SouthButtonList[] =
		{
			new JButton("Report Players by Team"),
			new JButton("Report Players by Manager"),
			new JButton("Report Players by Position"),
			new JButton("Report Positions by Race"),
			new JButton("Full Team Report"),
			new JButton("Full Manager Report"),
			new JButton("Full Player Report"),
			new JButton("Full Position Report"),
			new JButton("Report specific Team"),
			new JButton("Report specific Manager"),
			new JButton("Report specific Player"),
			new JButton("Report specific Position")
			
			
		
		};

		JTextField SouthInputList[] =
		{
			new JTextField (10),
			new JTextField (10),
			new JTextField (10),
			new JTextField (10),
			new JTextField (10),
			new JTextField (10),
			new JTextField (10),
			new JTextField (10)
			
		};



		JLabel WestLabelList[] =
		{
			new JLabel("Team Name"),
			new JLabel("Team Race"),
			new JLabel("Primary Color"),
			new JLabel("Secondary Color"),
			new JLabel("Manager Name"),
			new JLabel("Manager E-mail"),
			new JLabel("Player Name"),
			new JLabel("Player Position"),
			new JLabel("Player Team"),
			new JLabel("Player Manager")
			
		};
		
		JButton WestButtonList[] =
		{
			new JButton("Create New Team"),
			new JButton("Register New Manager"),
			new JButton("Buy New Player")	
		};

		JTextField WestInputList[] =
		{
			//Team Name
			new JTextField (10),
			//Team Race
			new JTextField (10),
			//Team Color 1
			new JTextField (10),
			//Team Color 2
			new JTextField (10),
			//Manager Name
			new JTextField (10),
			//Manager Email
			new JTextField (10),
			//Player Name
			new JTextField (10),
			//Player Position
			new JTextField (10),
			//Player's Team Name
			new JTextField (10),
			//Player's Manager Name
			new JTextField (10),
			
		};
		
		JLabel NorthLabelList[] =
		{
			new JLabel("Delete Team"),
			new JLabel("Delete Manager"),
			new JLabel("Delete Player")
		};
		
		JButton NorthButtonList[] =
		{
			new JButton("Delete Team"),
			new JButton("Delete Manager"),
			new JButton("Delete Player")	
		};

		JTextField NorthInputList[] =
		{
			new JTextField (10),
			new JTextField (10),
			new JTextField (10)
		};

		
		
		JTextArea NorthDisplay = new JTextArea();		
	
		JTextArea CenterDisplay = new JTextArea();
	
		JTextArea SouthDisplay = new JTextArea();
		
	//Establish Exceptions
      StringTooLongException tosser = new StringTooLongException ("Too Many Characters in string input.");
 	
	
		
	public DatabasePanel()throws SQLException, IOException 
	{
	
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e)
		{
 			System.out.println("Could not load the driver");
  		}
		
	String user="TestUser";
 	String pass="password";
  	String v_cid;
  


 
		//Set Panel
		setBackground (Color.white);
      setPreferredSize (new Dimension (1050, 750));
		
		//Set Layout
		setLayout ( new BorderLayout() );
		
		//Add Objects

		//Add Subsequent Panel
			add (CenterPanel, BorderLayout.CENTER);
			add (NorthPanel, BorderLayout.NORTH);
			add (SouthPanel, BorderLayout.SOUTH);
			add (EastPanel, BorderLayout.EAST);
			add (WestPanel, BorderLayout.WEST);

			CenterPanel.setBackground (Color.blue);
			NorthPanel.setBackground (Color.white);
			SouthPanel.setBackground (Color.white);
			EastPanel.setBackground (Color.white);
			WestPanel.setBackground (Color.white);
		
		//Add Text Areas
			CenterPanel.add (CenterDisplay);
						
			
			EastPanel.setLayout( new GridLayout(23,1));
			WestPanel.setLayout( new GridLayout(23,1));
			SouthPanel.setLayout( new GridLayout(5,4));
			NorthPanel.setLayout( new GridLayout(2,3));
			
			NorthDisplay.setText("");
			CenterDisplay.setText("");

						
			//Load East Objects
			for(int x = 0; x < 4; x++)
			{
				EastPanel.add(EastLabelList[x]);
				EastPanel.add(EastInputList[x]);			
			};
			EastPanel.add(EastButtonList[0]);			
			
			for(int x = 4; x < 6; x++)
			{
				EastPanel.add(EastLabelList[x]);
				EastPanel.add(EastInputList[x]);
			}			
			EastPanel.add(EastButtonList[1]);			
			
			for(int x = 6; x < 10; x++)
			{
				EastPanel.add(EastLabelList[x]);
				EastPanel.add(EastInputList[x]);			
			};
			EastPanel.add(EastButtonList[2]);
						
			//Add Editor Listeners to East Buttons
			for(int x = 0; x < EastCount; x++)
			{
				EastButtonList[x].addActionListener( new Editor() );
			};

			
			
			//Load West Objects
			for(int x = 0; x < 4; x++)
			{
				WestPanel.add(WestLabelList[x]);
				WestPanel.add(WestInputList[x]);			
			};
			WestPanel.add(WestButtonList[0]);			
			
			for(int x = 4; x < 6; x++)
			{
				WestPanel.add(WestLabelList[x]);
				WestPanel.add(WestInputList[x]);
			}			
			WestPanel.add(WestButtonList[1]);			
			
			for(int x = 6; x < 10; x++)
			{
				WestPanel.add(WestLabelList[x]);
				WestPanel.add(WestInputList[x]);			
			};
			WestPanel.add(WestButtonList[2]);
						
			//Add Creator Listeners to West Buttons
			for(int x = 0; x < WestCount; x++)
			{
				WestButtonList[x].addActionListener( new Creator() );
			};
			
			
			
			//Load South Objects
			for(int x = 4; x < 8; x++)
			{
				SouthPanel.add(SouthInputList[x]);
			};
			for(int x = 8; x < 12; x++)
			{
				SouthPanel.add(SouthButtonList[x]);
				SouthButtonList[x].addActionListener(new GiveReport());
			};
			
			for(int x = 0; x < 4; x++)
			{
				SouthPanel.add(SouthInputList[x]);
			};	
			for(int x = 0; x < 4; x++)
			{
				SouthPanel.add(SouthButtonList[x]);
				SouthButtonList[x].addActionListener( new GiveReport() );
			
			};
			
			for(int x = 4; x < 8; x++)
			{
			SouthPanel.add(SouthButtonList[x]);
			SouthButtonList[x].addActionListener(new GiveReport());
			};
			
			//Load North Objects
			for(int x = 0; x < 3; x++)
			{
				NorthPanel.add(NorthInputList[x]);
			};
			for(int x = 0; x < 3; x++)
			{
				NorthPanel.add(NorthButtonList[x]);
				NorthButtonList[x].addActionListener(new Deletor());
			};
			
			

   }
	
	 	private class GiveReport implements ActionListener 
      {
	

         public void actionPerformed (ActionEvent event)

         {
			Result = "";
			Trip = 0;

			if( event.getSource() == SouthButtonList[0] )
			{
				TableName = "Player";
				//Team Cap
				Cap = 20;
				Result = SouthInputList[0].getText();
				Trip = 0;
			}
			else if( event.getSource() == SouthButtonList[1] )
			{
				TableName = "Player";
				//Manager Cap
				Cap = 30;
				Result = SouthInputList[1].getText();
				Trip = 1;
			}
			else if( event.getSource() == SouthButtonList[2] )
			{
				TableName = "Player";
				//Position Cap
				Cap = 25;
				Result = SouthInputList[2].getText();
				Trip = 3;
			}
			else if( event.getSource() == SouthButtonList[3] )
			{
				//Report Position by Race
				TableName = "Position";
				//Race Cap
				Cap = 12;
				Result = SouthInputList[3].getText();
				Trip = 0;
			}
			else if( event.getSource() == SouthButtonList[4] )
			{
				TableName = "Team";
				Cap = 20;
				Result = "*";
			}
			else if( event.getSource() == SouthButtonList[5] )
			{
				TableName = "Manager";
				Cap = 30;
				Result = "*";
			}
			else if( event.getSource() == SouthButtonList[6] )
			{
				TableName = "Player";
				Cap = 15;
				Result = "*";
			}
			else if( event.getSource() == SouthButtonList[7] )
			{
				TableName = "Position";
				Cap = 25;
				Result = "*";
			}
			else if( event.getSource() == SouthButtonList[8] )
			{
				TableName = "Team";
				Cap = 20;
				Result = SouthInputList[4].getText();
			}
			else if( event.getSource() == SouthButtonList[9] )
			{
				TableName = "Manager";
				Cap = 30;
				Result = SouthInputList[5].getText();
			}
			else if( event.getSource() == SouthButtonList[10] )
			{
				TableName = "Player";
				Cap = 15;
				Trip = 2;
				Result = SouthInputList[6].getText();
			}
			else if( event.getSource() == SouthButtonList[11] )
			{
				TableName = "Position";
				Cap = 25;
				Result = SouthInputList[7].getText();
				Trip = 1;
			}
			

			//Error Handling "try"
			try
			{			
   	   //check String against "cap" and
     	      Result = CheckString(Result, Cap);
			//Query database for Report
				Result = QueryReport(Result, TableName, Trip);
			}
			catch(StringTooLongException tosser)
			{
				Result = "Input was too long.";
				Result += "\nPlease try again.";
				
			}	
   		catch (SQLException e)
			{
 				Result = "SQL Exception";
				Result += "\nSome or all of the data specified was invalid.";
				Result += "\nPlease try again.";
				CenterDisplay.setText( Result );
  			}
			catch (IOException e)
			{
				Result = "IO Exception";
				CenterDisplay.setText( Result );
			}

			//Output Results
            CenterDisplay.setText( Result );
      	}
      
      }

		private class Deletor implements ActionListener 
      {
	

         public void actionPerformed (ActionEvent event)

         {
			Result = "";

			if( event.getSource() == NorthButtonList[0] )
			{
				TableName = "Team";
				//Team Cap
				Cap = 20;
				Result = NorthInputList[0].getText();
			}
			else if( event.getSource() == NorthButtonList[1] )
			{
				TableName = "Manager";
				//Manager Cap
				Cap = 30;
				Result = NorthInputList[1].getText();
			}
			else if( event.getSource() == NorthButtonList[2] )
			{
				TableName = "Player";
				//Player Cap
				Cap = 15;
				Result = NorthInputList[2].getText();
			}
			
			//Error Handling "try"
			try
			{			
   	   //check String against "cap" and
     	      Result = CheckString(Result, Cap);
				
			//Update Deletions in database
				Deletion(Result, TableName);
			}
			catch(StringTooLongException tosser)
			{
				Result = "Input was too long.";
				Result += "\nPlease try again.";
				
			}	
   		catch (SQLException e)
			{
 				Result = "SQL Exception";
				Result += "\nMost likely the Manager or Team undergoing deletion still contains a player.";
				Result += "\nPlease try again.";

				CenterDisplay.setText( Result );
  			}
			catch (IOException e)
			{
				Result = "IO Exception";
				CenterDisplay.setText( Result );
			}


      	}
      
      }

		private class Editor implements ActionListener 
      {
			String Result = "";
	

         public void actionPerformed (ActionEvent event)

         {
			Result = "";
			
			for(int x = 0; x < 3; x++)
			{
				Edit[x] = "";
			};
			
			if( event.getSource() == EastButtonList[0] )
			{
				TableName = "Team";
				//Team Cap
				Cap = 20;
				Result = EastInputList[0].getText();
				Edit[0] = EastInputList[1].getText();
				Edit[1] = EastInputList[2].getText();
				Edit[2] = EastInputList[3].getText();
			}
			else if( event.getSource() == EastButtonList[1] )
			{
				TableName = "Manager";
				//Manager Cap
				Cap = 30;
				Result = EastInputList[4].getText();
				Edit[0] = EastInputList[5].getText();
				Edit[1] = "";
				Edit[2] = "";

			}
			else if( event.getSource() == EastButtonList[2] )
			{
				TableName = "Player";
				//Player Cap
				Cap = 15;
				Result = EastInputList[6].getText();
				Edit[0] = EastInputList[7].getText();
				Edit[1] = EastInputList[8].getText();
				Edit[2] = EastInputList[9].getText();

			}
			
			//Error Handling "try"
			try
			{			
   	   //check String against "cap" and
     	      Result = CheckString(Result, Cap);
				if( TableName.equals("Team") )
				{
					Edit[0] = CheckString(Edit[0], Cap);
					Edit[1] = CheckString(Edit[1], 15);
					Edit[2] = CheckString(Edit[2], 15);
				}
				else if( TableName.equals("Manager") )
				{
					Edit[0] = CheckString(Edit[0], 40);
				}
				else if( TableName.equals("Player") )
				{
					Edit[0] = CheckString(Edit[0], Cap);
					Edit[1] = CheckString(Edit[1], 15);
					Edit[2] = CheckString(Edit[2], 30);
				}
				
			//Update Editations in database
				Editation(Result, Edit[0], Edit[1], Edit[2], TableName);
			}
			catch(StringTooLongException tosser)
			{
				Result = "Input was too long.";
				Result += "\nPlease try again.";
				
			}	
   		catch (SQLException e)
			{
 				Result = "SQL Exception";
				Result += "\nSome or all of the data entered was missing or invalid.";
				Result += "\nPlease try again.";
				
				CenterDisplay.setText( Result );
  			}
			catch (IOException e)
			{
				Result = "IO Exception";
				CenterDisplay.setText( Result );
			}



      	}
      
      }



		private class Creator implements ActionListener 
      {
	

         public void actionPerformed (ActionEvent event)

         {
			
									
			Result = "";
			for(int x = 0; x < 3; x++)
			{
				Edit[x] = "";
			};

			if( event.getSource() == WestButtonList[0] )
			{
				TableName = "Team";
				//Team Cap
				Cap = 20;
				Result = WestInputList[0].getText();
				Edit[0] = WestInputList[1].getText();
				Edit[1] = WestInputList[2].getText();
				Edit[2] = WestInputList[3].getText();
			}
			else if( event.getSource() == WestButtonList[1] )
			{
				TableName = "Manager";
				//Manager Cap
				Cap = 30;
				Result = WestInputList[4].getText();
				Edit[0] = WestInputList[5].getText();
				Edit[1] = "";
				Edit[2] = "";
				

						

			}
			else if( event.getSource() == WestButtonList[2] )
			{
				TableName = "Player";
				//Player Cap
				Cap = 15;
				Result = WestInputList[6].getText();
				Edit[0] = WestInputList[7].getText();
				Edit[1] = WestInputList[8].getText();
				Edit[2] = WestInputList[9].getText();

			}
			
			//Error Handling "try"
			try
			{			
   	   //check String against "cap" and
     	      Result = CheckString(Result, Cap);
							
				if( TableName.equals("Team") )
				{
					//Team Race Cap
					Edit[0] = CheckString(Edit[0], 25);
					//Team Color 1 Cap
					Edit[1] = CheckString(Edit[1], 15);
					//Team Color 2 Cap
					Edit[2] = CheckString(Edit[2], 15);
					
						
				}
				else if( TableName.equals("Manager") )
				{
					//Manager Email Cap
					Edit[0] = CheckString(Edit[0], 40);
										
				}
				else if( TableName.equals("Player") )
				{
					//Position Cap
					Edit[0] = CheckString(Edit[0], 25);
					//Team Cap
					Edit[1] = CheckString(Edit[1], 30);
					//Manager Cap
					Edit[2] = CheckString(Edit[2], 30);
				}
				
					
			//Update Creation in database
				Creation(Result, Edit[0], Edit[1], Edit[2], TableName);
				
									
			}
			catch(StringTooLongException tosser)
			{
				Result = "Input was too long.";
				Result += "\nPlease try again.";
				
			}	
   		catch (SQLException e)
			{
 				Result = "SQL Exception";
				Result += "\nSome or all of the data entered was invalid.";
				Result += "\nIt is possible the entity being created already exists.";
				Result += "\nPlease try again.";
				CenterDisplay.setText( Result );
  			}
			catch (IOException e)
			{
				Result = "IO Exception";
				CenterDisplay.setText( Result );
			}


      	}
      
      }
	
		
		public class StringTooLongException extends Exception
      {
         StringTooLongException( String message)
         {
            super (message);
         }
      }

		
      public String CheckString(String subject, int cap) throws StringTooLongException
      {
      //Establish and define variables
         int number = 0;
      
      //check length of string
      	number = subject.length();
		
      //balance number of characters versus the "cap"
         if( number > cap)
         	throw tosser;
				
			return subject;
         
      }
		
		public String QueryReport(String subject, String tablename, int pass)throws SQLException, IOException
      {
		
		//Open Connection
         Connection  con=DriverManager.getConnection
   		("jdbc:oracle:thin:@localhost:1521:xe","TestUser","password");
			
					if (subject.equals("") )
					{

					}
					else if (subject.equals("*") )
					{
						subject = "Select * FROM " + tablename + "view";				
						
						Statement stmt=con.createStatement();
						ResultSet table=stmt.executeQuery (subject);
					
						subject = "";
						if( tablename.equals("Team") )
						{
							subject = "Team Name" + "\t\tTeam Race" + "\tTeam Color 1" + "\tTeam Color 2\n";
						
						while (table.next ())
						{
								subject += table.getString(1) + "\t" + table.getString(2) + "\t" + table.getString(3) + "\t" + table.getString(4) + "\n";
							};
						}
						else if(tablename.equals("Manager") )
						{
							subject = "Manager Name" + "\t\tManager E-mail" + "\t\t\tManager Account\n";
						
							while (table.next ())
							{
								subject += table.getString(1) + "\t" + table.getString(2) + "\t" + table.getString(3) + "\n";
							};
						}
						else if(tablename.equals("Player") )
						{
							subject = "Player Name" + "\tRace" + "\tPosition" + "\tTeam" + "\t\tManager" + "\n";
						
							while (table.next ())
							{
								subject += table.getString(1) + "\t" + table.getString(2) + "\t" + table.getString(3) + "\t" + table.getString(4) + "\t" + table.getString(5) + "\n";
							};

						}
						else if(tablename.equals("Position") )
						{
							subject = "Race" + "\tPosition" + "\tCost" + "\tMovement" + "\tStrength" + "\tAgility" + "\tArmor Value" + "\n";
						
							while (table.next ())
							{
								subject += table.getString(1) + "\t" + table.getString(2) + "\t" + table.getString(3) + "\t" + table.getString(4) + "\t" + table.getString(5) + "\t" + table.getString(6) + "\t" + table.getString(7) + "\n";
							};
						}
					
						stmt.close(); 

					}
					else
					{
						if(tablename.equals("Player") )
						{
							if( pass == 0 )
							{
								subject = "Select * FROM " + tablename + "view WHERE " + "TeamName = '" + subject + "'";
							}
							else if( pass == 1 )
							{
								subject = "Select * FROM " + tablename + "view WHERE " + "ManagerName = '" + subject + "'";
							}
							else if( pass == 2 )
							{
								subject = "Select * FROM " + tablename + "view WHERE " + "PlayerName = '" + subject + "'";
							}
							else  if( pass == 3 )
							{
								subject = "Select * FROM " + tablename + "view WHERE " + "PositionName = '" + subject + "'";
							}
						}
						else if(tablename.equals("Position") )
						{
							if( pass == 0 )
							{
								subject = "Select * FROM " + tablename + "view WHERE " + "Race = '" + subject + "'";
							}
							else if( pass == 1)
							{
								subject = "Select * FROM " + tablename + "view WHERE " + "PositionName = '" + subject + "'";
							};
						}
						else
						{
							subject = "Select * FROM " + tablename + "view WHERE " + tablename + "name = '" + subject + "'";
						};
						
					Statement stmt=con.createStatement();
					ResultSet table=stmt.executeQuery (subject);
					
					subject = "";
					if( tablename.equals("Team") )
					{
						subject = "Team Name" + "\t\tTeam Race" + "\tTeam Color 1" + "\tTeam Color 2\n";
						
						while (table.next ())
						{
							subject += table.getString(1) + "\t" + table.getString(2) + "\t" + table.getString(3) + "\t" + table.getString(4) + "\n";
						};
					}
					else if(tablename.equals("Manager") )
					{
						subject = "Manager Name" + "\t\tManager E-mail" + "\t\t\tManager Account\n";
						
						while (table.next ())
						{
							subject += table.getString(1) + "\t" + table.getString(2) + "\t" + table.getString(3) + "\n";
						};
					}
					else if(tablename.equals("Player") )
					{
						subject = "Player Name" + "\tRace" + "\tPosition" + "\tTeam" + "\t\tManager" + "\n";
						
						while (table.next ())
						{
							subject += table.getString(1) + "\t" + table.getString(2) + "\t" + table.getString(3) + "\t" + table.getString(4) + "\t" + table.getString(5) + "\n";
						};

					}
					else if(tablename.equals("Position") )
					{
						subject = "Race" + "\tPosition" + "\tCost" + "\tMovement" + "\tStrength" + "\tAgility" + "\tArmor Value" + "\n";
						
						while (table.next ())
						{
							subject += table.getString(1) + "\t" + table.getString(2) + "\t" + table.getString(3) + "\t" + table.getString(4) + "\t" + table.getString(5) + "\t" + table.getString(6) + "\t" + table.getString(7) + "\n";
						};
					}
					
					stmt.close(); 

					}
					
						
		//Close Connection
  			 con.close();
      
		
     		return subject;
         
      }

		public void Editation(String subject, String First, String Second, String Third, String tablename)throws SQLException, IOException
      {

			
			int One = 0;
			int Two = 0;
			int Three = 0;
			String query = "";
			
		//Open Connection
         Connection  con=DriverManager.getConnection
   		("jdbc:oracle:thin:@localhost:1521:xe","TestUser","password");
			
					//subject format for update
					/*"Update customers set discnt = discnt + 1";
					*/
				if(subject.equals("") )
				{
				}
				else
				{
					if (tablename.equals("Team") )
					{
						
						
						Statement stmt=con.createStatement();
						if( Second.equals("") )
						{
						}
						else
						{
							Second = "Update " + tablename + " set TeamColor1 = '" + Second + "' where " + tablename + "name = '" + subject + "'";
							stmt.executeUpdate (Second);
						};
						if( Third.equals("") )
						{
						}
						else
						{
							Third = "Update " + tablename + " set TeamColor2 = '" + Third + "' where " + tablename + "name = '" + subject + "'";
							stmt.executeUpdate (Third);
						};
						if( First.equals("") )
						{
						}
						else
						{
							First = "Update " + tablename + " set TeamName = '" + First + "' where " + tablename + "name = '" + subject + "'";
							stmt.executeUpdate (First);
						};
						stmt.close();
					}
					else if (tablename.equals("Manager") )
					{
						First = "Update " + tablename + " set ManagerEmail = '" + First + "' where " + tablename + "name = '" + subject + "'";
						Statement stmt=con.createStatement();
						stmt.executeUpdate (First);
						stmt.close();
					}
					else if (tablename.equals("Player") )
					{
					
					//Check limit of positions available
							
					//Find Limit of position specified
					query = "Select Limit FROM position where PositionId = (select PositionId from Player where PlayerName = '" + subject + "')";
					
					Statement stmt=con.createStatement();		
					ResultSet table=stmt.executeQuery (query);
						
					while (table.next ())
					{
						One = Integer.parseInt( table.getString(1) );
					};
							
					
												
					//Generate Count of positions already existing on team
					query = "Select Count(PositionName) FROM player, position, team where PlayerName = '" + subject + "' and TeamName = '" + Second + "' and player.positionid = position.positionid and player.teamid = team.teamid";
							
					table=stmt.executeQuery (query);
						
					while (table.next ())
					{
						Two = Integer.parseInt( table.getString(1) );
					};
							
										
					//if limit is less than or equal to existing number, then stop
					if( One <= Two )
					{
					}
					else
					{
						//Is Big Guy Check neccessary?
								
						//query if added member is a big guy
						query = "Select BigGuy FROM position, player where PlayerName = '" + subject + "' and player.positionid = position.positionid";
								
						table=stmt.executeQuery (query);
						
						while (table.next ())
						{
							Three = Integer.parseInt( table.getString(1) );
						};

														
						//Check limit of Big Guys available
							
												
						//Find Limit of Big Guys for specified team: 8, 2, or 1
								query = "Select BigGuyLimit FROM race where Race = (select race from team where TeamName = '" + Second + "')";
								
								table=stmt.executeQuery (query);
						
								while (table.next ())
								{
									One = Integer.parseInt( table.getString(1) );
								};
	
						
														
														
															
						//Generate Count of Big Guys already existing on team
						query = "Select Count(BigGuy) FROM player, position, team where BigGuy = 1 and TeamName = '" + Second + "' and player.positionid = position.positionid and player.teamid = team.teamid";
								
						table=stmt.executeQuery (query);
						
						while (table.next ())
						{
							Two = Integer.parseInt( table.getString(1) );
						};
							
						

												
								
						//if limit is less than or equal to existing number, then stop
						if( One <= Two && Three == 1)
						{
						}
						else
						{
													
						
							if(Third.equals(""))
							{
							}
							else
							{
								//Needs to retrieve the managerid on the manager table
						
								query = "Select ManagerId FROM Manager where ManagerName = '" + Third + "'";
							
								stmt=con.createStatement();
								table=stmt.executeQuery (query);
						
								while (table.next ())
								{
									Two = Integer.parseInt(table.getString(1));
								};

								Third = "Update " + tablename + " set ManagerId = '" + Two + "' where " + tablename + "name = '" + subject + "'";
							
								query = "Select * FROM " + tablename;
								table=stmt.executeQuery (query);
						
								stmt.executeUpdate (Third);

							};

							if(Second.equals(""))
							{
							}
							else
							{
							
								
								
								//Needs to retrieve the teamid on the team table
						
								query = "Select TeamId FROM Team where TeamName = '" + Second + "'";
						
								table=stmt.executeQuery (query);
								
								
								while (table.next ())
								{
									One = Integer.parseInt( table.getString(1) );
								};
						
															
								Third = "Update Player set TeamId = " + One + " where PlayerName = '" + subject + "'";
								
														
								query = "Select * FROM Player";
								
																
								table=stmt.executeQuery (query);
						
													
								stmt.executeUpdate (Third);
								
							
								//Retrieve Race of team to which player is being transferred
								query = "Select PositionId FROM Position where PositionName = (select PositionName from Position, Player where Position.PositionId = Player.PositionId and PlayerName = '" + subject + "') and race = (Select Race From Team where TeamName = '" + Second + "')";
						
								table=stmt.executeQuery (query);
								
																
								while (table.next ())
								{
									One = Integer.parseInt( table.getString(1) );
								};
								
								
								
								query = "Select * FROM " + tablename;
								table=stmt.executeQuery (query);
														
								//Update positionid of player being transferred
								Third = "Update Player set PositionId = " + One + " where PlayerName = '" + subject + "'";
							
								stmt.executeUpdate (Third);
								
							
							};
						
													
							if(First.equals(""))
							{
							}
							else
							{
								First = "Update " + tablename + " set PlayerName = '" + First + "' where " + tablename + "name = '" + subject + "'";
							
								query = "Select * FROM " + tablename;
								stmt=con.createStatement();
								table=stmt.executeQuery (query);
						
								stmt.executeUpdate (First);
						
							};

						};
					};
				};


			};
			

			//Close Connection
  			 	con.close();
   		         
      }

		public void Deletion(String subject, String tablename)throws SQLException, IOException
      {
			
		//Open Connection
         Connection  con=DriverManager.getConnection
   		("jdbc:oracle:thin:@localhost:1521:xe","TestUser","password");
			
				if(subject.equals("") )
				{
				}
				else
				{
					if (tablename.equals("Team") )
					{
						subject = "Delete from " + tablename + " where " + tablename + "name = '" + subject + "'";
						Statement stmt=con.createStatement();
						stmt.executeUpdate (subject);
						stmt.close();
					}
					else if (tablename.equals("Manager") )
					{
						subject = "Delete from " + tablename + " where " + tablename + "name = '" + subject + "'";
						Statement stmt=con.createStatement();
						stmt.executeUpdate (subject);
						stmt.close();
					}
					else if (tablename.equals("Player") )
					{
						subject = "Delete from " + tablename + " where " + tablename + "name = '" + subject + "'";
						Statement stmt=con.createStatement();
						stmt.executeUpdate (subject);
						stmt.close();
					}

					
				};
			
			
		//Close Connection
  			 con.close();
   		         
      }


		public void Creation(String subject, String First, String Second, String Third, String tablename)throws SQLException, IOException
      {
			
			int One = 0;
			int Two = 0;
			int Three = 0;
			String query = "";
			boolean Cherry = false;
			
		//Open Connection
         Connection  con=DriverManager.getConnection
   		("jdbc:oracle:thin:@localhost:1521:xe","TestUser","password");
				
				//insert format
				//"Insert into customers (cid, cname, city, discnt) values " + "('C011','IBM','Atlanta',30)"

				if(subject.equals("") || First.equals("") )
				{
				}
				else
				{
					if (tablename.equals("Team") )
					{
						if(Second.equals("") || Third.equals(""))
						{
						}
						else
						{
							query = "Select " + tablename + "Id FROM " + tablename;
							Statement stmt=con.createStatement();
							ResultSet table=stmt.executeQuery (query);
				
							while(table.next())
							{
						
								if(Cherry == true)
								{
									One = Two;
								};
							
								if(Three == 0)
								{
									Two = Integer.parseInt(table.getString(1));
								
									if(Cherry == true)
									{
										if( Two != (One + 1) )
										{
											Three = (One + 1);
										};
									};
								};
								Cherry = true;
							}
							if(Three == 0)
							{
								Three = Two + 1;
							};
						
						
							query = "Select * FROM " + tablename;
							table=stmt.executeQuery (query);
						
							subject = "Insert into " + tablename + " (TeamId, TeamName, Race, TeamColor1, TeamColor2) values (" + Three + ", '" + subject + "', '" + First + "', '" + Second + "', '" + Third + "')";
							stmt.executeUpdate (subject);
							stmt.close();
						}
					}
					else if (tablename.equals("Manager") )
					{
						query = "Select " + tablename + "Id FROM " + tablename;
						Statement stmt=con.createStatement();
						ResultSet table=stmt.executeQuery (query);
						
												
						
						while(table.next())
						{
						
							if(Cherry == true)
							{
								One = Two;
							};
							
							if(Three == 0)
							{
								Two = Integer.parseInt(table.getString(1));
								
								if(Cherry == true)
								{
									if( Two != (One + 1) )
									{
										Three = (One + 1);
									};
								};
							};
							Cherry = true;
						}
						if(Three == 0)
						{
							Three = Two + 1;
						};
						
						
						query = "Select * FROM " + tablename;
						table=stmt.executeQuery (query);

												
						subject = "Insert into " + tablename + " (ManagerId, ManagerName, ManagerEmail) values (" + Three + ", '" + subject + "', '" + First + "')";
						
																							
						stmt.executeUpdate (subject);
						stmt.close();
						
						}
					else if (tablename.equals("Player") )
					{
						if(Second.equals("") || Third.equals(""))
						{
						}
						else
						{
							
							Statement stmt=con.createStatement();
							
							
							
							//Check limit of positions available
							
							//Find Limit of position specified
							query = "Select Limit FROM position where PositionName = '" + First + "' and race = (select race from team where TeamName = '" + Second + "')";
							
							ResultSet table=stmt.executeQuery (query);
						
							while (table.next ())
							{
								One = Integer.parseInt( table.getString(1) );
								
							};
							
							//Generate Count of positions already existing on team
							query = "Select Count(PositionName) FROM player, position, team where PositionName = '" + First + "' and TeamName = '" + Second + "' and player.positionid = position.positionid and player.teamid = team.teamid";
							
							table=stmt.executeQuery (query);
						
							while (table.next ())
							{
								Two = Integer.parseInt( table.getString(1) );
								System.out.println(Two);
							};
							
							//if limit is less than or equal to existing number, then stop
							if( One <= Two )
							{
							}
							else
							{
								//Is Big Guy Check neccessary?
								
								//query if added member is a big guy
								query = "Select BigGuy FROM position where PositionName = '" + First + "'";
								
								table=stmt.executeQuery (query);
						
								while (table.next ())
								{
									Three = Integer.parseInt( table.getString(1) );
								};

								
								//Check limit of Big Guys available
							
								//Find Limit of Big Guys for specified team: 8, 2, or 1
								query = "Select BigGuyLimit FROM race where Race = (select race from team where TeamName = '" + Second + "')";
								
								table=stmt.executeQuery (query);
						
								while (table.next ())
								{
									One = Integer.parseInt( table.getString(1) );
								};
								
														
								//Generate Count of Big Guys already existing on team
								query = "Select Count(BigGuy) FROM player, position, team where BigGuy = 1 and TeamName = '" + Second + "' and player.positionid = position.positionid and player.teamid = team.teamid";
								
								table=stmt.executeQuery (query);
						
								while (table.next ())
								{
									Two = Integer.parseInt( table.getString(1) );
								};
							
								//if limit is less than or equal to existing number, then stop
								if( One <= Two && Three == 1)
								{
								}
								else
								{
									String CopyFirst = First;
									String CopyThird = Third;
									Three = 0;
							
									tablename = "Position";
									//Find Position Id of the player for the Team to which the player is being hired.
									query = "Select " + tablename + "Id FROM " + tablename + " where " + tablename + "Name = '" + First + "' and Race = (Select Race from Team where TeamName = '" + Second + "')";
						
									table=stmt.executeQuery (query);
						
									while (table.next ())
									{
										First = table.getString(1);
									};
									
											
									tablename = "Team";						
									//Find Team Id of the player for the Team to which the player is being hired.
									query = "Select " + tablename + "Id FROM " + tablename + " where " + tablename + "Name = '" + Second + "'";
						
									table=stmt.executeQuery (query);
						
									while (table.next ())
									{
										Second = table.getString(1);
									};
									
									tablename = "Manager";
									//Find Manager Id of the player for the Manager which is hiring the player.
									query = "Select " + tablename + "Id FROM " + tablename + " where " + tablename + "Name = '" + Third + "'";
						
									table=stmt.executeQuery (query);
						
									while (table.next ())
									{
										Third = table.getString(1);
									};
									
									tablename = "Player";
									//Assign next available PlayerId
									query = "Select " + tablename + "Id FROM " + tablename;
						
									table=stmt.executeQuery (query);
				
									while(table.next())
									{
						
										if(Cherry == true)
										{
											One = Two;
										};
							
										if(Three == 0)
										{
											Two = Integer.parseInt(table.getString(1));
								
											if(Cherry == true)
											{
												if( Two != (One + 1) )
												{
													Three = (One + 1);
												};
											};
										};
										Cherry = true;
									};
									
									if(Three == 0)
									{
										Three = Two + 1;
									};
						
									query = "Select * FROM " + tablename;
									table=stmt.executeQuery (query);
									
									//Add player to table
									subject = "Insert into " + tablename + " (PlayerId, PlayerName, PositionId, TeamId, ManagerId) values (" + Three + ", '" + subject + "', " + Integer.parseInt(First) + ", " + Integer.parseInt(Second) + ", " + Integer.parseInt(Third) + ")";
									stmt.executeUpdate (subject);
							
									//Deduct Cost of Position of Player from respective Manager's Account
									tablename = "Position";
									//Find Cost of Player's Position
									query = "Select Cost FROM " + tablename + " where " + tablename + "Name = '" + CopyFirst + "'";
									stmt=con.createStatement();
									table=stmt.executeQuery (query);
							
									//Retrieve Player's Cost
									while (table.next ())
									{
										One = Integer.parseInt(table.getString(1));
									};

									tablename = "Manager";							
									query = "Select * FROM " + tablename;
									table=stmt.executeQuery (query);
							
									//Find Account of respective Manager
									query = "Select ManagerAccount FROM " + tablename + " where " + tablename + "Name = '" + CopyThird + "'";
									stmt=con.createStatement();
									table=stmt.executeQuery (query);
							
													
									//Retrieve respective Manager's Account
									while (table.next ())
									{
										Two = Integer.parseInt(table.getString(1));
									};

									query = "Select * FROM " + tablename;
									table=stmt.executeQuery (query);
							
									//Update respective Manager's Account by subtracting retrieved cost of position from retrieved Account of respective Manager
									query = "Update " + tablename + " set ManagerAccount = " + (Two - One) + " where " + tablename + "name = '" + CopyThird + "'";
							
									stmt.executeUpdate (query);

									stmt.close();
								}
							}	
							
												
						}
					}
					
					
				};
			

		//Close Connection
  			 con.close();
   		         
      }


}