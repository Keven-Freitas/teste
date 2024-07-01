package modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorDesejadoImovel, int prazoDoImovelAnos, double taxaDeJuros, int vagasGaragem, int numeroAndar) {
        super(valorDesejadoImovel, prazoDoImovelAnos, taxaDeJuros);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (this.taxaJurosAnual / 100) / 12;
        int numeroPagamentos = this.prazoFinanciamento * 12;
        return (this.valorImovel * taxaMensal * Math.pow(1 + taxaMensal, numeroPagamentos)) /
                (Math.pow(1 + taxaMensal, numeroPagamentos) - 1);
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.printf("Vagas na Garagem: %d\n", vagasGaragem);
        System.out.printf("Número do Andar: %d\n", numeroAndar);
    }
}
