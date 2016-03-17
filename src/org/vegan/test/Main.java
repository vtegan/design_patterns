/**
 * 
 */
package org.vegan.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author egan
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to fundamental Design Patterns.");
		
		List<String> lstValues = new ArrayList<>();
		
		lstValues.add("Larry");
		lstValues.add("Curley");
		lstValues.add("Moe");
		
		System.out.println("Number of Stooges:  " + lstValues.size());

	}

}
