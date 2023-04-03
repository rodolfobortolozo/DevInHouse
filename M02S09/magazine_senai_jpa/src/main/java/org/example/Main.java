package org.example;

import org.example.dtos.ProdutoDTO;
import org.example.models.Produto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Exemplo de para que serve um DTO.

        List<Produto> produtos = new ArrayList<>();

        // a linha abaixo está incorreta, coloquei apenas para ilustrar um SELECT na base buscando os Produtos.
        // produtos = em.retrieve("Produto");

        List<ProdutoDTO> produtosDTO = new ArrayList<>();

        // dentro desse for percorremos a lista de produtos da base e
        // preenchemos a lista de DTOs para retornar para o usuário
        for (Produto prod : produtos) {
            ProdutoDTO prodDTO = new ProdutoDTO();
            prodDTO.setId(prod.getId());
            prodDTO.setNome(prod.getNome());
            prodDTO.setDescricao(prod.getDescricao());

            produtosDTO.add(prodDTO);
        }

        // a linha abaixo está incorreta, serve apenas para ilustrar uma resposta para o usuário
        // return produtosDTO;
    }
}