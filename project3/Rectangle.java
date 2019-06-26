package com.Fabian;
public class Rectangle implements Measureable {
	
	

	public double height;
	public double width;
	
	public Rectangle(double w, double h) {
		
		width = w;
		height = h;
	}
	
	public double getArea(double areaSize) {
		
		double recArea;
		
		recArea = width * height;
		
		return recArea;
	}
		


}

