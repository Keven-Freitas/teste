package main;

import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Solicita os dados para o primeiro financiamento
        System.out.println("Insira os detalhes do financiamento abaixo");

        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.pedirTaxaJuros();

        // Solicitando atributos adicionais específicos para Casa
        System.out.println("Insira os detalhes adicionais para Casa");
        System.out.print("Área Construída (m²): ");
        double areaConstruida = interfaceUsuario.getScanner().nextDouble();
        System.out.print("Tamanho do Terreno (m²): ");
        double tamanhoTerreno = interfaceUsuario.getScanner().nextDouble();

        Financiamento financiamento1 = new Casa(valorImovel, prazoFinanciamento, taxaJuros, areaConstruida, tamanhoTerreno);
        financiamentos.add(financiamento1);

        // Adiciona financiamentos adicionais com dados fixos
        financiamentos.add(new Casa(500000, 10, 10, 200, 400));
        financiamentos.add(new Apartamento(400000, 20, 9, 2, 15));
        financiamentos.add(new Apartamento(300000, 15, 8.5, 1, 10));
        financiamentos.add(new Terreno(200000, 5, 12, "residencial"));

        // Inicializa variáveis para calcular os totais
        double valorTotalImoveis = 0;
        double valorTotalFinanciamentos = 0;

        // Exibe detalhes de cada financiamento e acumula os totais
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            System.out.println("\nDetalhes do Financiamento " + (i + 1) + ":");
            financiamento.mostrarDadosFinanciamento();

            // Acumula os valores
            valorTotalImoveis += financiamento.getValorImovel();
            valorTotalFinanciamentos += financiamento.calcularTotalPagamento();
        }

        // Mostra os valores totais
        System.out.printf("\nValor total de todos os imóveis: %.2f\n", valorTotalImoveis);
        System.out.printf("Valor total de todos os financiamentos: %.2f\n", valorTotalFinanciamentos);

        interfaceUsuario.closeScanner();
    }
}
