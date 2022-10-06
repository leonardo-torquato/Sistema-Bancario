package sistema_bancario.dominio;

import sistema_bancario.dominio.conta.ContaBancaria;
import sistema_bancario.dominio.relatorio.Imprimivel;

import java.util.ArrayList;

public class Banco implements Imprimivel {
    public static ArrayList<ContaBancaria> contasBancarias = new ArrayList<ContaBancaria>();

    @Override
    public String mostrarDados() {
        return null;
    }

    public static void mostrarDado() {
        for (ContaBancaria conta : contasBancarias) {
            String dados = "{" +
                    "saldo=" + conta.getSaldo() +
                    ", numeroDaConta=" + conta.getNumeroDaConta() +
                    '}';
            System.out.println(dados);
        }
    }

    public static void inserirConta(ContaBancaria conta) {
        if (!contasBancarias.contains(conta)) {
            contasBancarias.add(conta);
            System.out.println("conta adicionada com sucesso!");
        } else {
            System.out.println("conta já está presente no banco!");
        }
    };

    public static void removerConta(ContaBancaria conta) {
        if (contasBancarias.contains(conta)) {
            contasBancarias.remove(conta);
            System.out.println("conta removida com sucesso!");
        } else {
            System.out.println("a conta nao esta presente no banco!");
        }
    };

    public static ContaBancaria procurarConta(long numeroDaConta) {
        for (ContaBancaria contaNaArrayList : contasBancarias) {
            if (contaNaArrayList.getNumeroDaConta() == numeroDaConta) {
                return contaNaArrayList;
            }
        }
        return null;
    };
}
