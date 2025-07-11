package com.example.api_usuarios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.api_usuarios.models.entities.Usuario;
import com.example.api_usuarios.repositories.UsuarioRepository;
import com.example.api_usuarios.services.UsuarioService;

@SpringBootTest
@AutoConfigureMockMvc
class UsuarioServiceTest {

	@Mock
	private UsuarioRepository usuarioRepository;	

	@InjectMocks
	private UsuarioService usuarioService;

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void Cuando_se_llama_a_usuario_Entonces_el_estado_es_200() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuario/")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}



}
