package br.com.fiap.apicredmail.dto.enums;

import lombok.Getter;

@Getter
public enum CadastroUsuarioEnum {
    EXISTE(0,"Usuario já está cadastrado"),
    INCORRETO(1,"Senha incorreta"),
    SUCESSO(2,"Cadastrado com sucesso");


    private Integer id;
    private String texto;
    CadastroUsuarioEnum(Integer id, String texto) {
        this.id=id;
        this.texto=texto;
    }
}
