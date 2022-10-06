package sistema_bancario.dominio.conta;

public interface AcoesConta {
    boolean sacar(double valor);

    boolean depositar(double valor);
}
