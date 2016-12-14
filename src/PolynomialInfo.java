import java.io.*;
import java.util.ArrayList;

public class PolynomialInfo {
    public static void main(String[] args) {
        Polynomial firstPolynomial = new Polynomial(), secondPolynomial = new Polynomial();
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("data.txt"));
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
                firstPolynomial.setDegree(degree);
                firstPolynomial.setCoeffs(coeffs);
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
                secondPolynomial.setDegree(degree);
                secondPolynomial.setCoeffs(coeffs);
            } else {
                throw new IOException("Ошибка в чтении из файла!");
            }
        } catch (FileNotFoundException e) {
            System.out.print("Проблема в работе с файлом!");
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            printMenu();
            try {
                String choice = reader.readLine();
                switch (choice) {
                    case "1":
                        Polynomial sumPoly = firstPolynomial.addition(secondPolynomial);
                        System.out.println("Сумма = " + sumPoly);
                        break;
                    case "2":
                        Polynomial subPoly = firstPolynomial.substraction(secondPolynomial);
                        System.out.println("Разность = " + subPoly);
                        break;
                    case "3":
                        Polynomial multPoly = firstPolynomial.multiplication(secondPolynomial);
                        System.out.println("Произведение = " + multPoly);
                        break;
                    case "4":
                    case "5": return;
                    default: System.out.println("Введите значение из списка!"); break;
                }
            } catch (IOException e) {
                System.out.print("Произошла ошибка в чтении!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Введите, что вы хотите сделать: ");
        System.out.println("1 - сложить многочлены.");
        System.out.println("2 - вычесть многочлены.");
        System.out.println("3 - перемножить многочлены.");
        System.out.println("4 - вывести таблицу значений");
        System.out.println("5 - выход.");
    }
}
