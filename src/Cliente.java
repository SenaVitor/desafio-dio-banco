public class Cliente{
    private String nome;
    final private String cpf;
    private int idade;

    Cliente(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    void listar(){
        System.out.println("Cliente: " + nome + " Idade: " + idade + " Cpf: " + cpf);
    }

    String getNome(){
        return nome;
    }
    String getCpf(){
        return cpf;
    }
    int getIdade(){
        return idade;
    }
}