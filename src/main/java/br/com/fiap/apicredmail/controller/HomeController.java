package br.com.fiap.apicredmail.controller;

import br.com.fiap.apicredmail.dto.HomeDTO;
import br.com.fiap.apicredmail.service.HomeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/{id}")
    public ResponseEntity<HomeDTO> getHome(@PathVariable Long id){
        return ResponseEntity.ok(homeService.abrirHome(id));
    }
}
