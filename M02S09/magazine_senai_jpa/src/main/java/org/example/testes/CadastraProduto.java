package org.example.testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Produto;

public class CadastraProduto {

    public static void main(String[] args) {
        Produto produto = new Produto();

        produto.setNome("Curso Java");
        produto.setDescricao("Curso de linguagem Java");
        produto.setPreco(500);
        produto.setQtdEstoque(50);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("magazine_senai");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }
}
