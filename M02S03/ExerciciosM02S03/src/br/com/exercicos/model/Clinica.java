package br.com.exercicos.model;

public class Clinica {
    private Integer id;
    private String nomeClinica;
    private String logradouro;
    private String nroLogradouro;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeClinica() {
        return nomeClinica;
    }

    public void setNomeClinica(String nomeClinica) {
        this.nomeClinica = nomeClinica;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNroLogradouro() {
        return nroLogradouro;
    }

    public void setNroLogradouro(String nroLogradouro) {
        this.nroLogradouro = nroLogradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Clinica(Integer id, String nomeClinica, String logradouro, String nroLogradouro, String bairro, String complemento, String cidade, String estado) {
        this.id = id;
        this.nomeClinica = nomeClinica;
        this.logradouro = logradouro;
        this.nroLogradouro = nroLogradouro;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Clinica() {
    }

    public Double calculaIMC(Double altura, Double peso){
        return peso / Math.pow(altura,2d);
    }

    public void tabelaIMC(Double altura, Double peso){

        if(calculaIMC(altura,peso)<=18.5) {
            System.out.println("Abaixo do peso");
        }else if (calculaIMC(altura,peso)<=24.0) {
            System.out.println("Peso ideal");
        } else if (calculaIMC(altura,peso)<=29.9) {
            System.out.println("Levemente acima do peso");
        } else if (calculaIMC(altura,peso)<=34.9) {
            System.out.println("Obesidade grau I");
        } else if (calculaIMC(altura,peso)<=39.9) {
            System.out.println("Obesidade grau II");
        } else if (calculaIMC(altura,peso)>=40) {
            System.out.println("Obesidade grau III");
        }
    }

    @Override
    public String toString() {
        return "ClinicaModel{" +
                "id=" + id +
                ", nomeClinica='" + nomeClinica + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", nroLogradouro='" + nroLogradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

