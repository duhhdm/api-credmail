package br.com.fiap.apicredmail.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cores")
public class CoresController {

    @GetMapping("ola")
    public String helloWord(){
        return "ola mundo";
    }
}
