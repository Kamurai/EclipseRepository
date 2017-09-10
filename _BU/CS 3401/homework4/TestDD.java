package homework4;

import tester.*;

public class TestDD {
	public static void main(String[] args) {
		Tester.run(new Test());
	}

	public void testSimpleStructures(Tester t) {

		try {
			// Constructor and getter tests
			java.util.Set<Object> set1 = new java.util.HashSet<Object>();
			java.util.Set<Object> set2 = new java.util.HashSet<Object>();
			set1.add("Daehlon");
			set1.add("LuAnn");
			set1.add("Dakotah");
			set1.add("Clayton");
			set1.add("Cheyanne");
			set2.add("Ethan");
			set2.add("Kaelin");
			set2.add("Daehlon");
			set2.add("LuAnn");
			set2.add("Bill");
			java.util.List<Object> list1 = new java.util.ArrayList<Object>();
			list1.add("Michigan");
			list1.add("Georgia");
			list1.add("Texas");
			list1.add("Hawaii");
			list1.add("Japan");

			SimpleStructuresDD<Object> unionSet = new SimpleStructuresDD<Object>();
			unionSet.union(set1, set2);
			System.out.println("The new union set is: " + unionSet);

			// System.out.println(SimpleStructures<Object> union.(set1, set2));
			// The commented code is code I tried and didn't work and still
			// wanted to keep just in case
			// it was still useful.

			SimpleStructuresDD<Object> intSet = new SimpleStructuresDD<Object>();
			intSet.intersection(set1, set2);
			System.out.println("The new intersecting set is: " + intSet);

			// System.out.println(SimpleStructures<Object> intersection.(set1,
			// set2));

			SimpleStructuresDD<Object> revList = new SimpleStructuresDD<Object>();
			revList.reverse(list1);
			System.out.println("The new reversed list is: " + revList);

			// System.out.println(SimpleStructures<Object> reverse.list1);

		} catch (Exception e) {
			e.printStackTrace();
			t.fail();
		}
	}
}
