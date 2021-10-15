package fr.qqqq.fourier.sig;

import java.util.List;

import fr.qqqq.fourier.sig.SinusSignal.Sinus;

public class Fourier {
	public static void process(List<Sinus> sines, Signal sig) {
		for(int i = 1;i < 1000;i += 2) {
			sines.add(new Sinus(10.0000 / i, i, 0));
		}
	}
}
