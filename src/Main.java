public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Vitor", "07898776545", 20);
        ContaCorrente cc = new ContaCorrente (c1);
        ContaPoupanca cp = new ContaPoupanca(c1);
        cc.depositar(100);
        cc.transferir(90, cp);
        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}