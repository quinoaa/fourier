package fr.qqqq.fourier.epicircles;

import java.util.ArrayList;
import java.util.function.Consumer;

import fr.qqqq.fourier.Position;
import fr.qqqq.fourier.shapes.Circle;
import fr.qqqq.fourier.shapes.Line;
import fr.qqqq.fourier.shapes.Shape;

public class EpicircleController {
	public ArrayList<Epicircle> epicircles = new ArrayList<Epicircle>();
	
	ArrayList<Line> transform = new ArrayList<Line>();
	ArrayList<Circle> circles = new ArrayList<Circle>();
	
	public EpicircleController() {
		
	}
	
	public void init() {
		transform.clear();
		circles.clear();
		epicircles.forEach(e -> {
			transform.add(new Line(0, 0, 0, 0));
			circles.add(new Circle(0, 0, 0));
		});
	}
	public void foreach(Consumer<Shape> c) {
		for(int i = 0;i < epicircles.size();i ++) {
			c.accept(transform.get(i));
			c.accept(circles.get(i));
		}
	}
	
	
	
	public Position transform(double step) {
		Position pos = new Position(0, 0);
		for(int i = 0;i < epicircles.size();i ++) {
			Epicircle c = epicircles.get(i);
			Line line = transform.get(i);
			Circle circle = circles.get(i);

			line.x1 = pos.x;
			line.y1 = pos.y;
			circle.x = pos.x;
			circle.y = pos.y;
			circle.radius = c.radius;
			
			c.transform(pos, step);

			line.x2 = pos.x;
			line.y2 = pos.y;
		}
		return pos;
	}
}




