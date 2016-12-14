import java.util.ArrayList;
import java.util.ListIterator;

public class Polynomial {
    private int degree;
    private ArrayList<Double> coeffs;

    public Polynomial() {
        degree = 0;
        coeffs = new ArrayList<>();
        coeffs.add(0.0);
    }

    public Polynomial (Polynomial p) {
        this.degree = p.getDegree();
        coeffs = new ArrayList<>();
        this.coeffs = p.getCoeffs();
    }

    public Polynomial (int d, ArrayList<Double> coeffs) {
        this.degree = d;
        this.coeffs = new ArrayList<>();
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return degree;
    }

    public ArrayList<Double> getCoeffs() {
        return coeffs;
    }

    public void setCoeffs(ArrayList<Double> coeffs) {
        this.coeffs = coeffs;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
    //Сложение
    public Polynomial addition(Polynomial p) {
        Polynomial newPoly = new Polynomial();
        ListIterator<Double> thisCoefIterator = this.getCoeffs().listIterator(),
                             pCoefIterator = p.getCoeffs().listIterator();
        ArrayList<Double> newCoeffs = new ArrayList<>();
        if (this.degree == p.degree) {
            newPoly.setDegree(this.degree);
            while (thisCoefIterator.hasNext()) {
                newCoeffs.add(thisCoefIterator.next() + pCoefIterator.next());
            }
            newPoly.setCoeffs(newCoeffs);
        } else {
            if (this.degree > p.degree) {
                newPoly.setDegree(this.degree);
                int bufDegree = this.degree;
                while (bufDegree-- > p.degree) {
                    newCoeffs.add(thisCoefIterator.next());
                }
                while (thisCoefIterator.hasNext()) {
                    newCoeffs.add(thisCoefIterator.next() + pCoefIterator.next());
                }
                newPoly.setCoeffs(newCoeffs);
            } else {
                newPoly.setDegree(p.degree);
                int bufDegree = p.degree;
                while (bufDegree-- > this.degree) {
                    newCoeffs.add(pCoefIterator.next());
                }
                while (pCoefIterator.hasNext()) {
                    newCoeffs.add(thisCoefIterator.next() + pCoefIterator.next());
                }
                newPoly.setCoeffs(newCoeffs);
            }
        }
        return newPoly;
    }
    //Вычитание
    public Polynomial substraction(Polynomial p) {
        Polynomial newPoly = new Polynomial();
        ListIterator<Double> thisCoefIterator = this.getCoeffs().listIterator(),
                pCoefIterator = p.getCoeffs().listIterator();
        ArrayList<Double> newCoeffs = new ArrayList<>();
        if (this.degree == p.degree) {
            newPoly.setDegree(this.degree);
            while (thisCoefIterator.hasNext()) {
                newCoeffs.add(thisCoefIterator.next() - pCoefIterator.next());
            }
            newPoly.setCoeffs(newCoeffs);
        } else {
            if (this.degree > p.degree) {
                newPoly.setDegree(this.degree);
                int bufDegree = this.degree;
                while (bufDegree-- > p.degree) {
                    newCoeffs.add(thisCoefIterator.next());
                }
                while (thisCoefIterator.hasNext()) {
                    newCoeffs.add(thisCoefIterator.next() - pCoefIterator.next());
                }
                newPoly.setCoeffs(newCoeffs);
            } else {
                newPoly.setDegree(p.degree);
                int bufDegree = p.degree;
                while (bufDegree-- > this.degree) {
                    newCoeffs.add(pCoefIterator.next());
                }
                while (pCoefIterator.hasNext()) {
                    newCoeffs.add(thisCoefIterator.next() - pCoefIterator.next());
                }
                newPoly.setCoeffs(newCoeffs);
            }
        }
        return newPoly;
    }

    public Polynomial multiplication(Polynomial p) {
        Polynomial newPoly = new Polynomial();
        newPoly.setDegree(this.degree + p.degree);
        Double buffer;
        ArrayList<Double> newCoeffs = new ArrayList<>(this.degree + p.degree);
        for (int i = this.degree + p.degree; i >= 0; i--) {
            newCoeffs.add(0.0);
        }
        for (int i = this.degree; i >= 0; i--) {
            for (int j = p.degree; j >= 0; j--) {
                buffer = this.coeffs.get(i) * p.coeffs.get(j);
                newCoeffs.set(i + j, newCoeffs.get(i + j) + buffer);
            }
        }
        newPoly.setCoeffs(newCoeffs);
        return newPoly;
    }
    //Таблица значений
    public void valuesTable(Double from, Double to, Double step) {
        Double value;
        Double currentValue = from;
        while (currentValue <= to) {
            value = 0.0;
            for (int i = 0; i < this.degree + 1; i++) {
                value += this.coeffs.get(i) * Math.pow(currentValue, this.degree - i);
            }
            System.out.println("Аргумент: " + currentValue + " | Значение многочлена: " + value);
            currentValue += step;
        }
        System.out.println("\n\n");
    }

    @Override
    public String toString() {
        String polynomial = "";
        for (int i = 0; i < this.degree + 1; i++) {
            if (i == 0) {
                polynomial += this.coeffs.get(i) + " * x^" + this.degree;
            } else {
                if (i == this.degree) {
                    if (this.coeffs.get(i) >= 0) polynomial += " + " + this.coeffs.get(i);
                    else {
                        polynomial += " - " + -this.coeffs.get(i);
                    }
                } else {
                    if (this.coeffs.get(i) > 0) {
                        polynomial += " + " + this.coeffs.get(i) + " * x^" + (this.degree - i);
                    } else {
                        polynomial += " - " + -this.coeffs.get(i) + " * x^" + (this.degree - i);
                    }
                }
            }
        }
        return polynomial;
    }
}
