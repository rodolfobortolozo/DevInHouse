import java.util.ArrayList;

public class Pessoa {
    String nome;
    ArrayList<Pessoa> listaAmigos = new ArrayList<>();
    Integer idade = 10;
    Integer altura = 2;
    Boolean statusCasado = false;

    Pessoa(String nome, Integer idade, Boolean statusCasado){
        this.nome = nome;
        this.idade = idade;
        this.statusCasado = statusCasado;
        System.out.println("Construtor executado");


    }

    Pessoa (String nome, Integer idade){
        this.nome = nome;
        this.idade = idade;
    }

    Pessoa (){
        this.nome = "BBBB";
        this.idade = -1;
    }

    public Integer envelhecer(){
        return this.idade+=1;
    }
}
