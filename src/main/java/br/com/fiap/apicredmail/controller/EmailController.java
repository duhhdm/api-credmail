package br.com.fiap.apicredmail.controller;

import br.com.fiap.apicredmail.dto.SaidaDTOReq;
import br.com.fiap.apicredmail.model.EnvioDTORes;
import br.com.fiap.apicredmail.model.SaidaDTORes;
import br.com.fiap.apicredmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("email")
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("entrada/{id}")
    public ResponseEntity buscarPorEmail(@PathVariable Long id){
        return ResponseEntity.ok(emailService.buscaEmail(id));
    }
    @PostMapping("saida")
    public ResponseEntity<EnvioDTORes> salvarEmail(@RequestBody SaidaDTOReq saidaDTOReq){
        emailService.salvarEmailSaida(saidaDTOReq);
        return ResponseEntity.ok(new EnvioDTORes(1,"Enviado"));
    }
    @GetMapping("saida/{id}")
    public ResponseEntity<List<SaidaDTORes>> buscarEmails(@PathVariable Long id){
        return ResponseEntity.ok(emailService.buscarEmailEnviado(id));
    }
}
