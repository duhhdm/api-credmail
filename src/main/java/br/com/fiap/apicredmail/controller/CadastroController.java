package br.com.fiap.apicredmail.controller;

import br.com.fiap.apicredmail.dto.CadastroRequestDto;
import br.com.fiap.apicredmail.dto.CadastroResponseDto;
import br.com.fiap.apicredmail.dto.enums.CadastroUsuarioEnum;
import br.com.fiap.apicredmail.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("cadastro")
@RestController
public class CadastroController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<CadastroResponseDto> cadastroUsuario(@RequestBody CadastroRequestDto body){
        return ResponseEntity.ok(usuarioService.cadastroUsuario(body));
    }

    @GetMapping
    public CadastroUsuarioEnum testeEnum(){
        return CadastroUsuarioEnum.EXISTE;
    }
}
