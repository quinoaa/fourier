package fr.qqqq.fourier.epicircles;

import java.util.ArrayList;

import fr.qqqq.fourier.shapes.Line;

public class EpicircleRenderer implements Runnable {

	double s = 0;
	double increment = 0.001;
	int repeatincrement = 10;
	EpicircleController controller;
	
	Line[] path;

	public EpicircleRenderer(EpicircleController controller, double increment, int repeatincrement) {
		this.controller = controller;
		this.increment = increment;
		this.repeatincrement = repeatincrement;
	}
	public EpicircleRenderer(EpicircleController controller) {
		this.controller = controller;
	}
	private void init() {
		//path = new Line[];
	}
	
	@Override
	public void run() {
		for(int i = 0;i < repeatincrement;i ++) {
			s += increment;
			s %= 1;
			
			System.out.println(s);
			
			controller.transform(s);
		}
	}

}
