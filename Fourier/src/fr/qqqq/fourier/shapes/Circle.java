package fr.qqqq.fourier.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import fr.qqqq.fourier.Camera;

public class Circle implements Shape {
	public double x, y, radius;
	public Color color = Color.RED;
	
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	
	@Override
	public void render(Graphics2D g2d, Camera cam) {
		double rx = cam.scaleX(radius);
		double ry = cam.scaleY(radius);
		
		Ellipse2D.Double e = new Ellipse2D.Double(cam.calcX(x) - rx, cam.calcY(y) - ry, rx * 2, ry * 2);
		g2d.setColor(color);
		g2d.draw(e);
	}

	
	
}
