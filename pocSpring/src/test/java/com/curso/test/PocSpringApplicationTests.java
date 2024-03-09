package com.curso.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.test.dao.UsuarioDao;
import com.curso.test.models.Usuario;

@SpringBootTest
class PocSpringApplicationTests {

	@Autowired
	UsuarioDao userInstance;
	
	@Test
	public void testGetUsuario() {
		
		List<Usuario> result= userInstance.getUsuarios();
		
		Assertions.assertTrue(result instanceof List);
		Assertions.assertTrue(result.size() > 0); // Ensure the list is not empty
		Assertions.assertTrue(result.get(0) instanceof Usuario);
		
	}

}
