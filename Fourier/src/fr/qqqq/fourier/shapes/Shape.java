package fr.qqqq.fourier.shapes;

import java.awt.Graphics2D;

import fr.qqqq.fourier.Camera;

public interface Shape {
	public void render(Graphics2D g2D, Camera cam);
}
