package Dirty;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PowerSet {
    public static void main(String[] args) {
            int items[] = {1,2,3,4,5,6,7};
            Set<Set<Integer>> treeSet = new TreeSet<Set<Integer>>(new PowersetObjectComparator());
            int len = items.length;
            int elements = (int) Math.pow(2, len);
            for (int i = 1; i < elements; i++) {
                    String str = Integer.toBinaryString(i);
                    int value = str.length();
                    String pset = str;
                    for (int k = value; k < len; k++) {
                            pset = "0" + pset;
                    }
                     Set<Integer> set = new HashSet<Integer>();
                    for (int j = 0; j < pset.length(); j++) {
                            if (pset.charAt(j) == '1')
                                    set.add(items[j]);
                    }
                    treeSet.add(set);
            }
            
            System.out.println(treeSet.toString().replace("[", "{").replace("]","}"));
    }
}
