package br.com.fiap.apicredmail.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tbCategoria")
public class CategoriaCardsModel {
    @Id
    @Column(name = "idCategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nmCategoria")
    private String categoria;
    @Column(name="idImagemCategoria")
    private Integer imagem;
    @Column(name = "idCorImagem")
    private Integer corimagem;
    @Column(name = "idCorTexto")
    private Integer corTexto;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuarioModel;

    public CategoriaCardsModel(String categoria, Integer imagem, Integer corimagem, Integer corTexto, UsuarioModel usuarioModel) {
        this.categoria=categoria;
        this.imagem=imagem;
        this.corimagem=corimagem;
        this.corTexto=corTexto;
        this.usuarioModel = usuarioModel;
    }

    public CategoriaCardsModel() {

    }
}
