package br.com.fiap.apicredmail.controller;

import br.com.fiap.apicredmail.dto.LoginRequestDto;
import br.com.fiap.apicredmail.dto.UsuarioResponseDTO;
import br.com.fiap.apicredmail.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> logarUsuario
            (@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(loginService.buscarUsuario(loginRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioLogado(@PathVariable Long id){
        return ResponseEntity.ok(loginService.findUsuarioLogado(id));
    }

}
