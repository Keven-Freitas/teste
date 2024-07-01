package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    // Métodos anteriores
    public double pedirValorImovel() {
        double valor;
        do {
            System.out.println("Qual o valor do imóvel (valor positivo): ");
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Valor inválido. Por favor, insira um valor positivo.");
            }
        } while (valor <= 0);
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo;
        do {
            System.out.println("Qual o prazo do financiamento em anos (valor positivo e não mais que 35 anos): ");
            prazo = scanner.nextInt();
            if (prazo <= 0 || prazo > 35) {
                System.out.println("Prazo inválido. Por favor, insira um prazo positivo e não mais que 35 anos.");
            }
        } while (prazo <= 0 || prazo > 35);
        return prazo;
    }

    public double pedirTaxaJuros() {
        double taxa;
        do {
            System.out.println("Qual a taxa de juros anual (valor positivo e não mais que 100): ");
            taxa = scanner.nextDouble();
            if (taxa <= 0 || taxa > 100) {
                System.out.println("Taxa inválida. Por favor, insira uma taxa positiva e não mais que 100.");
            }
        } while (taxa <= 0 || taxa > 100);
        return taxa;
    }

    public void closeScanner() {
        if (this.scanner != null) {
            this.scanner.close();
        }
    }
}
