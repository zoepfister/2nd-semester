public class Mandelbrot {

	public static void main(String[] args) {
		for (double l = -1.2; l < 1.2; l += 0.05) {
			for (double w = -2.2; w < 1.0; w += 0.025) {
				Complex complexNumber = new Complex(0.0, 0.0);
				double a = 0.0;
				for (int j = 0; j < 100; j++) {
					complexNumber = complexNumber.square();
					complexNumber.add(new Complex((double)w, (double)l));
					if (complexNumber.abs() > 2) {
						break;
					}
				}
				if (complexNumber.abs() > 2) {
					System.out.print(" ");
				} else {
					System.out.print("\u25a0");
				}
			}
			System.out.print("\n");
		}
	}
}
