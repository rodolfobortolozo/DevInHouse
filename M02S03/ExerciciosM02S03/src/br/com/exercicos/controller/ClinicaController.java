package br.com.exercicos.controller;

import br.com.exercicos.model.Clinica;

public class ClinicaController {
    Clinica clinica = new Clinica();

    public boolean cadastroClinica(Integer id, String nomeClinica, String logradouro, String nroLogradouro,
                                   String bairro, String complemento, String cidade, String estado){

        try {
            clinica.setId(id);
            clinica.setNomeClinica(nomeClinica);
            clinica.setLogradouro(logradouro);
            clinica.setNroLogradouro(nroLogradouro);
            clinica.setBairro(bairro);
            clinica.setComplemento(complemento);
            clinica.setCidade(cidade);
            clinica.setEstado(estado);

            return true;

        }catch (Exception ex){

            return  false;
        }

    }

    public void retornaClinica(){
        System.out.println(clinica.toString());;
    }

    public void calculoIMC(Double peso, Double altura){
        Double imc = peso / (altura * altura);
        System.out.println(imc);
    }
}
