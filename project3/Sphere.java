package com.Fabian;

public class Sphere extends Circle {
	
	public double radius; 
	
	public Sphere(double r) {
		
		super(r);
		radius = r;
		
		
	}
	
	
	public double getArea(double areaSize) {
		
		double circleArea;
		
		circleArea = Math.PI  * Math.pow(radius, 2) * 4;
		
		return circleArea;
		
	}
	

}
