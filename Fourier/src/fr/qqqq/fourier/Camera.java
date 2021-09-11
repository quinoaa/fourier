package fr.qqqq.fourier;

public class Camera {
	public double x = 0, y = 0;
	public double zoom = 1;
	
	public double calcX(double x) {
		System.out.print(x + this.x);
		return (this.x + x) * zoom;
	}
	public double calcY(double y) {
		System.out.println(" " + (y + this.y));
		return (this.y + y) * zoom;
	}
}
