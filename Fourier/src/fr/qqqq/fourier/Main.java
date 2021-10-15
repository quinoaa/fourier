package fr.qqqq.fourier;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import fr.qqqq.fourier.epicircles.Epicircle;
import fr.qqqq.fourier.epicircles.EpicircleController;
import fr.qqqq.fourier.epicircles.EpicircleRenderer;
import fr.qqqq.fourier.shapes.Circle;
import fr.qqqq.fourier.shapes.Line;
import fr.qqqq.fourier.shapes.Shape;
import fr.qqqq.fourier.sig.Fourier;
import fr.qqqq.fourier.sig.PointSignal;
import fr.qqqq.fourier.sig.Signal;
import fr.qqqq.fourier.sig.SignalWaveRenderer;
import fr.qqqq.fourier.sig.SinusSignal;
import fr.qqqq.fourier.sig.SinusSignal.Sinus;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		JFrame f = new JFrame("geom");
		
		SignalWaveRenderer wr = new SignalWaveRenderer();
		//wr.precision = 2;
		
		
		PointSignal sig = new PointSignal();

		int count = (int) (Math.random() * 10 + 10);
		for(int i = 0;i < count;i ++) {
			sig.values.add(Math.random() * 20 - 10);
		}
		wr.signal.add(sig);
		
		
		SinusSignal ss = new SinusSignal();

		ss.max = 10;
		ss.min = -10;
		ss.color = Color.red;
		Fourier.process(ss.sinuses, sig);
		
		wr.signal.add(ss);
		
		
		
		/*
		for(int c = 0;c < 2;c ++) {
			PointSignal sig = new PointSignal();
			sig.color = Color.getHSBColor((float) Math.random(), 1, 1);
			
			int count = (int) (Math.random() * 10 + 5);
			for(int i = 0;i < count;i ++) {
				sig.values.add(Math.random() * 1000);
			}
			wr.signal.add(sig);
		}
		*/
		
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
		ctrl.epicircles.add(new Epicircle(100, 0, 1));
		ctrl.epicircles.add(new Epicircle(100, 0, -3));
		
		//for(int i = 0;i < 5;i ++) {
		//	ctrl.epicircles.add(new Epicircle(Math.random() * 50 + 10, Math.random(), (int)(Math.random() * 10)));
		//}
		
		
		
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



