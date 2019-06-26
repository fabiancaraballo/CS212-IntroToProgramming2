package com.Fabian;
public class Box extends Rectangle {
	
	public double length;
	public double height;
	public double width;
	
	public Box(double l, double w, double h) {
		
		super(h, w);
		length = l;
		width = w;
		height = h;
		
	}
	
	public double getArea(double areaSize) {
		
		double boxArea;
		
		boxArea = 2*(height * length) + 2*(width * length) + 2*(height * width);
		
		return boxArea;
	}

}

