package sistema_bancario.dominio.conta;

public class ContaPoupanca extends ContaBancaria {
    private double limite;

    public ContaPoupanca(long numeroDaConta, double limite) {
        super(numeroDaConta);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (Math.abs(saldo - valor) <= limite) {
            saldo -= valor;
            System.out.println("saque de R$" + valor + " efetuado com sucesso!");
            return true;
        } else {
            System.out.println("o valor a ser sacado excede o limite de crédito nessa conta!");
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {
        saldo += valor;
        System.out.println("deposito de R$" + valor + " efetuado com sucesso!");
        return true;
    }

    @Override
    public String mostrarDados() {
        return "ContaPoupanca{" +
                "numeroDaConta=" + numeroDaConta +
                ", saldo=" + saldo +
                ", limite=" + limite +
                '}';
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
