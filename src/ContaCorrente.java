public class ContaCorrente extends Conta{
    private final double limite = 1000;
    private double montanteDevedor = 0;

    ContaCorrente(Cliente cliente){
        super(cliente);
    }

    public boolean sacar(double qtd){
        if(getSaldo() < 0){
            if((montanteDevedor+qtd) <= limite*(-1)){
                super.sacar(qtd);
                montanteDevedor = getSaldo() * (-1);
                return true;
            }
        }else{
            if((getSaldo()-qtd) >= limite*(-1)){
                super.sacar(qtd);
                if(getSaldo() < 0) montanteDevedor = (getSaldo() * (-1));
                return true;
            }
        }
        return false;
    }

    public boolean depositar(double qtd){
        if(montanteDevedor > 0){
            if(montanteDevedor >= qtd){
                montanteDevedor -= qtd;
            }else{
                montanteDevedor = 0;
            }
        }
        return super.depositar(qtd);
    }

    public boolean transferir(double valor, Conta conta){
        if(getSaldo() < 0){
            if((montanteDevedor + valor) <= limite){
                montanteDevedor += getSaldo() * (-1);
                return super.transferir(valor, conta);
            }
        }else{
            if((getSaldo() - valor) >= limite * (-1)){
                boolean retorno = super.transferir(valor, conta);
                if(getSaldo() < 0) montanteDevedor += valor;
                return retorno;
            }
        }
        return false;
    }

    public void imprimirExtrato(){
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirExtrato();
    }

    public double getLimite(){
        return limite;
    }

    public double getMontanteDevedor(){
        return montanteDevedor;
    }
}