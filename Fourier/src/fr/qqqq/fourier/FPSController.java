package fr.qqqq.fourier;

public class FPSController {
	public FPSController() {
		// TODO Auto-generated constructor stub
	}
	public void run(Renderer r) throws InterruptedException {
		long lt, t, wait = 0, fps = 1000 / 30;
		
		lt = System.currentTimeMillis();
		while(true) {
			t = System.currentTimeMillis();
			lt += fps;
			wait = lt - t;
			
			r.repaint();
			
			if(wait >= 0) Thread.sleep(wait);
		}
	}
}
