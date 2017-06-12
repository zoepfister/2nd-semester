/**
 * <code>ComplexNumber</code> is a class which implements complex numbers in Java.
 * It includes basic operations that can be performed on complex numbers such as,
 * addition, subtraction, multiplication, conjugate, modulus and squaring. Updated
 * to also handle abs and squared abs.
 *
 * @author      Abdul Fatir
 * @author      Clemens Pfister
 *
 */

public class Complex
{

    private double real;
    private double imaginary;

    public Complex()
    {
        real = 0.0;
        imaginary = 0.0;
    }

    public Complex(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(Complex complex_number)
    {
        this.real = this.real + complex_number.real;
        this.imaginary = this.imaginary + complex_number.imaginary;
    }

    public double absSquared() {
        return (this.real*this.real + this.imaginary*this.imaginary);
    }
    
    public double abs() {
        return Math.sqrt(absSquared());
    }

    public Complex square()
    {
        double _real = this.real*this.real - this.imaginary*this.imaginary;
        double _imaginary = 2*this.real*this.imaginary;
        return new Complex(_real,_imaginary);
    }

    /**
     * Unused methods
     */

    public Complex conjugate()
    {
        return new Complex(this.real,-this.imaginary);
    }

    public double mod()
    {
        return Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imaginary,2));
    }

    public void multiply(Complex complex_number)
    {
        double _real = this.real*complex_number.real - this.imaginary*complex_number.imaginary;
        double _imaginary = this.real*complex_number.imaginary + this.imaginary*complex_number.real;

        this.real = _real;
        this.imaginary = _imaginary;
    }

    /**
     * Prints the complex number in x + yi format
     */

    public void print()
    {
        System.out.println(this.real+" + "+this.imaginary+"i");
    }
}