package sistema_bancario.dominio.conta;

import sistema_bancario.dominio.relatorio.Imprimivel;

public abstract class ContaBancaria implements Imprimivel, AcoesConta {
    protected long numeroDaConta;
    protected double saldo;

    public ContaBancaria(long numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
        this.saldo = 0;
    }

    public void transferir(double valor, ContaBancaria conta) {
        boolean isSaqueBemSucedido = this.sacar(valor);

        if (isSaqueBemSucedido) {
            conta.depositar(valor);
        }
    };

    public long getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(long numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }
}
