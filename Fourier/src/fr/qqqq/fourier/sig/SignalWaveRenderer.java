package fr.qqqq.fourier.sig;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

public class SignalWaveRenderer extends JComponent implements MouseMotionListener {
	public ArrayList<Signal> signal = new ArrayList<Signal>();

	Color background = Color.black;
	Color foreground = Color.WHITE;
	
	Font font = new Font(Font.SANS_SERIF, 0, 12);

	double start = -12.3;
	double end = 10563.9;
	double height = 0;
	double min = 0;
	
	public SignalWaveRenderer() {
		this.setPreferredSize(new Dimension(800, 200));
	}

	int marginleft = 50, marginright = 10;
	int marginbottom = 20, margintop = 10;
	
	@Override
	public void paint(Graphics g) {
		// update(); TODO
		
		Graphics2D g2D = (Graphics2D) g;
		int w = getWidth(), h = getHeight();
		
		g2D.setColor(background);
		g2D.fillRect(0, 0, w, h);
		
		g2D.setColor(foreground);
		g2D.setFont(font);

		g2D.drawLine(marginleft, margintop, marginleft, h - marginbottom);
		g2D.drawLine(w - marginright, h - marginbottom, marginleft, h - marginbottom);
		drawString(g2D, right, center, "-10.5531", marginleft, 0);
		
		
		
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
		height = 0;
		min = 0;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		
	}

	
}





