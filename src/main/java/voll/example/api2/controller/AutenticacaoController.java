package voll.example.api2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import voll.example.api2.domain.usuario.DadosAutenticaco;
import voll.example.api2.domain.usuario.Usuario;
import voll.example.api2.infra.security.TokenDadosJWT;
import voll.example.api2.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager maneger;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDadosJWT> efetuarLogin(@RequestBody @Valid DadosAutenticaco dados){
        var autenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autentication = maneger.authenticate(autenticationtoken);
        var tokenJWT = tokenService.gerarToken((Usuario)autentication.getPrincipal());
        return ResponseEntity.ok(new TokenDadosJWT(tokenJWT));
    }
}
