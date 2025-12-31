package com.example.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class OBJ implements Comparable<OBJ>{
    int no;
    String name;
    int price;

    public OBJ(int no, String name, int price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OBJ [no=" + no + ", name=" + name + ", price=" + price + "]";
    }
    public int compareTo(OBJ b1) {
		return this.name.compareTo(b1.name);
		
	}
}

// Comparator to sort by name
class NameComparator implements Comparator<OBJ> {
    @Override
    public int compare(OBJ b1, OBJ b2) {
        return b1.getName().compareTo(b2.getName());
    }
}

// Comparator to sort by price
class PriceComparator implements Comparator<OBJ> {
    @Override
    public int compare(OBJ b1, OBJ b2) {
        return Integer.compare(b1.getPrice(), b2.getPrice());
    }
}
class ClenghtComparator implements Comparator<OBJ>{
	public int compare(OBJ b1,OBJ b2) {
		return Integer.compare(b1.name.length(), b2.name.length());
	}
	
}


public class objinsideList {
    public static void main(String[] args) {
        Set<OBJ> list = new TreeSet<OBJ>();
OBJ o1Obj=new OBJ(1, "Python", 500);
OBJ o2Obj=new OBJ(1, "Python", 500);
        list.add(new OBJ(1, "Python", 500));
        list.add(new OBJ(2, "Java", 300));
        list.add(new OBJ(3, "C++", 400));

        System.out.println("Original List:");
        for (OBJ obj : list) {
            System.out.println(obj);
        }

        //  name
		/*
		 * Collections.sort(list, new NameComparator());
		 * System.out.println("\nSorted by Name:"); for (OBJ obj : list) {
		 * System.out.println(obj); }
		 * 
		 * // price Collections.sort(list, new PriceComparator());
		 * System.out.println("\nSorted by Price:"); for (OBJ obj : list) {
		 * System.out.println(obj); } System.out.println("\nSort by lenght   ");
		 * Collections.sort(list, new ClenghtComparator()); for (OBJ obj : list) {
		 * 
		 * System.out.println(obj);
		 * 
		 * } String s1="abc"; String s2="abc"; System.out.println(s1.equals(s2));
		 */
		     }
}
