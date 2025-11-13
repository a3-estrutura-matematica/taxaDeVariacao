import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class TaxadeVariacao {
    public static double derivadaT(double n) {
        return (15 * Math.pow(n, 2)) + (2 * n) - 6;
    }

    public static double derivadaP(double n) {
        return (3 * Math.pow(n, 2)) - (10 * n) + 20;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("======= MENU DE QUESTÕES ========");
            System.out.println("Escolha a questão que deseja resolver:");
            System.out.println("1 - Tempo de Execução do Algoritmo (T'(n))");
            System.out.println("2 - População de Fitoplâncton (P'(n))");
            System.out.println("0 - Sair");
            System.out.println("==================================");
            System.out.print("Sua escolha: ");

            try {
                escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        executarQuestaoTempoExecucao(scanner);
                        break;
                    case 2:
                        executarQuestaoFitoplancton(scanner);
                        break;
                    case 0:
                        System.out.println("\nSaindo do programa. Obrigado!");
                        break;
                    default:
                        System.out.println("\nOpção inválida. Por favor, escolha 1, 2 ou 0.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nErro: Entrada inválida. Por favor, digite um número (0, 1 ou 2).");
                scanner.nextLine();
                escolha = -1;
            }

        } while (escolha != 0);

        scanner.close();
    }

    public static void executarQuestaoTempoExecucao(Scanner scanner) {
        System.out.println("\n===== 1. Cálculo da Taxa de Variação do Tempo de Execução ====");
        System.out.println("Derivada: T'(n) = 15n² + 2n - 6");
        System.out.print("Digite o valor de 'n' para o Tempo de Execução: ");

        double n;
        try {
            n = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("\nErro: Entrada de 'n' inválida. Voltando ao menu.");
            scanner.nextLine();
            return;
        }

        System.out.println("\n--- Passo a Passo da Q1 para n = " + n + " ---");

        double n_squared = Math.pow(n, 2);
        double termo_n_quadrado = 15 * n_squared;
        double termo_n = 2 * n;
        double taxaInstantanea = derivadaT(n);

        System.out.println("1. Substituição: T'(" + n + ") = 15 * (" + n + ")² + 2 * (" + n + ") - 6");
        System.out.println("2. Produtos: T'(" + n + ") = " + termo_n_quadrado + " + " + termo_n + " - 6");
        System.out.println("3. Resultado Final: T'(" + n + ") = " + taxaInstantanea);

        System.out.println("\n === RESPOSTA QUESTÃO 1:=== A taxa de variação instantânea do Tempo de Execução para n = " + n + " é: " + taxaInstantanea);
    }


    public static void executarQuestaoFitoplancton(Scanner scanner) {
        System.out.println("\n === 2. Cálculo da Taxa de Variação da População de Fitoplâncton ====");
        System.out.println("Derivada: P'(n) = 3n² - 10n + 20");
        System.out.print("Digite o valor de 'n' para a Concentração de Nutrientes (em mg/L): ");

        double n;
        try {
            n = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("\nErro: Entrada de 'n' inválida. Voltando ao menu.");
            scanner.nextLine();
            return;
        }

        System.out.println("\n ==== Passo a Passo da Questão 2 para n = " + n + " ====");

        double n_squared = Math.pow(n, 2);
        double termo_n_quadrado = 3 * n_squared;
        double termo_n = 10 * n;
        double taxaInstantanea = derivadaP(n);

        System.out.println("1. Substituição: P'(" + n + ") = 3 * (" + n + ")² - 10 * (" + n + ") + 20");
        System.out.println("2. Produtos: P'(" + n + ") = " + termo_n_quadrado + " - " + termo_n + " + 20");
        System.out.println("3. Resultado Final: P'(" + n + ") = " + taxaInstantanea);

        System.out.println("\n === RESPOSTA QUESTÃO 2:===  A taxa de variação instantânea do Fitoplâncton para n = " + n + " mg/L é: " + taxaInstantanea);
    }
}