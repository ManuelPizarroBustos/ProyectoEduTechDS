package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.api_usuarios.services.UsuarioService;

@SpringBootTest
public class UsuarioServiceTest {
    
    @Autowired
    private UsuarioService usuarioService;

}
