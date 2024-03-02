package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtUtils;
import com.example.demo.service.to.EstudianteTO;

@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class TokenControllerResFul {

    private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping(path = "/obtener/{semilla}/{tiempo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    private String getToken(@RequestBody EstudianteTO usuarioTO, @PathVariable String semilla, @PathVariable int tiempo) {
        LOG.info(usuarioTO.getPassword());
        this.authenticated(usuarioTO.getUsername(), usuarioTO.getPassword());
        return this.jwtUtils.generateJwtToken(usuarioTO.getUsername(),semilla, tiempo);
    }

    private void authenticated(String username, String password) {
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}