package org.senai.devinhouse.magazinesenaispringdata.service;

import org.senai.devinhouse.magazinesenaispringdata.model.Produto;
import org.senai.devinhouse.magazinesenaispringdata.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  private final ProdutoRepository produtoRepository;

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }


  public void saveProduto(Produto produto){
      this.produtoRepository.save(produto);
  }
}
