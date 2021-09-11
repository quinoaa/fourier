package fr.qqqq.fourier;

import java.awt.Dimension;

import javax.swing.JFrame;

import fr.qqqq.fourier.shapes.Circle;
import fr.qqqq.fourier.shapes.Line;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		JFrame f = new JFrame("geom");
		
		Renderer r = new Renderer();

		r.shape.add(new Line(0, 0, 0, 60));
		r.shape.add(new Circle(-20, 0, 20));
		r.shape.add(new Circle(20, 0, 20));
		
		r.setPreferredSize(new Dimension(600, 400));
		f.add(r);
		
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
		FPSController con = new FPSController();
		con.run(r);
	}

}
