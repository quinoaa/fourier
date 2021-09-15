package fr.qqqq.fourier.epicircles;

import java.awt.Color;

import fr.qqqq.fourier.Position;
import fr.qqqq.fourier.shapes.Line;

public class EpicircleRenderer implements Runnable {

	double s = 0;
	double increment = 0.0001;
	int repeatincrement = 50;
	EpicircleController controller;
	
	public Line[] path;
	int pathindex = 0;

	public EpicircleRenderer(EpicircleController controller, double increment, int repeatincrement) {
		this.controller = controller;
		this.increment = increment;
		this.repeatincrement = repeatincrement;
	}
	public EpicircleRenderer(EpicircleController controller) {
		this.controller = controller;
	}
	public void init() {
		init((int)(1 / increment));
	}
	public void init(int pathlen) {
		path = new Line[pathlen];
		
		for(int i = 0;i < pathlen;i ++) {
			path[i] = new Line(0, 0, 0, 0);
			path[i].color = Color.BLACK;
			path[i].visible = false;
		}
	}
	
	Position lastpos = null;
	@Override
	public void run() {
		for(int i = 0;i < repeatincrement;i ++) {
			s += increment;
			s %= 1;
			
			Position pos = controller.transform(s);
			
			pathindex++;
			pathindex %= path.length;
			
			if(lastpos != null) {
				path[pathindex].visible = true;
				path[pathindex].x1 = pos.x;
				path[pathindex].y1 = pos.y;
				path[pathindex].x2 = lastpos.x;
				path[pathindex].y2 = lastpos.y;
			}
			
			lastpos = pos;
		}
	}

}







