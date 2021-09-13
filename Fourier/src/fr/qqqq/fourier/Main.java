package fr.qqqq.fourier;

import java.awt.Dimension;

import javax.swing.JFrame;

import fr.qqqq.fourier.epicircles.Epicircle;
import fr.qqqq.fourier.epicircles.EpicircleController;
import fr.qqqq.fourier.shapes.Circle;
import fr.qqqq.fourier.shapes.Line;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		JFrame f = new JFrame("geom");
		
		Renderer r = new Renderer();
		
		
		
		EpicircleController ctrl = new EpicircleController();
		ctrl.epicircles.add(new Epicircle(50, 0.2, 1));
		ctrl.epicircles.add(new Epicircle(750, 0, 2));
		ctrl.epicircles.add(new Epicircle(150, 0.6, 1));
		
		ctrl.init();
		ctrl.foreach(s -> {
			r.shape.add(s);
		});
		
		
		
		r.setPreferredSize(new Dimension(600, 400));
		f.add(r);
		
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
		FPSController con = new FPSController();
		con.run = new Runnable() {
			double s = 0;
			double increment = 1 / 60.0;
			
			
			
			@Override
			public void run() {
				s += s;
				s %= 1.0;
				
				System.out.println(s);
				
				ctrl.transform(s);
			}
		};
		
		con.run(r);
	}

}
