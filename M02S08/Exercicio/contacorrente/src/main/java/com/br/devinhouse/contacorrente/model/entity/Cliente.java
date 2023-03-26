package com.br.devinhouse.contacorrente.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.core.serializer.Serializer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "CLIENTES")
@Data
@ToString
@EqualsAndHashCode
public class Cliente implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CPF")
    private Long cpf;
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Column(name = "NROLOGRADOURO")
    private String nroLogradouro;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "UF")
    private String uf;
    @Column(name = "ATIVO")
    private Integer ativo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DTACREATED", updatable=false)
    @CreationTimestamp
    private Date dtaCreated;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DTAUPDATE")
    @UpdateTimestamp
    private Date dtaUpdate;

}
