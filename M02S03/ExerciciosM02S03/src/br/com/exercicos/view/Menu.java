package br.com.exercicos.view;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    ClinicaView clinicaView = new ClinicaView();
    ClienteView clienteVIEW = new ClienteView();
    String opcao ;
    public void menuPrincipal() throws InterruptedException, IOException {
        System.out.println("*********************Menu Principal*********************");
        System.out.println("1 - Cadastrar Clinica");
        System.out.println("2 - Dados da Clinica");
        System.out.println("3 - Cadastro de Cliente");
        System.out.println("4 - Retorna Clientes");
        System.out.println("9 - Sair");
        System.out.print("Informa a Opção:");
        opcao = scanner.nextLine();

        switch (opcao){
            case "1":
                clinicaView.cadastroClinica();
                menuPrincipal();
                break;

            case "2":
                clinicaView.retornaClinica();
                menuPrincipal();
                break;

            case "3":
                clienteVIEW.cadastroCliente();
                menuPrincipal();
                break;

            case "4":
                clienteVIEW.listaCliente();
                menuPrincipal();
                break;

            case "9":
                System.exit(0);

            default:
                System.out.println("Opção Inválida");
                menuPrincipal();
        }

    }
}
