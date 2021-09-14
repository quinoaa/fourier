package fr.qqqq.fourier;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import fr.qqqq.fourier.epicircles.Epicircle;
import fr.qqqq.fourier.epicircles.EpicircleController;
import fr.qqqq.fourier.epicircles.EpicircleRenderer;
import fr.qqqq.fourier.shapes.Circle;
import fr.qqqq.fourier.shapes.Line;
import fr.qqqq.fourier.shapes.Shape;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		JFrame f = new JFrame("geom");
		
		Renderer r = new Renderer();
		
		
		
		EpicircleController ctrl = new EpicircleController();
		ctrl.epicircles.add(new Epicircle(50, 0.2, 1));
		ctrl.epicircles.add(new Epicircle(750, 0, 2));
		ctrl.epicircles.add(new Epicircle(150, 0.6, 1));
		
		ctrl.init();
		ArrayList<Shape> hand = new ArrayList<>();
		ctrl.foreach(s -> {
			hand.add(s);
		});
		r.shape.add(hand);
		
		EpicircleRenderer er = new EpicircleRenderer(ctrl);
		er.init();
		
		ArrayList<Shape> s = new ArrayList<Shape>();
		r.shape.add(s);
		for(Line l : er.path) {
			s.add(l);
		}
		
		r.setPreferredSize(new Dimension(600, 400));
		f.add(r);
		
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
		FPSController con = new FPSController();
		con.run = er;
		
		con.run(r);
	}

}



