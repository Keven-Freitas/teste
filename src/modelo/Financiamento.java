package modelo;

public abstract class Financiamento {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public Financiamento(double valorDesejadoImovel, int prazoDoImovelAnos, double taxaDeJuros) {
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoDoImovelAnos;
        this.taxaJurosAnual = taxaDeJuros;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void mostrarDadosFinanciamento() {
        System.out.printf("Valor do Imóvel: %.2f\n", valorImovel);
        System.out.printf("Prazo de Financiamento (anos): %d\n", prazoFinanciamento);
        System.out.printf("Taxa de Juros Anual: %.2f%%\n", taxaJurosAnual);
        System.out.printf("Pagamento Mensal: %.2f\n", calcularPagamentoMensal());
        System.out.printf("Total a ser Pago: %.2f\n", calcularTotalPagamento());
    }
}
