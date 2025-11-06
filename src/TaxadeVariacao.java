import java.util.Scanner;
import java.lang.Math;

public class TaxadeVariacao {

    public static double calcularDerivadaT(double n) {
        return (15 * Math.pow(n, 2)) + (2 * n) - 6;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n;

        System.out.println("Cálculo da Taxa de Variação Instantânea ");
        System.out.println("Derivada (Taxa de Variação): T'(n) = 15n^2 + 2n - 6");
        System.out.println("              ");

        System.out.print("Digite o valor de 'n': ");

        try {
            n = scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            System.out.println("\nErro: Entrada inválida. Por favor, insira um número.");
            return;
        } finally {
            scanner.close();
        }

        System.out.println("\nPasso a Passo da Resolução para n = " + n);

        System.out.println("1. Substituindo n na fórmula T'(n) = 15n^2 + 2n - 6:");
        System.out.println("   T'(" + n + ") = 15 * (" + n + ")^2 + 2 * (" + n + ") - 6");

        double n_squared = Math.pow(n, 2);
        System.out.println("\n2. Cálculo da potência (" + n + "^2 = " + n_squared + "):");
        System.out.println("   T'(" + n + ") = 15 * " + n_squared + " + " + (2 * n) + " - 6");

        double termo_n_quadrado = 15 * n_squared;
        double termo_n = 2 * n;
        System.out.println("\n3. Cálculo dos produtos:");
        System.out.println("   T'(" + n + ") = " + termo_n_quadrado + " + " + termo_n + " - 6");

        double taxaInstantanea = calcularDerivadaT(n);
        System.out.println("\n4. Resultado Final:");
        System.out.println("   T'(" + n + ") = " + taxaInstantanea);

        System.out.println("\n=========================");
        System.out.println("RESPOSTA: A taxa de variação instantânea do tempo de execução para n = " + n + " é: " + taxaInstantanea);
        System.out.println("===========================");
    }
}