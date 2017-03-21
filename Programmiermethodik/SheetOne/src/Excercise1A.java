class Excercise1A {
	public static void main(String[] args) {

		// Presidency from left to right
		// returns (integer) 8
		int number1 = 6 * 4 / 3;
		System.out.println(number1);

		// Return maximum integer value - 1 (Integer.MAX_VALUE = 2147483647)
		// System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE - 1);

		// Explicit cast to double
		// Double uses IEEE 754 floating point -> Data-loss can occur
		// returns (double) 2.090909090909091
		double number2 = (double) 23 / 11;
		System.out.println(number2);

		// prints 30.0 (floating number)
		System.out.println(30f);

		// Returns true, because 12*1.2= 14.4 != 18
		// * binds stronger than !=
		System.out.println(12 * 1.2 != 18);

		// '' is not allowed in a print statement (works with ""). '' only works
		// for single chars
		// Prints "Luck=Coffee+chocolate2" if corrected
		System.out.println("Luck=Coffee+" + "chocolate" + 2);

		// % binds stronger than ==, >, and &&.
		// First % and >, then ==, then &&
		// returns false
		System.out.println((1 == (18 % 4) && (7 > 4)));

		// First division, then modulo
		// returns (integer?) 1
		System.out.println(8 / 5 % 3);

		// there is no overflow in java -> maxInteger + 1 = minInteger
		// Explicit cast to short (–2^15 to 2^15 – 1), minInteger out of
		// bounce -> defaults to 0 apparently
		System.out.println((short) Integer.MAX_VALUE + 1);

		// The d probably is for 64 bit float, the number behind e
		// determines the amount of zeros in front of the comma
		// returns 40000.0
		System.out.println(4e4d);

		// Prints as text "12 * 1.2 = 18"
		System.out.println("12 * 1.2" + " = 18");

		// Works with single chars
		// Prints "Luck=Coffeec2"
		System.out.println("Luck=Coffee" + 'c' + 2);

		// && binds stronger than ||
		// returns true
		System.out.println((false && true) || true);

	}
}