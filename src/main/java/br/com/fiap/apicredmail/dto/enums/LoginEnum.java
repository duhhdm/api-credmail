package br.com.fiap.apicredmail.dto.enums;

import lombok.Getter;

@Getter
public enum LoginEnum {
    INEXISTENTE(0,"Usuario nao existe"),
    SUCESSO(1,"Usuario logado"),
    INCORRETO(2, "Senha incorreta");

    private Integer id;
    private String texto;

    LoginEnum(Integer id,String texto){
        this.id=id;
        this.texto=texto;
    }
}
