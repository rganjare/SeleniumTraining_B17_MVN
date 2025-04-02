package com.companyname.projectname.modulename;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Collections { // 4 types of collections in Java
	
	public static void main(String[] args) {
		list();
		Set(); // HashSet
		hashTable();
		map();
	}
	
	private static void map() { // HashMap Or map
		// Map is a collection Key and Value pair 
		// null Key & value is allowed in Map
		// For duplicate key/record it will override the old value with latest one 
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("Name", "BYMAT");
		map.put("Address", "dgdgdg Pune");
		map.put("Training", "Selenium");
		map.put("State", "Maharshtra");
		map.put("State", "Maharshtra123");
		map.put("City", "Pune");
		map.put("City", null);
		map.put(null, "fdfs");
		map.put("PinCode", "411047");
		
		System.out.println(map);
		
		System.out.println(map.get("Name"));
		System.out.println(map.get("Address"));
		System.out.println(map.get("State"));
		
	}

	private static void hashTable() {
		// HashTable is a collection Key and Value pair 
		// null Key & value is not allowed in HashTable
		// For duplicate key/record it will override the old value with latest one
		
		Hashtable<String, String> ht = new Hashtable<>();
		
		ht.put("Name", "BYMAT");
		ht.put("Address", "dgdgdg Pune");
		ht.put("Training", "Selenium");
		ht.put("State", "Maharshtra");
		ht.put("State", "Maharshtra123");
		ht.put("City", "Pune");
		//ht.put("City", null);
		// ht.put(null, "fdfs");
		ht.put("PinCode", "411047");
		
		System.out.println(ht);
		
		System.out.println(ht.get("Name"));
		System.out.println(ht.get("Address"));
		System.out.println(ht.get("State"));
	
}

	private static void Set() {
		// Set is a collection of unique records
		// will allow null as well
		// will allow no value or blank values
		
		HashSet<String> set = new HashSet<>();
		
		set.add("Ketul");
		set.add("Mitika");
		set.add("Rahul");
		set.add("Rajashri");
		set.add("Sneha");
		set.add("Harshal");
		set.add("Sagar");
		set.add("Sagar");
		set.add("Rajashri");
		set.add("");
		set.add(null);
		set.add("46345sdgsdgs35335353");
		
		System.out.println(set);
		
		for(String std : set) {
			System.out.println(std);
		}
		System.out.println(" #### Set OutPut with Iterator ###");
		
		Iterator itr = set.iterator();
		while(itr.hasNext()) {		
			System.out.println(itr.next());
		}
		
	}

	public static void list() {
		// List is a collection of records
		// List will allow duplicate entries/records
		// will allow null as well
		// will allow no value or blank values
		List<String> students = new ArrayList<>(); // FIFO
		students.add("Ketul");
		students.add("Mitika");
		students.add("Rahul");
		students.add("Rajashri");
		students.add("Sneha");
		students.add("Harshal");
		students.add("Sagar");
		students.add("Sagar");
		students.add("Rajashri");
		students.add("");
		students.add(null);
		students.add("46345sdgsdgs35335353");
		
		System.out.println(students);
		
		for(int i=0; i<students.size(); i++) {
			System.out.println("Student at index " + i + " is " + students.get(i));
		 }
		
		// Print records in a reverse order
		for(int i=students.size()-1; i>=0; i--) {
			System.out.println("Student at index " + i + " is " + students.get(i));
		}
		System.out.println("#### Out put of Enhanced For loop ####");
		// Enhanced For loop // Advanced
		// Data Type user defined variable : collection name
		for(String std : students) {
			System.out.println(std);
		}
		
		System.out.println(" #### List OutPut with Iterator ###");
		Iterator itr = students.iterator();
		while(itr.hasNext()) {		
			System.out.println(itr.next());
		}
		
	}

}
