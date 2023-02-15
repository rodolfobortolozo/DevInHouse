package banco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainBanco {

    public static void main(String[] args) throws IOException {

        String nome;
        String cpf;
        String nomeConta;
        int idade;
        Double saldoConta;
        Integer nroConta;

        Agencia agencia = new Agencia("Agencia Laranja");

        for (int i=0; i<5; i++){

            Scanner scanner = new Scanner(System.in);

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            //System.out.println("Digite algo:");
            //String read = br.readLine();

            //System.out.println(read);

            System.out.print("Informe o nome do cliente:");
            nome = br.readLine();

            System.out.print("Informe o cpf do cliente:");
            cpf = br.readLine();

            System.out.print("Informe a idade do cliente:");
            idade = scanner.nextInt();

            System.out.print("Informe o nome da conta:");
            nomeConta = br.readLine();;

            System.out.print("Informe o Saldo:");
            saldoConta = scanner.nextDouble();

            System.out.print("Informe o NroConta:");
            nroConta = scanner.nextInt();

            Cliente cliente = new Cliente(nome, cpf, idade);

            Conta conta = new Conta(nomeConta, saldoConta, nroConta, cliente, agencia);

            System.out.println(agencia);
            System.out.println(cliente);
            System.out.println(conta);



        }
    }
}
