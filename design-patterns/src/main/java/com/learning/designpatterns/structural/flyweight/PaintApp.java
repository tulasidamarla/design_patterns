package com.learning.designpatterns.structural.flyweight;

public class PaintApp {

	public void paint(int numberOfShapes) {

		Shape shape = null;

		for (int i = 1; i <= numberOfShapes; i++) {
			if (i % 2 == 0) {
				shape = ShapeFactory.getShape("circle");
				shape.draw(i, "red", "white");
			} else {
				shape = ShapeFactory.getShape("rectangle");
				shape.draw(i, i + i, "dotted");
			}
		}

	}

}
