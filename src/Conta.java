public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 0;
    protected final int numero;
    protected final int agencia;
    protected double saldo;
    private final Cliente cliente;

    public Conta(Cliente cliente){
        SEQUENCIAL++;
        numero = SEQUENCIAL;
        this.agencia = AGENCIA_PADRAO;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public boolean sacar(double qtd){
        saldo -= qtd;
        return true;
    }

    public boolean depositar(double qtd){
        saldo += qtd;
        return true;
    }

    public boolean transferir(double qtd, Conta conta){
        this.sacar(qtd);
        conta.depositar(qtd);
        return true;
    }

    public void imprimirExtrato(){
        exibirInformacoes();
    }

    public int getNumero(){
        return numero;
    }
    public int getAgencia(){
        return agencia;
    }
    public double getSaldo(){
        return saldo;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void exibirInformacoes(){
        cliente.listar();
        System.out.println("\nNúmero da Conta: " + numero + "\nAgência: " + agencia + "\nSaldo: " + saldo + "\n");
    }

}