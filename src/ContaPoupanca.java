public class ContaPoupanca extends Conta{
    static final private double taxaJuros = 0.1375;

    public ContaPoupanca(Cliente cliente){
        super(cliente);
    }

    public boolean sacar(double qtd){
        if(saldo >= qtd){
            super.sacar(qtd);
        }
        return false;
    }

    public double render(){
        saldo += (saldo * taxaJuros);
        return saldo;
    }
}