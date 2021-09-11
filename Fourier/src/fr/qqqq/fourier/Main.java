package fr.qqqq.fourier;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		JFrame f = new JFrame("geom");
		
		Renderer r = new Renderer();
		
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
