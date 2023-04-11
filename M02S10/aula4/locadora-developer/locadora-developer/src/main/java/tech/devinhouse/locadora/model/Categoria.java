package tech.devinhouse.locadora.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "CATEGORIA")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCATEGORIA", insertable = false)
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,
            //cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            mappedBy = "categorias")
    private List<Filme> filmes ;


}
