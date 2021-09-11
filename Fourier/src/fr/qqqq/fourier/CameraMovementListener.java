package fr.qqqq.fourier;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class CameraMovementListener implements MouseWheelListener, MouseListener, MouseMotionListener{
	Camera cam;
	
	public CameraMovementListener(Camera cam) {
		this.cam = cam;
	}

	int posx = 0, posy = 0;
	int relx = 0, rely = 0;
	@Override
	public void mouseDragged(MouseEvent e) {
		relx = posx - e.getX();
		rely = posy - e.getY();
		
		cam.x -= relx;
		cam.y -= rely;
		
		posx = e.getX(); posy = e.getY();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		posx = e.getX(); posy = e.getY();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}

	
	
	
	
	
	
	
	

	
	
	
}





