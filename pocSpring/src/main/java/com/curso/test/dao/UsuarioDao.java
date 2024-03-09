package com.curso.test.dao;

import java.util.List;

import com.curso.test.models.Usuario;

public interface UsuarioDao <UserType,IntegerType> {

	void registrar(UserType input);

	List<UserType> getUsuarios();
	
	<GENERIC_USER_TYPE> List<GENERIC_USER_TYPE> getUsuariosV2();

	void eliminar(IntegerType id);

	UserType verificarCredenciales(UserType usuario);

	void modificar(IntegerType id);
}