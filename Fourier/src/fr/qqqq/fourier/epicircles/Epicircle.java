package fr.qqqq.fourier.epicircles;

import fr.qqqq.fourier.Position;

public class Epicircle {
	public double radius, start;
	public int speed;
	
	public Epicircle(double radius, double start, int speed) {
		this.radius = radius;
		this.start = start;
		this.speed = speed;
		
		
	}
	
	public void transform(Position pos, double step) {
		double rot = ((step * speed) + start) * Math.PI * 2;

		pos.x += Math.cos(rot) * radius;
		pos.y += Math.sin(rot) * radius;
	}
}
