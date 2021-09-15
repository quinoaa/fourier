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
import fr.qqqq.fourier.sig.Signal;
import fr.qqqq.fourier.sig.SignalWaveRenderer;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		JFrame f = new JFrame("geom");
		
		SignalWaveRenderer wr = new SignalWaveRenderer();
		Signal sig = new Signal();
		wr.signal.add(sig);
		
		
		f.add(wr);
		
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
		FPSController con = new FPSController();
		
		con.run(wr);
		
		
		/*
		Renderer r = new Renderer();
		
		
		
		EpicircleController ctrl = new EpicircleController();
		for(int i = 0;i < 5;i ++) {
			ctrl.epicircles.add(new Epicircle(Math.random() * 50 + 10, Math.random(), (int)(Math.random() * 10)));
		}
		
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
		con.run.add(er);
		
		con.run(r);
		*/
	}

}



