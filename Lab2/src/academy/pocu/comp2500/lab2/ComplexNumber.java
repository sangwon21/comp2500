package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    public final double real;
    public final double imaginary;

    public ComplexNumber() {
        this(0.0, 0.0);
    }

    public ComplexNumber(final double real) {
        this(real, 0.0);
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public ComplexNumber(final double real, final double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public boolean isReal() {
        return this.imaginary == 0.0;
    }

    public boolean isImaginary() {
        return this.real == 0.0;
    }

    public ComplexNumber getConjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(this.real + num.real, this.imaginary + num.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(this.real - num.real, this.imaginary - num.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber num) {
        double real = this.real * num.real - this.imaginary * num.imaginary;
        double imaginary = this.real * num.imaginary + this.imaginary * num.real;

        return new ComplexNumber(real, imaginary);
    }

    // (a + bi)(c - di) / (c^2 + d^2)
    public ComplexNumber divide(ComplexNumber num) {
        ComplexNumber tmp = this.multiply(num.getConjugate());
        double divisor = num.getReal() * num.getReal() + num.getImaginary() * num.getImaginary();

        return new ComplexNumber(tmp.getReal() / divisor, tmp.getImaginary() / divisor);
    }
}
