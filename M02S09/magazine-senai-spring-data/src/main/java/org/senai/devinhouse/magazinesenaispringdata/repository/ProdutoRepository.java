package org.senai.devinhouse.magazinesenaispringdata.repository;

import org.senai.devinhouse.magazinesenaispringdata.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
