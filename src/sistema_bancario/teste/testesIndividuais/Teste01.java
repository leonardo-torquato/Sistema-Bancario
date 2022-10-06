package sistema_bancario.teste.testesIndividuais;

import sistema_bancario.dominio.conta.ContaBancaria;
import sistema_bancario.dominio.conta.ContaCorrente;
import sistema_bancario.dominio.conta.ContaPoupanca;
import sistema_bancario.dominio.relatorio.Relatorio;

public class Teste01 {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaCorrente(112233, 1.50);
        conta1.depositar(900);

        System.out.println("----------------------------------------------");

        ContaBancaria conta2 = new ContaPoupanca(445566, 200);
        conta2.depositar(500);

        System.out.println("----------------------------------------------");

        Relatorio.gerarRelatorio(conta1);
        Relatorio.gerarRelatorio(conta2);

        System.out.println("----------------------------------------------");

        conta1.sacar(320);
        conta2.sacar(650);

        System.out.println("----------------------------------------------");

        Relatorio.gerarRelatorio(conta1);
        Relatorio.gerarRelatorio(conta2);
    }
}
