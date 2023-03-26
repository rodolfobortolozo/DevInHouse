package com.br.devinhouse.contacorrente.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "CONTAS")
@Data
@ToString
@EqualsAndHashCode
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NROCONTA")
    private String nroConta;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    //@JsonIgnore
    private Cliente  cliente;

    @Column(name = "SALDO")
    private Long saldo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DTACREATED", updatable=false)
    @CreationTimestamp
    private Date dtaCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DTAUPDATE")
    @UpdateTimestamp
    private Date dtaUpdate;

}
