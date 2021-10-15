package fr.qqqq.fourier.sig;

import java.util.ArrayList;

public class SinusSignal extends Signal {
	public double min = -10, max = 10;
	public boolean cos = false;
	
	public ArrayList<Sinus> sinuses = new ArrayList<Sinus>();
	
	
	public SinusSignal() {
		
	}
	
	
	
	@Override
	public double getvalue(double index) {
		
		double y = 0;
		for(Sinus s : sinuses) {
			y = cos ? s.cos(y, index) : s.sin(y, index);
		}
		
		
		return y;
	}

	@Override
	public double getstart() {
		return 0;
	}

	@Override
	public double getend() {
		return 1;
	}

	@Override
	public double maxheight() {
		return max;
	}

	@Override
	public double minheight() {
		return min;
	}
	
	
	

	public static class Sinus{
		public double radius, initial;
		public int speed;
		
		public Sinus(double radius, int speed, double initial) {
			this.radius = radius;
			this.speed = speed;
			this.initial = initial;
		}

		public double sin(double y, double t) {
			return y + Math.sin((speed * t + initial) * Math.PI * 2) * radius;
		}
		public double cos(double y, double t) {
			return y + Math.cos((speed * t + initial) * Math.PI * 2) * radius;
		}
	}
}
