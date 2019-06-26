package com.Fabian;
public class Circle implements Measureable {
	
	public double radius;
	public double pi = Math.PI; 
	
	public Circle(double r) {
		
		
		radius = r;
	}
	
	
	
	
	public double getArea(double areaSize) {
		
		double circleArea;
		
		circleArea = Math.PI  * Math.pow(radius, 2);
		
		return circleArea;
		
	}
	

}
