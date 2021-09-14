package fr.qqqq.fourier.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import fr.qqqq.fourier.Camera;

public class Line implements Shape {
	public double x1, y1, x2, y2;
	public boolean visible = true;
	public Color color = Color.BLUE;
	
	public Line(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void render(Graphics2D g2d, Camera cam) {
		if(visible) {
			Line2D.Double shape = new Line2D.Double(cam.calcX(x1), cam.calcY(y1), cam.calcX(x2), cam.calcY(y2));
			g2d.setColor(color);
			g2d.draw(shape);
		}
	}

}
