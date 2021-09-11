package fr.qqqq.fourier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Renderer extends JComponent {
	private static final long serialVersionUID = 1L;
	
	public CameraMovementListener listener;
	public Camera cam;
	
	
	public Renderer() {
		super();
		
		cam = new Camera();
		listener = new CameraMovementListener(cam);
		
		addMouseListener(listener);
		addMouseMotionListener(listener);
		addMouseWheelListener(listener);
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		/*
		g2D.setColor(Color.WHITE);
		g2D.fillRect(0, 0, getWidth(), getHeight());
*/
		g2D.setColor(Color.BLACK);
		g2D.drawString("cam: " + cam.x + ", " + cam.y, 0, 12);
		g2D.drawString("zoom: " + cam.zoom, 0, 24);

		g2D.translate(getWidth() / 2, getHeight() / 2);
		
		
		
		g2D.setColor(Color.BLUE);
		g2D.fillOval((int)cam.calcX(-9), (int)cam.calcY(-9), (int)cam.calcX(10), (int)cam.calcY(10));
		System.out.println();
	}
	
}






