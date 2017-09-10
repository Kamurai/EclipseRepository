//Kemerait, Christopher
//CSIS 2302
//CD Collection (Arraylist) Assignment

package assignment8;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.String;


//********************************************************************
//  CDCollection.java       Author: Lewis/Loftus
//
//  Represents a collection of compact discs.
//********************************************************************

import java.text.NumberFormat;

public class CDCollection
{
   private ArrayList<CD> collection = new ArrayList<CD>();
   private double totalCost;

   //-----------------------------------------------------------------
   //  Constructor: Creates an initially empty collection.
   //-----------------------------------------------------------------
   public CDCollection ()
   {
      totalCost = 0.0;
   }

   //-----------------------------------------------------------------
   //  Adds a CD to the collection, increasing the size of the
   //  collection if necessary.
   //-----------------------------------------------------------------
   public void addCD (String title, String artist, double cost,
                      int tracks)
   {
      
      collection.add( new CD (title, artist, cost, tracks) );
      totalCost += cost;
      
   }

   //-----------------------------------------------------------------
   //  Returns a report describing the CD collection.
   //-----------------------------------------------------------------
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
      report += "My CD Collection\n\n";

      report += "Number of CDs: " + collection.size() + "\n";
      report += "Total cost: " + fmt.format(totalCost) + "\n";
      report += "Average cost: " + fmt.format(totalCost/collection.size());

      report += "\n\nCD List:\n\n";

      for (int cd = 0; cd < collection.size(); cd++)
         report += collection.get(cd) + "\n";

      return report;
   }

}

/********************************************
50/50 Please see my comments in your code.
********************************************/