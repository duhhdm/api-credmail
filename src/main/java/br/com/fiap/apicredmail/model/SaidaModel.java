package br.com.fiap.apicredmail.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbEmailEnviado")
@Getter
@Setter
@AllArgsConstructor
public class SaidaModel {@Id
    @Column(name = "idEmail")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="dsPara")
    private String para;
    @Column(name="dsTitulo")
    private String titulo;
    @Column(name="dsConteudo")
    private String conteudo;
    @Column(name="flSpam")
    private Boolean spam;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private UsuarioModel usuarioModel;

    public SaidaModel() {

    }

    public SaidaModel(String para, String titulo, String conteudo, boolean spam, UsuarioModel usuarioModel) {
        this.para=para;
        this.titulo=titulo;
        this.conteudo=conteudo;
        this.spam=spam;
        this.usuarioModel= usuarioModel;
    }
}
