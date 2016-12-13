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
        ListIterator<Double> thisCoefIterator = this.getCoeffs().listIterator(),
                pCoefIterator = p.getCoeffs().listIterator();
        ArrayList<Double> newCoeffs = new ArrayList<>(this.degree + p.degree + 1);
        newPoly.setDegree(this.degree + p.degree);
        Double buffer;
        Double[] nC = new Double[this.degree + p.degree + 1];
//        int i = -1, j = -0;
//        while (thisCoefIterator.hasNext()) {
//            i++;
//            while (pCoefIterator.hasNext()) {
//                j++;
//                newCoeffs.add(i + j, thisCoefIterator.next() * pCoefIterator.next());
//            }
//        }
        for (int i = this.degree; i >= 0; i--) {
            for (int j = p.degree; j >= 0; j--) {
                nC[i + j] += this.coeffs.get(i) * p.coeffs.get(j);
            }
        }
        System.out.print("ld");
        newPoly.setCoeffs(newCoeffs);
        return newPoly;
    }
}
