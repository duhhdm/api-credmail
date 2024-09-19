package br.com.fiap.apicredmail.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbEmailRecebido")
@Getter
@Setter
@AllArgsConstructor
public class EntradaModel {

    @Id
    @Column(name = "idEmail")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dsRemetente")
    private String remetente;
    @Column(name = "dsTitulo")
    private String titulo;
    @Column(name = "idCategoria")
    private Long categoria;
    @Column(name = "dsConteudo")
    private String conteudo;
    @Column(name = "flLido")
    private Boolean lido;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuarioModel;
    @Column(name = "corTexto")
    private Integer corTexto;
    @Column(name = "corCard")
    private Integer corCard;

    public EntradaModel() {

    }
}
