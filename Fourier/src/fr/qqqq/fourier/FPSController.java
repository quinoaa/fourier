package fr.qqqq.fourier;

import java.util.ArrayList;

import javax.swing.JComponent;

public class FPSController {
	public ArrayList<Runnable> run = new ArrayList<Runnable>();

	public FPSController() {
		
	}
	
	public FPSController(Runnable... run) {
		for(Runnable r : run) this.run.add(r);
	}
	
	public void run(JComponent r) throws InterruptedException {
		long lt, t, wait = 0, fps = 1000 / 60;
		
		lt = System.currentTimeMillis();
		while(true) {
			t = System.currentTimeMillis();
			lt += fps;
			wait = lt - t;
			
			run.forEach(runnable -> runnable.run());
			r.repaint();
			
			if(wait >= 0) Thread.sleep(wait);
		}
	}
}
