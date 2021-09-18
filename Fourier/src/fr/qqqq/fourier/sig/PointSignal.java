package fr.qqqq.fourier.sig;

import java.util.ArrayList;

public class PointSignal extends Signal {
	public ArrayList<Double> values = new ArrayList<Double>();
	
	

	@Override
	public double getvalue(double index) {
		int top = (int) Math.ceil(index), bot = (int) Math.floor(index);
		
		double coef = index - bot;
		double val = values.get(top) * coef + values.get(bot) * (1 - coef);
		
		
		return val;
	}

	@Override
	public double getstart() {
		return 0;
	}

	@Override
	public double getend() {
		return values.size() - 1;
	}

	@Override
	public double maxheight() {
		double h = Double.MIN_VALUE;
		for(double d : values){
			if(h < d) h = d;
		};
		return h;
	}

	@Override
	public double minheight() {
		double h = Double.MAX_VALUE;
		for(double d : values){
			if(h > d) h = d;
		};
		return h;
	}

}
