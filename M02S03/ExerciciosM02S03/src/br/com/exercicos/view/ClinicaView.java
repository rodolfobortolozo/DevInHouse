package br.com.exercicos.view;

import br.com.exercicos.controller.ClinicaController;

import java.util.Scanner;

public class ClinicaView {
    Scanner scanner = new Scanner(System.in);
    ClinicaController clinicaController = new ClinicaController();

    public void cadastroClinica(){

        System.out.print("Código da Clinica:");
        Integer id = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.print("Nome Clinica:");
        String nomeClinica = scanner.nextLine();
        System.out.print("Logradouro:");
        String logradouro = scanner.nextLine();
        System.out.print("Número:");
        String nroLogradouro = scanner.nextLine();
        System.out.print("Bairro:");
        String bairro = scanner.nextLine();
        System.out.print("Complemento:");
        String complemento = scanner.nextLine();
        System.out.print("Cidade:");
        String cidade = scanner.nextLine();
        System.out.print("Estado:");
        String estado = scanner.nextLine();

        if(clinicaController.cadastroClinica(id ,nomeClinica, logradouro, nroLogradouro,
                        bairro, complemento, cidade, estado)
        ){
            System.out.println("Clinica Cadastrada");
        }else{
            System.out.println("Erro ao Cadastrar a Clinuca");
        }


    }

    public void retornaClinica(){
        clinicaController.retornaClinica();
    }

    /*
        this.id = id;
        this.nomeClinica = nomeClinica;
        this.logradouro = logradouro;
        this.nroLogradouro = nroLogradouro;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
     */

}
