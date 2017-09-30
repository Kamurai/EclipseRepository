//********************************************************************
//  PhoneList2.java       Author: Lewis/Loftus
//
//  Driver for testing searching algorithms.
//********************************************************************

public class PhoneList2
{
   //-----------------------------------------------------------------
   //  Creates an array of Contact objects, sorts them, then prints
   //  them.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      Contact test, found;
      Contact[] friends = new Contact[8];

      friends[0] = new Contact ("John", "Smith", "\t610-555-7384");
      friends[1] = new Contact ("Sarah", "Barnes", "\t215-555-3827");
      friends[2] = new Contact ("Mark", "Riley", "\t733-555-2969");
      friends[3] = new Contact ("Frank", "Phelps", "\t663-555-3984");
      friends[4] = new Contact ("Larry", "Smith", "\t464-555-3489");
      friends[5] = new Contact ("Frank", "Phelps", "\t322-555-2284");
      friends[6] = new Contact ("Mario", "Guzman", "\t804-555-9066");
      friends[7] = new Contact ("Marsha", "Grant", "\t243-555-2837");

		//reverse sort array
		Sorting.selectionSort(friends);
		
      test = new Contact ("Frank", "Phelps", "");
		
		//altered linear search for one OR second of two objects
      found = (Contact) Searching.linearSearch(friends, test);
		//output array
		for(int x = 0; x < friends.length; x++)
			System.out.println (friends[x]);
		System.out.println ();
		System.out.println ();
      if (found != null)
         System.out.println ("Found: " + found);
      else
         System.out.println ("The contact was not found.");
      System.out.println ();
		//reverse sort
      Sorting.selectionSort(friends);
		//output array
		for(int x = 0; x < friends.length; x++)
			System.out.println (friends[x]);
		System.out.println ();
		System.out.println ();

      test = new Contact ("Mark", "Riley", "");
		
		//altered binary search for reverse sorting
      found = (Contact) Searching.binarySearch(friends, test);
      if (found != null)
         System.out.println ("Found: " + found);
      else
         System.out.println ("The contact was not found.");
   }
}
