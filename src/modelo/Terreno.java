package modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorDesejadoImovel, int prazoDoImovelAnos, double taxaDeJuros, String tipoZona) {
        super(valorDesejadoImovel, prazoDoImovelAnos, taxaDeJuros);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (this.taxaJurosAnual / 100) / 12;
        int numeroPagamentos = this.prazoFinanciamento * 12;
        double pagamentoMensalBase = (this.valorImovel * taxaMensal * Math.pow(1 + taxaMensal, numeroPagamentos)) /
                (Math.pow(1 + taxaMensal, numeroPagamentos) - 1);
        return pagamentoMensalBase * 1.02; // Adiciona um acréscimo de 2%
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.printf("Tipo de Zona: %s\n", tipoZona);
    }
}
