//Kemerait, Christopher
//CSIS 2302
//Assignment 10
//Tunes Auto-Sort

//********************************************************************
//  CD.java       Author: Lewis/Loftus
//
//  Represents a compact disc.
//********************************************************************

package assignment10;

import java.text.NumberFormat;

public class CD implements Comparable
{
   private String title, artist;
   private double cost;
   private int tracks;

   //-----------------------------------------------------------------
   //  Creates a new CD with the specified information.
   //-----------------------------------------------------------------
   public CD (String name, String singer, double price, int numTracks)
   {
      title = name;
      artist = singer;
      cost = price;
      tracks = numTracks;
   }
	
	private String getTitle()
	{
		return title;
	}
	
	private String getArtist()
	{
		return artist;
	}
	
   //-----------------------------------------------------------------
   //  Returns a string description of this CD.
   //-----------------------------------------------------------------
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String description;

      description = fmt.format(cost) + "\t" + tracks + "\t";
      description += title + "\t" + artist;

      return description;
   }
	
	
	public int compareTo (Object Bob)
	{
		int result;
		
		String Bobtitle = ((CD)Bob).getTitle();
		String Bobartist = ((CD)Bob).getArtist();
		
		if ( title.equals(Bobtitle) )
			result = this.artist.compareTo(Bobartist);
		else
			result = this.title.compareTo(Bobtitle);
			
		return result;
		
		
	}
}
