package banco;

import repository.ContaRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainBanco {

    public static void main(String[] args) throws IOException {

        Agencia agencia = new Agencia("Agencia Laranja");
        ContaRepository contaRepository = new ContaRepository();


        for (int i=0; i<3; i++){
        Cliente cliente = new Cliente();
        Conta conta = new Conta();

            Scanner scanner = new Scanner(System.in);

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.println("----------------------------------------");
            System.out.print("Informe o nome do cliente:");
            cliente.setNomeCliente(br.readLine());

            System.out.print("Informe o cpf do cliente:");
            cliente.setCpfCliente(br.readLine());

            System.out.print("Informe a idade do cliente:");
            cliente.setIdadeCliente(scanner.nextInt());

            System.out.print("Informe o nome da conta:");
            conta.setNomeConta(br.readLine());

            System.out.print("Informe o Saldo:");
            conta.setSaldoConta(scanner.nextDouble());

            System.out.print("Informe o NroConta:");
            conta.setNumeroConta(scanner.nextInt());

            conta.setCliente(cliente);

            contaRepository.addConta(conta);

        }

        contaRepository.retornoConta();
    }
}
