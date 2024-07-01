package modelo;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorDesejadoImovel, int prazoDoImovelAnos, double taxaDeJuros, double areaConstruida, double tamanhoTerreno) {
        super(valorDesejadoImovel, prazoDoImovelAnos, taxaDeJuros);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (this.taxaJurosAnual / 100) / 12;
        int numeroPagamentos = this.prazoFinanciamento * 12;
        double pagamentoMensalBase = (this.valorImovel * taxaMensal * Math.pow(1 + taxaMensal, numeroPagamentos)) /
                (Math.pow(1 + taxaMensal, numeroPagamentos) - 1);
        return pagamentoMensalBase + 80; // Adiciona o valor extra de R$ 80
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.printf("Área Construída: %.2f m²\n", areaConstruida);
        System.out.printf("Tamanho do Terreno: %.2f m²\n", tamanhoTerreno);
    }
}
