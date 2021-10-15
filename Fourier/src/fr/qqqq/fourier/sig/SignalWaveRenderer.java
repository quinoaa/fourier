package fr.qqqq.fourier.sig;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class SignalWaveRenderer extends JComponent implements MouseMotionListener {
	public ArrayList<Signal> signal = new ArrayList<Signal>();

	public Color background = Color.black;
	public Color foreground = Color.WHITE;
	public Color linecolor = Color.DARK_GRAY;
	
	public Font font = new Font(Font.SANS_SERIF, 0, 14);

	double start = -12.3;
	double end = 10563.9;
	double height = 2;
	double min = -1;
	
	public double precision = 1;
	
	public int hlinespace = 20;
	
	public SignalWaveRenderer() {
		this.setPreferredSize(new Dimension(800, 200));
	}

	int marginleft = 70, marginright = 10;
	int marginbottom = 20, margintop = 10;
	
	@Override
	public void paint(Graphics g) {
		update();
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w = getWidth(), h = getHeight();
		
		g2D.setColor(background);
		g2D.fillRect(0, 0, w, h);
		
		g2D.setFont(font);
		
		int graphw = w - marginleft - marginright, graphh = h - marginbottom - margintop;
		AffineTransform transform = g2D.getTransform();
		g2D.translate(marginleft, margintop + graphh);
		
		g2D.setColor(linecolor);
		double count = graphh / hlinespace;
		for(int i = 0;i <= count + 1;i ++) {
			double value = height * i / count + min;
			double y = 0 - (graphh / count * (i));
			if(i > count) {
				value = 0;
				y = min * graphh / height;
				g2D.setColor(Color.WHITE);
			}
			
			drawString(g2D, right, center, String.format("%.2f", value), -10, (int) y);
			g2D.drawLine(0, (int)y, graphw, (int)y);
		}
		
		
		
		Line2D.Double line = new Line2D.Double();
		signal.forEach(sig -> {
			g2D.setColor(sig.color);
			for(int d = 0;d < graphw * precision;d ++) {
				line.x1 = line.x2;
				line.y1 = line.y2;
				
				line.x2 = d / precision;
				line.y2 = ((0 - sig.getvalue(d * sig.getend() / graphw / precision)) + min) * graphh / height;
				
				if(d == 0) continue;
				g2D.draw(line);
			}
		});
		
		
		
		g2D.setTransform(transform);

		g2D.setColor(foreground);
		
		g2D.drawLine(marginleft, margintop, marginleft, h - marginbottom);
		g2D.drawLine(w - marginright, h - marginbottom, marginleft, h - marginbottom);
	}

	static final int left = 0, top = 0, center = 1, right = 2, bottom = 2;
	private void drawString(Graphics2D g2D, int alignx, int aligny, String text, int x, int y) {
		int fx, fy;
		
		switch (alignx) {
		case right:
			fx = x - g2D.getFontMetrics().stringWidth(text);
			break;
		case center:
			fx = x - g2D.getFontMetrics().stringWidth(text) / 2;
			break;
		default:
			fx = x;
			break;
		}
		switch (aligny) {
		case top:
			fy = y + g2D.getFontMetrics().getHeight();
			break;
		case center:
			fy = y + g2D.getFontMetrics().getHeight() / 2;
			break;
		default:
			fy = y;
			break;
		}
		
		g2D.drawString(text, fx, fy);
	}
	
	public void update() {
		min = Double.MAX_VALUE;
		height = Double.MIN_VALUE;
		
		signal.forEach(sig -> {
			double smin = sig.minheight();
			double sh = sig.maxheight() - smin;

			if(min > smin) min = smin;
			if(height < sh) height = sh;
			
		});
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		
	}

	
}





