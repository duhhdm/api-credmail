package br.com.fiap.apicredmail.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tbUsuario")
@Getter
@Setter
@AllArgsConstructor
public class UsuarioModel {

    public UsuarioModel(){
        /* TODO document why this constructor is empty */
    }

    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nmUsuario")
    private String nome;

    @Column(name = "ds_Email", unique = true)
    private String email;

    @Column(name = "password")
    private String senha;

    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EntradaModel> emailsEntrada;

    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CategoriaCardsModel> categoriaCardsModels;

    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SaidaModel> saidaModels;


    public UsuarioModel(String nome, String email, String password) {
        this.nome=nome;
        this.email=email;
        this.senha=password;
    }
}
