package sistema_bancario.teste.testesIndividuais;

import sistema_bancario.dominio.Banco;
import sistema_bancario.dominio.conta.ContaBancaria;
import sistema_bancario.dominio.conta.ContaCorrente;

public class Teste03 {
    public static void main(String[] args) {
        Banco banco = new Banco();

        ContaBancaria conta1 = new ContaCorrente(1, 0);
        ContaBancaria conta2 = new ContaCorrente(2, 0);
        ContaBancaria conta3 = new ContaCorrente(3, 0);

        Banco.inserirConta(conta1);
        Banco.inserirConta(conta2);
        Banco.inserirConta(conta3);

        Banco.removerConta(conta2);

        banco.mostrarDado();
    }
}
