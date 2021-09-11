package fr.qqqq.fourier;

public class Camera {
	public double x = 0, y = 0;
	public double zoom = 1;
	
	public double calcX(double x) {
		return (this.x + x) * zoom;
	}
	public double calcY(double y) {
		return (this.y + y) * zoom;
	}
	
	public double scaleX(double w) {
		return w * zoom;
	}
	public double scaleY(double h) {
		return h * zoom;
	}
}
