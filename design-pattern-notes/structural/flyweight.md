# Flyweight design pattern
- The Flyweight design pattern is a technique for reducing memory usage by sharing common features between similar objects.
- It's particularly useful when you're dealing with a large number of objects that have some redundant data.
- `Concept:`
  - `Flyweight objects:` These are lightweight objects that contain the intrinsic state `(unchanging data)` of an object. This data is 
    shared across multiple instances.
  - `Extrinsic state:` This data is specific to each object and is not stored within the Flyweight object itself. It's typically passed in 
    as arguments to the Flyweight object's methods.
  - `Flyweight Factory:` This is a component responsible for creating and managing Flyweight objects. It keeps a pool of existing Flyweight 
    objects and hands them out when requested, ensuring reuse.
- To understand flyweight let's understand the problem with the below code.
```java
interface Shape{
    void draw();
}

class Circle implements Shape(){
    private String label;
    private int radius;
    private String fillColor;
    private String lineColor;

    Circle(){
        this.label = "Circle";
    }

    public void draw(){
        System.out.println("Drawing a " + label + " with color: " + fillColor + " line color: " + lineColor + " and radius: " + radius);
    }
    //setters and getters are omitted for brevity
}

class Rectangle implements Shape(){
    private String label;
    private int length;
    private int width;
    private String fillColor;
    private String lineColor;

    Rectanlge(){
        this.label = "Rectangle";
    }

    public void draw(){
        System.out.println("Drawing a " + label + " with color: " + fillColor + " line color: " + lineColor + " length: " + length + " and width:" + width);
    }
    //setters and getters are omitted for brevity
}

class PaintApp{
    public void paint(int noOfShapes){
        Shape[] shapes = new Shape[noOfShapes+1]
        for (int i = 1; i <= noOfShapes; i++>){
            if(i % 2 == 0){
                shapes[i] = new Circle();
                ((Circle)shapes[i]).setRadius(i);
                ((Circle)shapes[i]).setFillColor("red");
                ((Circle)shapes[i]).setlineColor("blue");
            } else {
                shapes[i] = new Rectangle();
                ((Rectangle)shapes[i]).setLength(i);
                ((Rectangle)shapes[i]).setWidth(i*2);
                ((Rectangle)shapes[i]).setFillColor("white");
                ((Rectangle)shapes[i]).setlineColor("blue");
            }
            shapes[i].draw();
        }
    }
}

//Test code
PaintApp app = new PaintApp();
app.paint(10); // This creates 5 Circle and 5 Rectangle objects.
```
- The above code has created unnecessary objects because all of the state for both Circle and State is intrinsic.

## Fixing the problem.
- Fixing the problem requires the following steps.
  - Seperate the intrinsic and extrinsic states.
    - Intrinsic state is part of the construction of the objects.
    - Extrinsic state is taken as arguments to the method(draw method).
  - Create the factory class that caches objects with the same intrinsic state.
- Here is the code.
```java
public abstract class Shape {
	public void draw(int radius,String fillColor,String lineColor) {
		//no - op
	}
	
	public void draw(int length,int breadth,String fillStyle) {
		//no - op
	}
}

public class Circle extends Shape {

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Circle() {
		label = "Cicle";
	}

	@Override
	public void draw(int radius, String fillColor, String lineColor) {
		System.out.println("Drawing a " + label + "  with radius " + radius + " Fill color " + fillColor
				+ " Line Color " + lineColor);
	}

}

public class Rectangle extends Shape {
	private String label;

	public Rectangle() {
		label = "Rectangle";
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void draw(int length, int breadth, String fillStyle) {
		System.out.println(
				"Drawing a " + label + "  with lenght " + length + " Breadth " + breadth + " Fill Style " + fillStyle);
	}

}

public class ShapeFactory {
    // caches Shape objects to save memory
	private static Map<String, Shape> shapes = new HashMap<>();

	public static Shape getShape(String type) {
		Shape shape = null;
		if (shapes.get(type) != null) {
			shape = shapes.get(type);
		} else {
			if (type.equals("circle")) {
				shape = new Circle();
			} else if (type.equals("rectangle")) {
				shape = new Rectangle();
			}
			shapes.put(type, shape);
		}
		return shape;

	}

}

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

//Test code
PaintApp app = new PaintApp();
app.paint(10);
```
- `Note:` It's not necessary to change the interface(Shape) to an abstract class after separating the intrinsic and extrinsic state in the 
  Flyweight pattern.

- Other use cases of flyweight design pattern in java and spring.
  - String Pool
  - Integer Cache(-128 to +127)
  - Spring Framework - Bean Caching
    - Spring manages a single instance of a bean and shares it among multiple clients.
