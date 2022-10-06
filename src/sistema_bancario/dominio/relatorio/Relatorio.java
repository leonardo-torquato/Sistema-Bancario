package sistema_bancario.dominio.relatorio;

public final class Relatorio {
    public static void gerarRelatorio(Imprimivel objeto) {
        System.out.println(objeto.mostrarDados());
    }
}
