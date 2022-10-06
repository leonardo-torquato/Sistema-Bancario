package sistema_bancario.dominio.conta;

public class ContaCorrente extends ContaBancaria {
    private double taxaDeOperacao;

    public ContaCorrente(long numeroDaConta, double taxaDeOperacao) {
        super(numeroDaConta);
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public boolean sacar(double valor) {
        double quantiaSaque = valor + taxaDeOperacao;
        if (saldo >= quantiaSaque) {
            saldo -= quantiaSaque;
            System.out.println("saque de R$" + valor + " efetuado com sucesso!");
            return true;
        } else {
            System.out.println("saldo insuficiente");
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > taxaDeOperacao) {
            double quantiaDeposito = valor - taxaDeOperacao;
            saldo += quantiaDeposito;
            System.out.println("deposito de R$" + valor + " efetuado com sucesso!");
            return true;
        } else {
            System.out.println("o valor a ser depositado deve ser maior que a taxa de operação!");
            return false;
        }
    }

    @Override
    public String mostrarDados() {
        return "ContaCorrente{" +
                "numeroDaConta=" + numeroDaConta +
                ", saldo=" + saldo +
                ", taxaDeOperacao=" + taxaDeOperacao +
                '}';
    }

    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }
}
