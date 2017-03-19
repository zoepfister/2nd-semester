
public class Excercise1B {
	public static void main(String[] args) {
		int x = 0;
		int y = 3;

		// This statement increments x by 1
		x = ++x;
		// Prints x: 1 y: 3
		System.out.println("x: " + x + " y: " + y);

		/*
		 * y gets incremented by: 7 % 3 = 1; 1 + 2 = 3; The ++x means that x
		 * gets incremented by 1 before the variable is used.
		 */
		y += 7 % y + ++x;
		// Prints x: 2 y: 6
		System.out.println("x: " + x + " y: " + y);

		// x is divided by the value of y(6). (int)2/6 = 0
		x /= y;
		// Prints x: 0 y: 6
		System.out.println("x: " + x + " y: " + y);

		/*
		 * 0 divided through anything is still 0. y gets post incremented by 1.
		 * It seems that if the value 0 is casted to double, it still get's
		 * printed as 0 (instead of 0.0).
		 */
		x += (double) x / (2 * y++);
		// Prints x: 0 y: 7
		System.out.println("x: " + x + " y: " + y);

		/*
		 * Ternary conditional operation: If x equals the value of 7, set y to
		 * 10 else 20.
		 */
		y = (x == y-- ? 10 : 20);
		// Prints x: 0 y: 20
		System.out.println("x: " + x + " y: " + y);

		/*
		 * Another ternary operation: If 0 equals 19, set y to y*50 else y*60
		 */
		y *= ((x * y) == --y ? 50 : 60);
		// Prints x: 0 y: 1200
		System.out.println("x: " + x + " y: " + y);

		/*
		 * Ternary operation again.. if x is smaller than 1199, set y to y - 10
		 * else y - 20
		 */
		y -= (x < --y ? 10 : 20);
		// Prints x: 0 y: 1190
		System.out.println("x: " + x + " y: " + y);
	}
}
