package org.manav.javbrains.model;

import org.manav.javabrains.aspect.Loggable;

public class Circle {

	private String name;

	@Loggable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Setting the Circle name");
		//throw (new RuntimeException());
	} 
	
	public String setNameReturnString(String name) {
		this.name = name;
		System.out.println("Setting the Circle name");
		//throw (new RuntimeException());
		return name;
	} 
	
}
