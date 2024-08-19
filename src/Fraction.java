public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            checkDenominator(denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private void checkDenominator(int denominator) {
        if (denominator < 0)
            throw new IllegalArgumentException("denominator mast be positive");
        this.denominator = denominator;
    }

    public Fraction sum(Fraction f) {
        int newDenominator = Math.nok(getDenominator(), f.getDenominator());
        int newNumerator = ((newDenominator / getDenominator()) * getNumerator()) +
                ((newDenominator / f.getDenominator()) * f.getNumerator());
        int nod = Math.nod(newNumerator, newDenominator);
        newNumerator = newNumerator / nod;
        newDenominator = newDenominator / nod;
        Fraction fSum = new Fraction(newNumerator, newDenominator);
        return fSum;
    }

    public Fraction sum(int numerator) {
        Fraction f1 = new Fraction(numerator, 1);
        return sum(f1);
    }

    public Fraction minus(Fraction f) {
        int newDenominator = Math.nok(getDenominator(), f.getDenominator());
        int newNumerator = ((newDenominator / getDenominator()) * getNumerator()) -
                ((newDenominator / f.getDenominator()) * f.getNumerator());
        int nod = Math.nod(newNumerator, newDenominator);
        newNumerator = newNumerator / nod;
        newDenominator = newDenominator / nod;
        Fraction fMinus = new Fraction(newNumerator, newDenominator);
        return fMinus;
    }

    public Fraction minus (int numerator) {
        Fraction f1 = new Fraction(numerator, 1);
        return minus(f1);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

class Math {
    static int nok(int a, int b) {
        return (a * b) / nod(a, b);
    }

    static int nod(int a, int b) {
        while (b != 0) {
           int x = b;
           b = a % b;
           a = x;
        }
        if ( a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}
