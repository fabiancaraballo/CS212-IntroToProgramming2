package com.Fabian;
import com.Fabian.Box;
import com.Fabian.Measureable;
import com.Fabian.Rectangle;
import com.Fabian.Sphere;
import com.Fabian.Box;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;


public class Main {
	
	public static void main(String args[]) {
		
		ArrayList <Measureable> arrList = new ArrayList <Measureable>(1000);
		int circles = 0;
		int spheres = 0;
		int rectangles = 0;
		int boxes = 0;
		
		
		for (int i = 0; i < 1000; i++) {
			
			double random = Math.random();
			
			if (random <= .25) {
				
				Rectangle rect = new Rectangle(nextDouble(), nextDouble());
				arrList.add(i, rect);
				rectangles += 1;
			}
			else if (random > .25 && random <= .5) {
				
				Box box = new Box(nextDouble(), nextDouble(), nextDouble());
				arrList.add(i, box);
				boxes += 1;
			}
			else if (random > .5 && random <= .75) {
				
				Circle cir = new Circle(nextDouble());
				arrList.add(i, cir);
				circles += 1;
				
			}
			else {
				
				Sphere sphere = new Sphere(nextDouble());
				arrList.add(i, sphere);
				spheres += 1;
			}
		}
		
		System.out.println("Rectangles: " + rectangles + " Boxes: " + boxes + " Circle: " + circles + " Spheres: " + spheres);
		System.out.println(calculateSum(arrList));
		
		
		
		
	}
	
	private static double nextDouble() {
		return (Math.random() * (1-Double.MIN_VALUE)) + 1;
		
	}
	
	private static double calculateSum(ArrayList <Measureable> aList) {
		double sum = 0;
		for (int i = 0; i < aList.size(); i++ ) {
			sum += aList.get(i).getArea(sum);
			
		}
		return sum;
		
		
	}

	
}
