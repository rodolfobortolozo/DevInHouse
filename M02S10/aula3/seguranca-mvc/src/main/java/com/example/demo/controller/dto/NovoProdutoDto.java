package com.example.demo.controller.dto;

import com.example.demo.model.Produto;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class NovoProdutoDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotBlank
    private String valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Produto toProduto(){
        Produto produto = new Produto();
        produto.setDescricao(this.descricao);
        produto.setNome(this.nome);
        produto.setValor(Double.parseDouble(this.valor));
        return produto;
    }

}
