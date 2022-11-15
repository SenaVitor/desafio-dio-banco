public interface IConta {
    boolean sacar(double qtd);
    boolean depositar(double qtd);
    boolean transferir(double qtd, Conta conta);
    void imprimirExtrato();
}
