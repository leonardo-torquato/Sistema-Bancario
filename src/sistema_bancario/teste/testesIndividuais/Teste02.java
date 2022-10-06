package sistema_bancario.teste.testesIndividuais;

import sistema_bancario.dominio.conta.ContaBancaria;
import sistema_bancario.dominio.conta.ContaCorrente;
import sistema_bancario.dominio.conta.ContaPoupanca;
import sistema_bancario.dominio.relatorio.Relatorio;

public class Teste02 {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaPoupanca(1, 0);
        ContaBancaria conta2 = new ContaCorrente(2, 0);

        Relatorio.gerarRelatorio(conta1);
        Relatorio.gerarRelatorio(conta2);

        conta1.depositar(100);
        conta1.transferir(110, conta2);

        Relatorio.gerarRelatorio(conta1);
        Relatorio.gerarRelatorio(conta2);
    }
}
