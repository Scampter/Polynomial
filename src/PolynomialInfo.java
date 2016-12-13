import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PolynomialInfo {
    public static void main(String[] args) {
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("data.txt"));
            Polynomial firstPolynomial, secondPolynomial;
            int degree = 0;
            ArrayList<Double> coeffs = new ArrayList<>();
            String line;
            if ((line = readFile.readLine()) != null) {
                line = line.replace("\uFEFF", "");
                String[] numb = line.split(" ");
                degree = Integer.parseInt(numb[0]);
                for (int i = 1; i < numb.length; i++) {
                    coeffs.add(Double.parseDouble(numb[i]));
                }
                firstPolynomial = new Polynomial(degree, coeffs);
            } else {
                throw new IOException("Ошибка в чтении из файла!");
            }
            coeffs = new ArrayList<>();
            if ((line = readFile.readLine()) != null) {
                line = line.replace("\uFEFF", "");
                String[] numb2 = line.split(" ");
                degree = Integer.parseInt(numb2[0]);
                for (int i = 1; i < numb2.length; i++) {
                    coeffs.add(Double.parseDouble(numb2[i]));
                }
                secondPolynomial = new Polynomial(degree, coeffs);
            } else {
                throw new IOException("Ошибка в чтении из файла!");
            }
            firstPolynomial.valuesTable(1.0, 10.0, 1.0);
            Polynomial multPoly = firstPolynomial.multiplication(secondPolynomial);
        } catch (FileNotFoundException e) {
            System.out.print("Проблема в работе с файлом!");
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
