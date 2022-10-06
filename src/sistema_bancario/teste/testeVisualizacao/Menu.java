package sistema_bancario.teste.testeVisualizacao;

import sistema_bancario.dominio.Banco;
import sistema_bancario.dominio.conta.ContaBancaria;
import sistema_bancario.dominio.conta.ContaCorrente;
import sistema_bancario.dominio.conta.ContaPoupanca;

import java.util.Scanner;

public abstract class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static int imprimirSelecaoUm() {
        System.out.println("--------[BANCO ORIENTADO A OBJETOS]--------");
        System.out.println("-------------------------------------------");
        System.out.println("---------------1. Criar conta--------------");
        System.out.println("---------------2. Selecionar conta---------");
        System.out.println("---------------3. Remover conta------------");
        System.out.println("---------------4. Gerar relatório----------");
        System.out.println("---------------5. Finalizar----------------");
        System.out.println("-------------------------------------------");
        System.out.print("Selecione uma opcao para o servico desejado: ");

        return scanner.nextInt();
    }

    public static int imprimirSelecaoDois() {
        System.out.println("--------[BANCO ORIENTADO A OBJETOS]--------");
        System.out.println("-------------------------------------------");
        System.out.println("--------1. Depositar-----------------------");
        System.out.println("--------2. Sacar---------------------------");
        System.out.println("--------3. Transferir----------------------");
        System.out.println("--------4. Gerar relatório-----------------");
        System.out.println("--------5. Retornar ao menu anterior-------");
        System.out.println("-------------------------------------------");
        System.out.print("Selecione uma opcao para o servico desejado: ");

        return scanner.nextInt();
    }

    public static void menuUm() {
        int resposta = Menu.imprimirSelecaoUm();

        switch (resposta) {
            case 1:
                criarConta();
                break;

            case 2:
                selecionarConta();
                break;

            case 3:
                removerConta();
                menuUm();
                break;

            case 4:
                Banco.mostrarDado();
                menuUm();
                break;

            case 5:
                break;
        }
    }

    private static void menuDois(long numeroDaConta) {
        ContaBancaria contaAtual = Banco.procurarConta(numeroDaConta);

        int servico = imprimirSelecaoDois();
        double valor;

        switch (servico) {
            case 1 -> {
                System.out.print("informe o valor a ser depositado: ");
                valor = scanner.nextDouble();
                contaAtual.depositar(valor);
                menuDois(numeroDaConta);
            }
            case 2 -> {
                System.out.print("informe o valor a ser sacado: ");
                valor = scanner.nextDouble();
                contaAtual.sacar(valor);
                menuDois(numeroDaConta);
            }
            case 3 -> {
                System.out.println("informe o valor que voce gostaria de transferir: ");
                valor = scanner.nextDouble();
                System.out.print("informe o numero da conta que você quer transferir: ");
                long numeroContaSecundaria = scanner.nextLong();
                if (Banco.procurarConta(numeroContaSecundaria) != null) {
                    ContaBancaria contaSecundaria = Banco.procurarConta(numeroContaSecundaria);
                    contaAtual.transferir(valor, contaSecundaria);
                    menuDois(numeroDaConta);
                } else {
                    System.out.println("conta inexistente, tente novamente");
                    menuDois(numeroDaConta);
                }
            }
            case 4 -> {
                System.out.println(contaAtual.mostrarDados());
                menuDois(numeroDaConta);
            }
            case 5 -> {
                menuUm();
            }
        }
    }

    public static void criarConta() {
        System.out.println("----[BANCO ORIENTADO A OBJETOS]----");
        System.out.println("-----------------------------------");
        System.out.println("---------1. Conta corrente---------");
        System.out.println("---------2. Conta poupanca---------");
        System.out.println("-----------------------------------");
        System.out.print("Defina o tipo da conta a ser criada: ");

        int tipoConta = scanner.nextInt();

        System.out.print("informe o numero da conta: ");
        long numeroDaConta = scanner.nextLong();

        if (Banco.procurarConta(numeroDaConta) != null) {
            System.out.println("esse numero de conta ja existe no banco, tente novamente");
            menuUm();
        } else {
            switch (tipoConta) {
                case 1 -> {
                    System.out.print("informe a taxa de operacao: ");
                    double taxaDeOperacao = scanner.nextDouble();
                    ContaBancaria novaConta = new ContaCorrente(numeroDaConta, taxaDeOperacao);
                    Banco.inserirConta(novaConta);
                }
                case 2 -> {
                    System.out.println("informe o limite de credito: ");
                    double limiteCredito = scanner.nextDouble();
                    ContaBancaria novaConta = new ContaPoupanca(numeroDaConta, limiteCredito);
                    Banco.inserirConta(novaConta);
                }
            }
            menuUm();
        }
    }

    public static void selecionarConta() {
        System.out.print("informe o numero da conta: ");
        long numeroDaConta = scanner.nextLong();

        if (Banco.procurarConta(numeroDaConta) == null) {
            System.out.println("conta inexistente, tente novamente");
            selecionarConta();
        } else {
            menuDois(numeroDaConta);
        }
    }

    public static void removerConta() {
        System.out.print("informe o numero da conta a ser removida: ");
        long numeroDaConta = scanner.nextLong();

        if (Banco.procurarConta(numeroDaConta) == null) {
            System.out.println("conta inexistente, tente novamente");
            selecionarConta();
        } else {
            ContaBancaria conta = Banco.procurarConta(numeroDaConta);
            Banco.removerConta(conta);
            menuUm();
        }
    }
}
