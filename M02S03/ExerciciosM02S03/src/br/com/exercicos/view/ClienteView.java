package br.com.exercicos.view;

import br.com.exercicos.controller.ClienteController;
import br.com.exercicos.model.Cliente;

import java.util.Scanner;

public class ClienteView {

    Scanner scanner = new Scanner(System.in);
    ClienteController clienteController = new ClienteController();
    Cliente cliente = new Cliente();
    public void cadastroCliente(){

        System.out.print("Nome do Cliente:");
        cliente.setNome(scanner.nextLine());
        System.out.print("Peso:");
        cliente.setPeso(scanner.nextDouble());
        System.out.print("Altura:");
        cliente.setAltura(scanner.nextDouble());
        System.out.print("Idade:");
        cliente.setIdade(scanner.nextInt());
        scanner = new Scanner(System.in);

        if(clienteController.cadastroCliente(cliente)
        ){
            System.out.println("Pessoa Cadastrada");
        }else{
            System.out.println("Erro ao Cadastrar a Pessoa");
        }

    }

    public void listaCliente(){

        if(clienteController.listaCliente().isEmpty()){
            System.out.println("--------------------------------------------------------");
            System.out.println("Não tem clientes cadastrados");
            System.out.println("--------------------------------------------------------");
            return;
        }

        System.out.println("--------------------------------------------------------");
        System.out.println("Clientes cadastrados");
        System.out.println("--------------------------------------------------------");
        clienteController.listaCliente().forEach(elemen ->{
                System.out.println(elemen.getId()+" "+elemen.getNome()+" "+elemen.getPeso()+" "+elemen.getAltura()+" "+elemen.getIdade()+" ");
                System.out.println("--------------------------------------------------------");
        });
    }
}

